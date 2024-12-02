/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Estructuras.Cola;
import Estructuras.ColaPrioridad;
import Estructuras.ListaCircular;
import Estructuras.ListaDoble;
import Modelo.Empleado;
import Modelo.Usuario;
import ModeloDao.EmpleadoDao;
import ModeloDao.UsuarioDao;
import Vista.VistaFormularioUsuario;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import Utilidades.Encriptar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaby Lainez
 */
public class ControladorVistaFormularioUsuario extends MouseAdapter implements ActionListener, MouseListener {

    VistaFormularioUsuario vistFormulario;
    ControladorVistaUsuario crtVistaUsuario;
    Usuario usuario, UsuarioSeleccionado;
    UsuarioDao daoUsuario;

    EmpleadoDao daoEmpleado;

    public ControladorVistaFormularioUsuario(VistaFormularioUsuario vistFormulario, ControladorVistaUsuario crtVistaUsuario) {
        this.crtVistaUsuario = crtVistaUsuario;
        this.vistFormulario = vistFormulario;
        this.daoUsuario = new UsuarioDao();
        this.daoEmpleado = new EmpleadoDao();
        this.UsuarioSeleccionado = null;
        this.vistFormulario.btnGuardarUsuario.addActionListener(this);
        comboEmpleado();
    }
    
     public ControladorVistaFormularioUsuario( ControladorVistaUsuario crtVistaUsuario,VistaFormularioUsuario vistFormulario,Usuario  UsuarioSeleccionado) {
        this.crtVistaUsuario = crtVistaUsuario;
        this.vistFormulario = vistFormulario;
        this.daoUsuario = new UsuarioDao();
        this.daoEmpleado = new EmpleadoDao();
        this.UsuarioSeleccionado = UsuarioSeleccionado;
        this.vistFormulario.btnGuardarUsuario.addActionListener(this);
        comboEmpleado();
        llenarVista();
    }

    public void guardar() {

        if (!this.vistFormulario.txtNombreUsuario.getText().isEmpty()
                && !this.vistFormulario.txtContraseña.getText().isEmpty()
                && this.vistFormulario.comboEmpledo.getSelectedIndex() != 0) {

            if (this.UsuarioSeleccionado == null) {
                nuevoUsuario();
            } else {
                editar();
            }

        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Faltan Datos o Inserte datos validos",
                    DesktopNotify.ERROR, 3000);
        }
    }

    public void nuevoUsuario() {

        ListaDoble<Empleado> lista = this.daoEmpleado.selectAllTo("nombre", this.vistFormulario.comboEmpledo.getSelectedItem().toString());
        String contrasena = Encriptar.getStringMessageDigest(this.vistFormulario.txtContraseña.getText(), Encriptar.SHA256) ;
        
        
        this.usuario = new Usuario(
                this.vistFormulario.txtNombreUsuario.getText(),
                contrasena,
                new Empleado(lista.get(0).getIdEmpleado(),this.vistFormulario.comboEmpledo.getSelectedItem().toString())
        );

        if (this.daoUsuario.insert(usuario)) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("exito", "Expediente guardado",
                    DesktopNotify.ERROR, 3000);

            this.vistFormulario.dispose();
            this.crtVistaUsuario.mostrarUsuario(this.daoUsuario.selectAll());

            this.UsuarioSeleccionado = null;

        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "No guardo",
                    DesktopNotify.ERROR, 3000);

        }
    }
  public void comboEmpleado() {
        ListaDoble<Empleado> lista = this.daoEmpleado.selectAll();
        for (Empleado x : lista.toArray()) {
            this.vistFormulario.comboEmpledo.addItem(x.getNombre());
        }
    }
    
    private void editar() {

        ListaDoble<Empleado> lista = this.daoEmpleado.selectAllTo("nombre", this.vistFormulario.comboEmpledo.getSelectedItem().toString());

        this.UsuarioSeleccionado.setUsuario(this.vistFormulario.txtNombreUsuario.getText());
        this.UsuarioSeleccionado.setContrasenia(this.vistFormulario.txtContraseña.getText());
        this.UsuarioSeleccionado.setEmpleado(new Empleado(lista.get(0).getIdEmpleado(),this.vistFormulario.comboEmpledo.getSelectedItem().toString()));
//        this.empleadoSeleccionado.setPrioridad(this.vistaFormulario.cbPrioridad.getSelectedItem().toString());

        if (this.daoUsuario.update(UsuarioSeleccionado)) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("exito", "Actualizado",
                    DesktopNotify.ERROR, 3000);

            this.vistFormulario.dispose();
            this.crtVistaUsuario.mostrarUsuario(this.daoUsuario.selectAll());

            
        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "No guardo",
                    DesktopNotify.ERROR, 3000);
        }
    }
    
    

    public void llenarVista(){
        this.vistFormulario.txtNombreUsuario.setText(this.UsuarioSeleccionado.getUsuario());
        this.vistFormulario.txtContraseña.setText(this.UsuarioSeleccionado.getContrasenia());
        this.vistFormulario.comboEmpledo.setSelectedItem(this.UsuarioSeleccionado.getEmpleado().getNombre());
    }    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistFormulario.btnGuardarUsuario) {
            guardar();
        }
    }

}
