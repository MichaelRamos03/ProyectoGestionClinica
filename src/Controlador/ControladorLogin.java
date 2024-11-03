/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VistaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

/**
 *
 * @author karla
 */
public class ControladorLogin extends MouseAdapter implements ActionListener,MouseListener {

     private VistaLogin vistaLogin;

    public ControladorLogin(VistaLogin vistaLogin) {
        this.vistaLogin = vistaLogin;
        this.vistaLogin.setVisible(true);
        this.vistaLogin.setLocationRelativeTo(null);
        this.vistaLogin.setDefaultCloseOperation(vistaLogin.EXIT_ON_CLOSE);
    }
       
     
     
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.vistaLogin.btnIngresar){
            String usuario=this.vistaLogin.txtUsuario1.getText();
            String contrasenia=this.vistaLogin.txtConsetraña1.getText();
            validarCampos(usuario,contrasenia);
        }
   }
    public boolean validarCampos(String usuario,String contrasenia){
        
        
        
        return true;
    }
    
}
