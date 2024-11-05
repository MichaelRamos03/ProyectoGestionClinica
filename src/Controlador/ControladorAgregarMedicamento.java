/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Medicamento;
import ModeloDao.MedicamentoDao;
import Vista.VistaRegistrarMedicamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.Date;

/**
 *
 * @author karla
 */
public class ControladorAgregarMedicamento extends MouseAdapter implements ActionListener,MouseListener {
    
    private VistaRegistrarMedicamento vistaRegistrar;
    private ControladorMedicamentos controladorMedicamento;
    private Medicamento medicamento;
    private MedicamentoDao medicamentoDao;

    public ControladorAgregarMedicamento(VistaRegistrarMedicamento vistaRegistrar, ControladorMedicamentos controladorMedicamento) {
        this.vistaRegistrar = vistaRegistrar;
        this.controladorMedicamento = controladorMedicamento;
         this.vistaRegistrar.setLocationRelativeTo(null);
        this.vistaRegistrar.btnRegistrar.addActionListener(this); 
        this.medicamentoDao= new MedicamentoDao();
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
         if(e.getSource()==this.vistaRegistrar.btnRegistrar){
            String nombre= this.vistaRegistrar.txtNombreMedicamento.getText();
            int cantidad =Integer.parseInt(this.vistaRegistrar.txtCantidad.getText());
            Double precio=Double.parseDouble(this.vistaRegistrar.txtPrecio.getText());
            String descripcion= this.vistaRegistrar.textAreaDescripcion.getText();
            Date fechaCaducidad= this.vistaRegistrar.fechaCaducidad.getDate();
            Medicamento nuevoMedicamento= new Medicamento();
            nuevoMedicamento.setNombre(nombre);
            nuevoMedicamento.setCantidadDisponible(cantidad);
            nuevoMedicamento.setPrecio(precio);
            nuevoMedicamento.setFechaCaducidad(fechaCaducidad);
            nuevoMedicamento.setDescripcion(descripcion);
            this.medicamentoDao.insert(nuevoMedicamento);
            
                System.out.println("NOMBRE MEDICAMENTO: "+nombre);
            } 
        
  }
    
    
    
    
    
    
}
