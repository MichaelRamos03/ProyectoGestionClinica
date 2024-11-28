package Controlador;

import Estructuras.ListaDoble;
import Modelo.Especialidad;
import ModeloDao.EspecialidadDao;
import Vista.VistaFormularioEspecialiad;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

/**
 *
 * @author Gaby Laínez
 */


public class ControladorFormularioEspecialidad extends MouseAdapter implements ActionListener, MouseListener {
   VistaFormularioEspecialiad vistaEspecialidad;
   ControladorConsultaVistaEspecialidad crtVista;
   EspecialidadDao daoEspecialidad;
   ListaDoble<Especialidad>lista;
   Especialidad especialidad,especialidadSeleccionada;

    public ControladorFormularioEspecialidad(VistaFormularioEspecialiad vistaEspecialidad, ControladorConsultaVistaEspecialidad crtVista) {
        this.vistaEspecialidad = vistaEspecialidad;
        this.crtVista = crtVista;
        this.daoEspecialidad = new  EspecialidadDao();
        this.lista = new ListaDoble<>();
        this.especialidadSeleccionada = null;
        this.vistaEspecialidad.btnGuardar.addActionListener(this);

    }
   
    public ControladorFormularioEspecialidad(VistaFormularioEspecialiad vistaEspecialidad,ControladorConsultaVistaEspecialidad crtVista,Especialidad especialidadSeleccionada) {
        this.crtVista = crtVista;
        this.vistaEspecialidad = vistaEspecialidad;
        this.daoEspecialidad = new  EspecialidadDao();
        this.lista = new ListaDoble<>();
        this.vistaEspecialidad.btnGuardar.addActionListener(this);
        this.especialidadSeleccionada = especialidadSeleccionada ;
        llenarVista();
    }
   
    public void guardarEspecialidad(){
        if(!this.vistaEspecialidad.txtEspecialidad.getText().isEmpty()){
           if(this.especialidadSeleccionada == null){
               nuevaEspecialidad();
           }else if(this.especialidadSeleccionada != null){
               editar();
           }
        }
    }
    
   private void  nuevaEspecialidad(){
       this.especialidad = new Especialidad(
       this.vistaEspecialidad.txtEspecialidad.getText());
       if(this.daoEspecialidad.insert(especialidad)){
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("exito", "Especialidad guardada",
            DesktopNotify.ERROR, 3000);
           this.vistaEspecialidad.dispose();
           this.crtVista.mostrarEspecialidad(daoEspecialidad.selectAll());
           this.especialidadSeleccionada = null;
           
       }else{
             DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "No se Guardo la especialidad",
            DesktopNotify.ERROR, 3000);
       }
   }
    
   private void editar(){
       this.especialidadSeleccionada.setEspecialidad(this.vistaEspecialidad.txtEspecialidad.getText());
          
        if (this.daoEspecialidad.update(especialidadSeleccionada)) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("exito", "Actualizado",
            DesktopNotify.ERROR, 3000);
            
            this.vistaEspecialidad.dispose();
            this.crtVista.mostrarEspecialidad(this.daoEspecialidad.selectAll());
        } else {
             DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "No guardo",
            DesktopNotify.ERROR, 3000);
        }
       
}
   
   private void llenarVista(){
       this.vistaEspecialidad.txtEspecialidad.setText(this.especialidadSeleccionada.getEspecialidad());
   }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vistaEspecialidad.btnGuardar){
            guardarEspecialidad();
        }
    }

}
