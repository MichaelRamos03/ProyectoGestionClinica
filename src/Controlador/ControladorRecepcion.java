/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Estructuras.ColaPrioridad;
import Modelo.Recepcion;
import Vista.VistaFormularioRecepcion;
import Vista.VistaRecepcion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karla
 */
public class ControladorRecepcion extends MouseAdapter implements ActionListener,MouseListener {
 
    private VistaRecepcion vistaRecepcion;
    private ControladorFormularioRecepcion controladorFormulario;
    private Recepcion recepcionSeleccionada;
    private ColaPrioridad<Recepcion> colaPrioridad;
    private DefaultTableModel md;

    public ControladorRecepcion(VistaRecepcion vistaRecepcion) {
        this.vistaRecepcion = vistaRecepcion;
        this.vistaRecepcion.setVisible(true);
        this.vistaRecepcion.setLocationRelativeTo(null);
        this.vistaRecepcion.setDefaultCloseOperation(vistaRecepcion.DISPOSE_ON_CLOSE);
        this.vistaRecepcion.btnAgregarRecepcion.addActionListener(this);
        
        this.colaPrioridad = new ColaPrioridad(3);
    
        
        this.md = new DefaultTableModel();
        this.md.addColumn("id");
        this.md.addColumn("Presion");
        this.md.addColumn("Altura");
        this.md.addColumn("Peso");
        this.md.addColumn("Temperatura");
        this.md.addColumn("Frecuencia Cardiaca");
        this.md.addColumn("Motivo visita");
        this.md.addColumn("Temperatura");
        this.md.addColumn("Observaciones");
        this.md.addColumn("Empleado encargado");
        this.md.addColumn("Prioridad");
        
        this.vistaRecepcion.tablaRecepciones.setModel(md);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== this.vistaRecepcion.btnAgregarRecepcion){
            
                VistaFormularioRecepcion vistaRecepcion = new VistaFormularioRecepcion();
                ControladorFormularioRecepcion controladorFormulario = new ControladorFormularioRecepcion(vistaRecepcion,this,this.colaPrioridad);
                
            
        }
    }
    
}
