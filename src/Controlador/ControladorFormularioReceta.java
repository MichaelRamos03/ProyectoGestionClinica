package Controlador;

import Estructuras.Lista;
import Estructuras.ListaDoble;
import Modelo.Consulta;
import Modelo.Especialidad;
import Modelo.Receta;
import ModeloDao.ConsultaDao;
import ModeloDao.RecetaDao;
import Vista.VistaFomularioReceta;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

public class ControladorFormularioReceta extends MouseAdapter implements ActionListener,MouseListener{

    VistaFomularioReceta vistaFormulario;
    RecetaDao daoReceta;
    ConsultaDao daoConsulta;
    Receta receta, recetaSeleccionada;
    ControladorVistaReceta crtReceta;
    
    public ControladorFormularioReceta( ControladorVistaReceta crtReceta,VistaFomularioReceta vistaFormulario) {
        this.crtReceta = crtReceta;
        this.vistaFormulario = vistaFormulario;
        this.daoReceta = new RecetaDao();
        this.daoConsulta = new ConsultaDao();
        this.recetaSeleccionada = null;
        this.vistaFormulario.Btnguardar.addActionListener(this);
        comboConsulta();
    }
    
      public void guardarReceta(){
        
          int n = (int) this.vistaFormulario.spCantidad.getValue();
          int n2 = (int) this.vistaFormulario.spDosis.getValue();
          
        if(!this.vistaFormulario.txtIDReceta.getText().isEmpty() &&
                n>0 && n2>0 &&
           this.vistaFormulario.comboConsulta.getSelectedIndex() != 0){
            
           if(this.recetaSeleccionada == null){
               nuevaReceta();
           }else if(this.recetaSeleccionada != null){
              // editar();
           }
        }
    }
  private void  nuevaReceta(){
      Lista<Consulta> lista = this.daoConsulta.selectAllTo("diagnostico", this.vistaFormulario.comboConsulta.getSelectedItem().toString());      
       this.receta = new Receta(
               
        Integer.parseInt(this.vistaFormulario.txtIDReceta.getText()),
        (int) this.vistaFormulario.spCantidad.getValue(),
       (int) this.vistaFormulario.spDosis.getValue(),
       new Consulta(lista.get(0).getIdConsulta(),vistaFormulario.comboConsulta.getSelectedItem().toString()));

               
       if(this.daoReceta.insert(receta)){
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("exito", "Receta guardada",
            DesktopNotify.ERROR, 3000);
           this.vistaFormulario.dispose();
           crtReceta.mostrarReceta(daoReceta.selectAll());
           this.recetaSeleccionada = null;
           
       }else{
             DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "No se Guardo la especialidad",
            DesktopNotify.ERROR, 3000);
       }
   }
    
     public void comboConsulta() {
        Lista<Consulta> lista = daoConsulta.selectAll();
        for (Consulta x : lista.toArray()) {
            this.vistaFormulario.comboConsulta.addItem(String.valueOf(x.getDiagnostico()));
        }
    }  
  
  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vistaFormulario.Btnguardar){
            guardarReceta();
        }
    }

}
