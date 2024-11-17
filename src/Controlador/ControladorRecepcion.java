/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VistaRecepcion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

/**
 *
 * @author karla
 */
public class ControladorRecepcion extends MouseAdapter implements ActionListener,MouseListener {
 
    private VistaRecepcion vistaRecepcion;

    public ControladorRecepcion(VistaRecepcion vistaRecepcion) {
        this.vistaRecepcion = vistaRecepcion;
        this.vistaRecepcion.setVisible(true);
        this.vistaRecepcion.setLocationRelativeTo(null);
        this.vistaRecepcion.setDefaultCloseOperation(vistaRecepcion.DISPOSE_ON_CLOSE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
