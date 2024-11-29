package Controlador;

import Estructuras.ListaDoble;
import Modelo.Especialidad;
import ModeloDao.EspecialidadDao;
import Vista.VistaEspecialidad;
import Vista.VistaFormularioEspecialiad;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectoclase.utilidades.Render;

/**
 *
 * @author Gaby Laínez
 */
public class ControladorConsultaVistaEspecialidad extends MouseAdapter implements ActionListener, MouseListener{

    VistaEspecialidad vista;
    EspecialidadDao daoEspecialidad;
    Especialidad especialidadSeleccionada;

    public ControladorConsultaVistaEspecialidad(VistaEspecialidad vista) {
        this.vista = vista;
        this.daoEspecialidad = new EspecialidadDao();
        this.vista.setDefaultCloseOperation(vista.DISPOSE_ON_CLOSE);
        this.especialidadSeleccionada = null;
        this.vista.btnAgregarEspecialidad.addActionListener(this);
        this.vista.btnEditarEspecialidad.addActionListener(this);
        this.vista.btnEliminarEspecialidad.addActionListener(this);
        this.vista.tblEspecialidades.addMouseListener(this);
        mostrarEspecialidad(this.daoEspecialidad.selectAll());
    }
    
    public void mostrarEspecialidad(ListaDoble<Especialidad>lista){
         DefaultTableModel modelo; 
         this.vista.tblEspecialidades.setDefaultRenderer(Object.class, new Render());
         modelo = new  DefaultTableModel();
        String titulo [] ={"ID","NOMBRE ESPECIALIDAD"};
        modelo.setColumnIdentifiers(titulo);
        int i=0;
        
        for (Especialidad x : lista.toArray()) {
            i++;
            Object datos[] ={i,x.getEspecialidad()};
            modelo.addRow(datos);
        }
        this.vista.tblEspecialidades.setModel(modelo);
         
    }
     private void modificar() {
        if (this.especialidadSeleccionada != null) {
           VistaFormularioEspecialiad vistaFormulario= new VistaFormularioEspecialiad();
           ControladorFormularioEspecialidad ctl = new ControladorFormularioEspecialidad( vistaFormulario,this,especialidadSeleccionada);
            vistaFormulario.iniciar();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.vista.tblEspecialidades){
            ListaDoble<Especialidad>lista = this.daoEspecialidad.selectAll();
            int column = this.vista.tblEspecialidades.getColumnModel().getColumnIndexAtX(e.getX());
            int row = this.vista.tblEspecialidades.getSelectedRow();
            Object value = this.vista.tblEspecialidades.getValueAt(row, column);
            
            if(row >= 0){
                this.especialidadSeleccionada = lista.get(row);
                
            }else{
                this.vista.btnAgregarEspecialidad.setEnabled(false);
                this.vista.btnEditarEspecialidad.setEnabled(true);
                this.vista.btnEliminarEspecialidad.setEnabled(true);
            }
            
        }
    }
    
    private void eliminar() {

        int op = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar"
                + especialidadSeleccionada.getIdEspecialidad());

        if (daoEspecialidad.delete(especialidadSeleccionada)) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("OK", "Registro eliminado",
                    DesktopNotify.SUCCESS, 3000);
           mostrarEspecialidad(daoEspecialidad.selectAll());
        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "No se pudo eliminar",
                    DesktopNotify.ERROR, 3000);
        }
    }

     
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vista.btnAgregarEspecialidad){
            VistaFormularioEspecialiad vistaEspecialidad = new VistaFormularioEspecialiad();
            ControladorFormularioEspecialidad crtVista = new ControladorFormularioEspecialidad(vistaEspecialidad,this);
            vistaEspecialidad.iniciar();
        }else if(e.getSource() == this.vista.btnEditarEspecialidad){
            modificar();
        }else if(e.getSource() == this.vista.btnEliminarEspecialidad){
            eliminar();
        }
    }

}
