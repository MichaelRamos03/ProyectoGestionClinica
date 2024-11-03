/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.CrudMedicamentos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

/**
 *
 * @author karla
 */
public class ControladorMedicamentos extends MouseAdapter implements ActionListener,MouseListener{

    private CrudMedicamentos vistaMedicamentos;

    public ControladorMedicamentos(CrudMedicamentos vistaMedicamentos) {
        this.vistaMedicamentos = vistaMedicamentos;
        this.vistaMedicamentos.setVisible(true);
        this.vistaMedicamentos.setDefaultCloseOperation(vistaMedicamentos.EXIT_ON_CLOSE);
        this.vistaMedicamentos.setLocationRelativeTo(null);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
