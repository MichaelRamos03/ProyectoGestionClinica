/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Estructuras.ListaCircular;
import Modelo.Medicamento;
import Vista.VistaCrudMedicamentos;
import Vista.VistaRegistrarMedicamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karla
 */
public class ControladorMedicamentos extends MouseAdapter implements ActionListener, MouseListener {

    // medicamento listaCircular
     
    private VistaCrudMedicamentos vistaMedicamentos;
    private VistaRegistrarMedicamento vistaRegistrar;
    private Medicamento medicamento;
    private ListaCircular<Medicamento> medicamentoList;
    private DefaultTableModel md;

    public ControladorMedicamentos(VistaCrudMedicamentos vistaMedicamentos) {
        this.vistaMedicamentos = vistaMedicamentos;
        this.vistaMedicamentos.setVisible(true);
        this.vistaMedicamentos.setDefaultCloseOperation(vistaMedicamentos.EXIT_ON_CLOSE);
        this.vistaMedicamentos.setLocationRelativeTo(null);
        this.vistaMedicamentos.btnRegistrarMedicamento.addActionListener(this);
        this.md= new DefaultTableModel();
        this.md.addColumn("id");
        this.md.addColumn("Nombre");
        this.md.addColumn("Cantidad Disponible");
        this.md.addColumn("Fecha Caducidad");
        this.md.addColumn("Descripcion");
        this.md.addColumn("Precio");
        this.vistaMedicamentos.tablaMedicamentos.setModel(md);
        
        
        this.medicamentoList= new ListaCircular<Medicamento>();
        
        this.vistaRegistrar= new VistaRegistrarMedicamento();
        this.vistaRegistrar.setLocationRelativeTo(null);
        this.vistaRegistrar.btnRegistrar.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.vistaMedicamentos.btnRegistrarMedicamento){
            System.out.println("entra");
            this.vistaRegistrar.setVisible(true);
 
        }
                    if(e.getSource()==this.vistaRegistrar.btnRegistrar){
            String nombre= this.vistaRegistrar.txtNombreMedicamento.getText();
                System.out.println("NOMBRE MEDICAMENTO: "+nombre);
            } 
        
  }

}