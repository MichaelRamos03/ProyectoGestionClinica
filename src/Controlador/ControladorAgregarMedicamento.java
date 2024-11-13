/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Estructuras.ListaCircular;
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
    private ListaCircular<Medicamento> medicamentoList;
    public ControladorAgregarMedicamento(VistaRegistrarMedicamento vistaRegistrar, ControladorMedicamentos controladorMedicamento,ListaCircular<Medicamento> medicamentoList) {
        this.vistaRegistrar = vistaRegistrar;
        this.medicamentoList= medicamentoList;
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
            String cantidad =(this.vistaRegistrar.txtCantidad.getText());
            String precio=(this.vistaRegistrar.txtPrecio.getText());
            String descripcion= this.vistaRegistrar.textAreaDescripcion.getText();
            Date fechaCaducidad= this.vistaRegistrar.fechaCaducidad.getDate();
            if(validarDatos(nombre,cantidad,precio,descripcion,fechaCaducidad)){
            
             int cant=Integer.parseInt(cantidad);
             Double precio1=Double.parseDouble(precio);
                
            Medicamento nuevoMedicamento= new Medicamento();
            nuevoMedicamento.setNombre(nombre);
            nuevoMedicamento.setCantidadDisponible(cant);
            nuevoMedicamento.setPrecio(precio1);
            nuevoMedicamento.setFechaCaducidad(fechaCaducidad);
            nuevoMedicamento.setDescripcion(descripcion);
            this.medicamentoList.insertarMedicamento(nuevoMedicamento);
            
            JOptionPane.showMessageDialog(null, "El medicamento: "+nuevoMedicamento.getNombre()+ " Ha sido registrado exitosamente");
            this.controladorMedicamento.mostrarDatos();
            this.vistaRegistrar.dispose();
            }
            } 
        
  }
    
    public Boolean validarDatos(String nombre,String cantidad,String precio,String descripcion,Date fechaCaducidad){
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
