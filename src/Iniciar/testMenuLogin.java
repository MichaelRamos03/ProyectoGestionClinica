package Iniciar;


import Controlador.ControladorLogin;
import Controlador.ControladorViewInicio;
import Vista.ViewInicio;
import Vista.VistaLogin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author karla
 */
public class testMenuLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ViewInicio vistaInicio = new ViewInicio();
        ControladorViewInicio controladorLogin = new ControladorViewInicio(vistaInicio);
    }
    
}
