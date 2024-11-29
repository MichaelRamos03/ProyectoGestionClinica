/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Estructuras.ColaPrioridad;
import Estructuras.ListaCircular;
import Modelo.Empleado;
import Modelo.Recepcion;
import ModeloDao.RecepcionDao;
import Vista.VistaFormularioRecepcion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author karla
 */
public class ControladorFormularioRecepcion extends MouseAdapter implements ActionListener, MouseListener {

    private VistaFormularioRecepcion vistaFormulario;
    private ControladorRecepcion controladorRecepcion;
    private ColaPrioridad<Recepcion> recepcionColaPrioridad;
    private RecepcionDao recepcionDao;
    private Recepcion recepcionSeleccionada;

    
    // 
    public ControladorFormularioRecepcion(VistaFormularioRecepcion vistaFormulario, ControladorRecepcion controladorRecepcion, ColaPrioridad<Recepcion> colaPrioridad) {
        this.vistaFormulario = vistaFormulario;
        this.vistaFormulario.setVisible(true);
        this.vistaFormulario.setDefaultCloseOperation(vistaFormulario.DISPOSE_ON_CLOSE);
        this.vistaFormulario.btnGuardar.addActionListener(this);
        this.vistaFormulario.ComboEnfermera.addActionListener(this);
        this.vistaFormulario.setLocationRelativeTo(null);
        this.controladorRecepcion = controladorRecepcion;
        this.recepcionColaPrioridad = colaPrioridad;
        this.recepcionDao = new RecepcionDao();

       
        
        llenarComboPrioridades();
        llenarComboEnfermeras();
    }

