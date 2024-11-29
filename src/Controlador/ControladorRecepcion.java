/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Estructuras.ColaPrioridad;
import Modelo.Recepcion;
import ModeloDao.RecepcionDao;
import Vista.VistaFormularioRecepcion;
import Vista.VistaRecepcion;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karla
 */
public class ControladorRecepcion extends MouseAdapter implements ActionListener,MouseListener {
 
    private VistaRecepcion vistaRecepcion;
    private ControladorFormularioRecepcion controladorFormulario;
    private Recepcion recepcionSeleccionada;
    private int filaRecepcionSelect;
    private ColaPrioridad<Recepcion> colaPrioridad;
    private DefaultTableModel md;
    private RecepcionDao recepcionDao;

    public ControladorRecepcion(VistaRecepcion vistaRecepcion) {
        this.vistaRecepcion = vistaRecepcion;
        this.vistaRecepcion.setVisible(true);
        this.vistaRecepcion.setLocationRelativeTo(null);
        this.vistaRecepcion.setDefaultCloseOperation(vistaRecepcion.DISPOSE_ON_CLOSE);
        this.vistaRecepcion.btnAgregarRecepcion.addActionListener(this);
        this.vistaRecepcion.btnEliminarRecepcion.addActionListener(this);
        this.vistaRecepcion.btnEliminarRecepcion.setEnabled(false);
        this.vistaRecepcion.btnModificar.addActionListener(this);
        this.vistaRecepcion.btnModificar.setEnabled(false);
        this.recepcionDao= new RecepcionDao();
        this.colaPrioridad = new ColaPrioridad(4);
    
        
        this.md = new DefaultTableModel();
        this.md.addColumn("id");
        this.md.addColumn("Presion");
        this.md.addColumn("Altura");
        this.md.addColumn("Peso");
        this.md.addColumn("Temperatura");
        this.md.addColumn("Frecuencia Cardiaca");
        this.md.addColumn("Motivo visita");
        this.md.addColumn("Observaciones");
        this.md.addColumn("Empleado encargado");
        this.md.addColumn("Prioridad");
        
        this.vistaRecepcion.tablaRecepciones.setModel(md);
        this.vistaRecepcion.tablaRecepciones.addMouseListener(this);
       
        
        mostrarDatos();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== this.vistaRecepcion.btnAgregarRecepcion){
            
                VistaFormularioRecepcion vistaRecepcion = new VistaFormularioRecepcion();
                ControladorFormularioRecepcion controladorFormulario = new ControladorFormularioRecepcion(vistaRecepcion,this,this.colaPrioridad);
        }
        
        if(e.getSource()== this.vistaRecepcion.btnEliminarRecepcion){
            eliminarRecepcion(this.recepcionSeleccionada);
            
        }
        
        if(e.getSource()== this.vistaRecepcion.btnModificar){
            if(this.recepcionSeleccionada !=null){
                 VistaFormularioRecepcion vistaRecepcion = new VistaFormularioRecepcion();
                ControladorFormularioRecepcion controladorFormulario = new ControladorFormularioRecepcion(vistaRecepcion,this,this.colaPrioridad,this.recepcionSeleccionada);
                
            }
            
        }
    }
    
     @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaRecepcion.tablaRecepciones) {
            this.filaRecepcionSelect = this.vistaRecepcion.tablaRecepciones.getSelectedRow();

            if (filaRecepcionSelect >= 0) {
                this.recepcionSeleccionada = new Recepcion();
                //buscando por nombre del medicamento(metodo del compare to)
                 int id = (int) this.vistaRecepcion.tablaRecepciones.getValueAt(filaRecepcionSelect, 0);
                this.recepcionSeleccionada.setIdRecepcion(id);
                //int id=Integer.parseInt(this.vistaMedicamentos.tablaMedicamentos.getValueAt(filaMedicamentoSeleccionado,0).toString());
                //obteniendo el medicamento desde el metodo buscarDato
                this.recepcionSeleccionada= this.recepcionDao.buscarRecepcion(id);
          
               // this.vistaMedicamentos.btnRegistrarMedicamento.setEnabled(false);
                this.vistaRecepcion.btnEliminarRecepcion.setEnabled(true);
                this.vistaRecepcion.btnModificar.setEnabled(true);
            } else if (filaRecepcionSelect < 0) {
                this.vistaRecepcion.btnAgregarRecepcion.setEnabled(true);
                this.vistaRecepcion.btnEliminarRecepcion.setEnabled(false);
                this.vistaRecepcion.btnModificar.setEnabled(false);
            }
        }
    }
    
    public void mostrarDatos(){
        DefaultTableModel tabla = new DefaultTableModel();
        
        
        String columnas[]={"Id","Presion","Altura","Peso","Temperatura","Frecuencia Cardiaca","Motivo visita","Observaciones","Empleado encargado","Prioridad"};
        tabla.setColumnIdentifiers(columnas);
        this.colaPrioridad=this.recepcionDao.mostrar();
        for(Recepcion r : this.colaPrioridad.toArray()){
            Object datos[]={r.getIdRecepcion(),r.getPresion(),r.getAltura(),r.getPeso(),r.getTemperatura(),r.getFrecuenciaCardiaca(),r.getMotivoVisita(),r.getObservaciones(),r.getEmpleado().getNombre()+" "+ r.getEmpleado().getApellido(),r.getPrioridad()};
            tabla.addRow(datos);
        }
        this.vistaRecepcion.tablaRecepciones.setModel(tabla);
    }
    
    public void eliminarRecepcion(Recepcion r) {
        int opcion = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro de eliminar la recepcion: " + r.getIdRecepcion() + "?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
        
        

        // eliminando desde la bd;
        this.recepcionDao.delete(r);
       // JOptionPane.showMessageDialog(null, "Medicamento: " + medicamento.getNombre() + " Eliminado con exito");
          DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Recepcion", r.getIdRecepcion()+" Eliminado con exito",
                    DesktopNotify.SUCCESS, 5000);
        mostrarDatos();
        this.vistaRecepcion.btnAgregarRecepcion.setEnabled(true);
        this.vistaRecepcion.btnEliminarRecepcion.setEnabled(false);
        this.vistaRecepcion.btnModificar.setEnabled(false);
    }
    }
}
