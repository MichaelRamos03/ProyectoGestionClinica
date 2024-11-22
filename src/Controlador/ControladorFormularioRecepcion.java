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

/**
 *
 * @author karla
 */
public class ControladorFormularioRecepcion extends MouseAdapter implements ActionListener, MouseListener {

    private VistaFormularioRecepcion vistaFormulario;
    private ControladorRecepcion controladorRecepcion;
    private ColaPrioridad<Recepcion> recepcionColaPrioridad;
    private RecepcionDao recepcionDao;

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
        
        
        this.recepcionDao.insert(nuevaRecepcion);
        this.controladorRecepcion.mostrarDatos();
        this.vistaFormulario.dispose();

// insertarValidaciones posteriormente
    }
}