    // para modificar la recepcion
    public ControladorFormularioRecepcion(VistaFormularioRecepcion vistaFormulario, ControladorRecepcion controladorRecepcion, ColaPrioridad<Recepcion> recepcionColaPrioridad, Recepcion recepcionModificada) {
        this.vistaFormulario = vistaFormulario;
        this.vistaFormulario.setVisible(true);
        this.vistaFormulario.txtIdRecepcion.setEditable(false);
        this.controladorRecepcion = controladorRecepcion;
        this.recepcionColaPrioridad = recepcionColaPrioridad;
        this.recepcionSeleccionada = recepcionModificada;
        this.vistaFormulario.setDefaultCloseOperation(vistaFormulario.DISPOSE_ON_CLOSE);
        this.vistaFormulario.btnGuardar.addActionListener(this);
        this.vistaFormulario.ComboEnfermera.addActionListener(this);
        this.vistaFormulario.setLocationRelativeTo(null);
        this.recepcionDao = new RecepcionDao();
        
        llenarComboPrioridades();
        llenarComboEnfermeras();
        llenarVistaRecepcion();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaFormulario.btnGuardar) {
            guardar();
        }

    }

    public void llenarComboPrioridades() {
        this.vistaFormulario.ComboPrioridades.removeAllItems();
        this.vistaFormulario.ComboPrioridades.addItem("Maxima Urgencia");
        this.vistaFormulario.ComboPrioridades.addItem("Alta");
        this.vistaFormulario.ComboPrioridades.addItem("Media");
        this.vistaFormulario.ComboPrioridades.addItem("Baja");

    }

    public void llenarComboEnfermeras() {
        this.vistaFormulario.ComboEnfermera.removeAllItems();
        ListaCircular<Empleado> empleadoList = this.recepcionDao.getEmpleadosCombo();
        for (Empleado empleado : empleadoList.toArray()) {
            // combo cambiado desde vista para que acepte objetos de tipo empleado
            // asi de una vez se puede agregar el objeto pero se tiene que modificar el to String en empleado para que pueda mostrar lo que quiero
            this.vistaFormulario.ComboEnfermera.addItem(empleado);
        }
    }

    public String prioridad(int seleccion) {
        switch (seleccion) {
            case 1:
                return "Alta";
            case 2:
                return "Media";
            case 3:
                return "Baja";
            default:
                return "Maxima Urgencia";
        }
    }

    /*

     */
    public void guardar() {
        String idRecepcion = this.vistaFormulario.txtIdRecepcion.getText();
        String presion = this.vistaFormulario.txtPresion.getText();
        String altura = this.vistaFormulario.txtAltura.getText();
        String peso = this.vistaFormulario.txtPeso.getText();
        String temperatura = this.vistaFormulario.txtTemperatura.getText();
        String frecuenciaCardiaca = this.vistaFormulario.txtFrecuenciaCardiaca.getText();
        String motivoVisita= this.vistaFormulario.textAreaMotivoVisita.getText();
        String Observaciones= this.vistaFormulario.textAreaObservaciones.getText();
        int seleccion = this.vistaFormulario.ComboPrioridades.getSelectedIndex();
        //this.frmMascota.cmbDueño.getSelectedItem().toString())

       // Obtener el objeto Empleado seleccionado
    Empleado empleadoSelec = (Empleado) this.vistaFormulario.ComboEnfermera.getSelectedItem();
    
    // Usar el objeto Empleado como lo necesites
    int idEmpleado = empleadoSelec.getIdEmpleado();
    
      if(validarCampos(idRecepcion,presion,altura,peso,temperatura,frecuenciaCardiaca,motivoVisita,Observaciones)){
        Recepcion nuevaRecepcion = new Recepcion();
        nuevaRecepcion.setIdRecepcion(Integer.parseInt(idRecepcion));
        nuevaRecepcion.setPresion(presion);
        nuevaRecepcion.setAltura(altura);
        nuevaRecepcion.setPeso(peso);
        nuevaRecepcion.setTemperatura(temperatura);
        nuevaRecepcion.setFrecuenciaCardiaca(Integer.parseInt(frecuenciaCardiaca));
        nuevaRecepcion.setMotivoVisita(motivoVisita);
        nuevaRecepcion.setObservaciones(Observaciones);
        nuevaRecepcion.setPrioridad(prioridad(seleccion));
        nuevaRecepcion.setEmpleado(empleadoSelec);
        
        
        if(this.recepcionSeleccionada==null){
            if(!this.recepcionDao.verificarExiste(nuevaRecepcion.getIdRecepcion())){
             this.recepcionDao.insert(nuevaRecepcion);
             this.vistaFormulario.dispose();
        }else{
                JOptionPane.showMessageDialog(null, "Este registro  con la id :"+nuevaRecepcion.getIdRecepcion()+"ya existe");
            }
             
        }else{ // para actualizar
            this.recepcionDao.update(nuevaRecepcion);
            this.vistaFormulario.dispose();
        }

      }
          
      
       
        // para que se active si esta modificando la recepcion
        this.vistaFormulario.txtIdRecepcion.setEditable(true);
        this.controladorRecepcion.mostrarDatos();
        

// insertarValidaciones posteriormente
    }
    
    
    
    private void llenarVistaRecepcion(){
        
        System.out.println("Id Recepcion:" + this.recepcionSeleccionada.getIdRecepcion());
        
        this.vistaFormulario.txtIdRecepcion.setText(String.valueOf(this.recepcionSeleccionada.getIdRecepcion()));
        this.vistaFormulario.txtPresion.setText(this.recepcionSeleccionada.getPresion());
        this.vistaFormulario.txtAltura.setText(this.recepcionSeleccionada.getAltura());
        this.vistaFormulario.txtPeso.setText(this.recepcionSeleccionada.getPeso());
        this.vistaFormulario.txtFrecuenciaCardiaca.setText(String.valueOf(this.recepcionSeleccionada.getFrecuenciaCardiaca()));
        this.vistaFormulario.txtTemperatura.setText(this.recepcionSeleccionada.getTemperatura());
        this.vistaFormulario.textAreaMotivoVisita.setText(this.recepcionSeleccionada.getMotivoVisita());
        this.vistaFormulario.textAreaObservaciones.setText(this.recepcionSeleccionada.getObservaciones());
        // esto funciona si previamente se cargó el comboBox de ambos sino no va funcionar correctamente
        this.vistaFormulario.ComboEnfermera.setSelectedItem(this.recepcionSeleccionada.getEmpleado());
        this.vistaFormulario.ComboPrioridades.setSelectedItem(this.recepcionSeleccionada.getPrioridad());
        System.out.println("PRIORIDAD SELECCIONADA :"+this.recepcionSeleccionada.getPrioridad());
    }
    
    
    // falta completar validaciones
    public Boolean validarCampos(String id,String presion,String altura,String peso,String temperatura,String FrecuenciaCar,String MotivoV,String Obs){
        id = id.replace(" ", "");
        if(id.equals("") || id.isEmpty()){
            JOptionPane.showMessageDialog(null,"Id Vacío, Ingrese un id");       
            return false;
        }
        presion= presion.replace(" ", "");
        if(presion.equals("") || presion.isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo de presion Vacío, ingrese un campo");
            return false;
        }
        
        altura= altura.replace(" ", "");
        if(altura.equals("") || altura.isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo de altura vacío, Ingrese una altura");
            return false;
        }
        
        peso= peso.replace(" ", "");
        if(peso.equals("") || peso.isEmpty()){
             JOptionPane.showMessageDialog(null, "Campo de peso vacío, Ingrese un peso");
            return false;
            
        }
        
        temperatura = temperatura.replace(" ", "");
        if(temperatura.equals("") || temperatura.isEmpty()){
             JOptionPane.showMessageDialog(null, "Campo de temperatura vacío, Ingrese una temperatura");
            return false;
        }
        
        FrecuenciaCar= FrecuenciaCar.replace(" ", "");
        if(FrecuenciaCar.equals("") || FrecuenciaCar.isEmpty()){
             JOptionPane.showMessageDialog(null, "Campo de Frecuencia cardiaca vacío, Ingrese una Frecuencia cardiaca");
            return false;
        }
        
        MotivoV = MotivoV.replace(" ", "");
        if(MotivoV.equals("") || MotivoV.isEmpty()){
             JOptionPane.showMessageDialog(null, "Campo de Motivo visita vacío, Ingrese un motivo de visita");
            return false;
        }
       
        Obs= Obs.replace(" ", "");
        if(Obs.equals("") || Obs.isEmpty()){
            
             JOptionPane.showMessageDialog(null, "Campo de Observaciones vacío, Ingrese una Observacion o escriba [Ninguna]");
            return false;
        }
        
        
        return true;
    }
   
}
