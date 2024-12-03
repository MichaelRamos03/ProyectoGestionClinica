/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.ControladorVistaFormularioUsuario;
import Estructuras.ABinarioBusqueda;
import Estructuras.Cola;
import Estructuras.ListaDoble;
import Modelo.Empleado;
import Modelo.Usuario;
import ModeloDao.UsuarioDao;
import RSMaterialComponent.RSSwitch;
import Vista.VistaFormularioUsuario;
import Vista.VistaUsuario;
import Vista.VistaFormularioUsuario;
import Vista.VistaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;
import Utilidades.Render;
import Vista.VistaFormularioEmpleado;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaby Lainez
 */
public class ControladorVistaUsuario extends MouseAdapter implements ActionListener, MouseListener {

    VistaUsuario vistaUsuario;
    UsuarioDao daoUsuario;
    Usuario UsuarioSeleccionado; 
   

    public ControladorVistaUsuario(VistaUsuario vistaUsuario) {
        this.vistaUsuario = vistaUsuario;
        this.daoUsuario = new UsuarioDao();
        this.vistaUsuario.btnAgregarUsuario.addActionListener(this);
        this.vistaUsuario.btnEditar.addActionListener(this);
        this.vistaUsuario.tblusuarios.addMouseListener(this);
        this.vistaUsuario.btnEliminar.addActionListener(this);
        this.vistaUsuario.btnBUscar.addActionListener(this);
        
        mostrarUsuario(daoUsuario.selectAll());   
    }
    
    public void mostrarUsuario(Cola<Usuario>lista){
        
        DefaultTableModel modelo;
        this.vistaUsuario.tblusuarios.setDefaultRenderer(Object.class, new Render());
        modelo = new DefaultTableModel();
        String titulo[]={"ID USUARIO","NOMBRE","CONTRASEÑA","ID EMPLEADO","DUI EMPLEADO","NOMBRE EMPLEADO"};
        modelo.setColumnIdentifiers(titulo);
        int i=0;
        
        for (Usuario x : lista.toArray()) {
            i++;
            Object dato[]={i,x.getUsuario(),x.getContrasenia(),x.getEmpleado().getIdEmpleado(),x.getEmpleado().getDui(),x.getEmpleado().getNombre()};
            modelo.addRow(dato);
        }
        this.vistaUsuario.tblusuarios.setModel(modelo);
        
    }
     private void modificar(){
         if (UsuarioSeleccionado != null) {
             
          VistaFormularioUsuario vi = new VistaFormularioUsuario();
         ControladorVistaFormularioUsuario c = new  ControladorVistaFormularioUsuario(this,vi,UsuarioSeleccionado);
         vi.setVisible(true);
         }
     }
    
     @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaUsuario.tblusuarios) {
            Cola<Usuario> lista = this.daoUsuario.selectAll();
            int colum = this.vistaUsuario.tblusuarios.getColumnModel().getColumnIndexAtX(e.getX());
            int row = this.vistaUsuario.tblusuarios.getSelectedRow();
            Object value = this.vistaUsuario.tblusuarios.getValueAt(row, colum);
            
            if (row >= 0) {
                this.UsuarioSeleccionado = lista.get(row);
                System.out.println("Fila seleccionada: " + row);
                System.out.println("Valor de la celda seleccionada: " + value);
                System.out.println("USUARIO seleccionado: " + this.UsuarioSeleccionado);
            } else {
         
            }
        }
    }
    
    private void eliminar() {

        int op = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar"
                + this.UsuarioSeleccionado.getIdUsuario());

        if (this.daoUsuario.delete(UsuarioSeleccionado)) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("OK", "Registro eliminado",
                    DesktopNotify.SUCCESS, 3000);
            mostrarUsuario(this.daoUsuario.selectAll());
        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "No se pudo eliminar",
                    DesktopNotify.ERROR, 3000);
        }
    }
    
    public void buscar(){
        if (!this.vistaUsuario.buscarUsuariolb.getText().isEmpty()) {
            DefaultTableModel modelo;
            this.vistaUsuario.tblusuarios.setDefaultRenderer(Object.class, new Render());
            modelo = new DefaultTableModel();
             String nombre = this.vistaUsuario.buscarUsuariolb.getText();
             
            // Obtener la lista de empleados desde el DAO
            ABinarioBusqueda<Usuario> listaBusqueda = daoUsuario.buscar();
            Usuario usuario = new  Usuario();
            
            // Establecer el ID del empleado a buscar
            usuario.setUsuario(nombre);
            
             // Buscar el empleado en el árbol binario
            if (listaBusqueda.buscar(usuario) != null) {
                usuario = (Usuario) listaBusqueda.buscar(usuario).getClave();
                // Definir los títulos de las columnas de la tabla
             String titulo[]={"NOMBRE","CONTRASEÑA","ID EMPLEADO",
                 "DUI EMPLEADO","NOMBRE EMPLEADO"};

                modelo.setColumnIdentifiers(titulo);
               
           Object dato[ ]= {usuario.getUsuario(),
               usuario.getContrasenia(),
               usuario.getEmpleado().getIdEmpleado(),
               usuario.getEmpleado().getDui(),
               usuario.getEmpleado().getNombre()};
     
                modelo.addRow(dato);
///
                // Mostrar los datos en la tabla
                this.vistaUsuario.tblusuarios.setModel(modelo);
                this.vistaUsuario.buscarUsuariolb.setText("");
            } else {
                 mostrarUsuario(this.daoUsuario.selectAll());
                JOptionPane.showMessageDialog(null, "DATO NO ENCONTRADO");
            }
        }else{
            JOptionPane.showMessageDialog(this.vistaUsuario, "campo vacío");
            mostrarUsuario(this.daoUsuario.selectAll());
        }
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vistaUsuario.btnAgregarUsuario ){
         VistaFormularioUsuario vi = new VistaFormularioUsuario();
         ControladorVistaFormularioUsuario c = new  ControladorVistaFormularioUsuario(vi,this);
         vi.setVisible(true);
        }else if(e.getSource() == this.vistaUsuario.btnEditar){
          modificar();  
        }else if(e.getSource() == this.vistaUsuario.btnEliminar){
            eliminar();
        }else if(e.getSource() == this.vistaUsuario.btnBUscar){
            buscar();
        }
    }
    
}
