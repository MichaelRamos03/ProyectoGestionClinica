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
import javax.swing.JOptionPane;

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
             System.out.println("ENTRA VISTA REGISTRAR");
            String nombre= this.vistaRegistrar.txtNombreMedicamento.getText();
            int cantidad =Integer.parseInt(this.vistaRegistrar.txtCantidad.getText());
            Double precio=Double.parseDouble(this.vistaRegistrar.txtPrecio.getText());
            String descripcion= this.vistaRegistrar.textAreaDescripcion.getText();
            Date fechaCaducidad= this.vistaRegistrar.fechaCaducidad.getDate();
            if(validarDatos(nombre,cantidad,precio,descripcion,fechaCaducidad)){
            
            Medicamento nuevoMedicamento= new Medicamento();
            nuevoMedicamento.setNombre(nombre);
            nuevoMedicamento.setCantidadDisponible(cantidad);
            nuevoMedicamento.setPrecio(precio);
            nuevoMedicamento.setFechaCaducidad(fechaCaducidad);
            nuevoMedicamento.setDescripcion(descripcion);
            this.medicamentoDao.insert(nuevoMedicamento);
            JOptionPane.showMessageDialog(null, "El medicamento: "+nuevoMedicamento.getNombre()+ " Ha sido registrado exitosamente");
            this.controladorMedicamento.mostrarDatos();
            }
            } 
        
  }
    
    public Boolean validarDatos(String nombre,int cantidad,Double precio,String descripcion,Date fechaCaducidad){
        // validaciones nombre
        nombre=nombre.replace(" ", "");
        if(nombre.equals("") || nombre.isEmpty()){
            JOptionPane.showMessageDialog(null, "[Nombre vacio] Complete el campo de nombre ");
        return false;
        }
        for(int i=0;i<nombre.length();i++){
            if(!Character.isLetter(nombre.charAt(i))){
                
                JOptionPane.showMessageDialog(null, "El nombre solo debe de contener letras, no se permiten caracteres especiales");
                return false;
            }
            
        }
        
        
        return true;
    }
    
    
    
    
    
    
}
