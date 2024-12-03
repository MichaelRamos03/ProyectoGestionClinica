/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.ViewInicio;
import Vista.VistaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author karla
 */
public class ControladorViewInicio extends MouseAdapter implements ActionListener,MouseListener {

    private VistaLogin vistaLogin;
    private ControladorViewInicio controladorView;
    private ViewInicio vistaInicio;
   

    public ControladorViewInicio(ViewInicio vistaInicio) {
        ///
        this.vistaInicio = vistaInicio;
        this.vistaInicio.setVisible(true);
        this.vistaInicio.setLocationRelativeTo(null);
        
        this.vistaInicio.btnMenu.addActionListener(this);
        this.vistaInicio.btnLogin.addActionListener(this);
        
        
    }
  
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
         
           if(e.getSource()==this.vistaInicio.btnLogin){
          
            VistaLogin vistaLogin= new VistaLogin();
            ControladorLogin controladorLogin= new ControladorLogin(vistaLogin);
            
           }
    }
    
}
