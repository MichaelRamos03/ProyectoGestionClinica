/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import Controlador.ControladorConsultaVistaEspecialidad;
import Controlador.ControladorVistaReceta;
import Controlador.ControladorVistaUsuario;
import Vista.VistaEspecialidad;
import Vista.VistaReceta;
import Vista.VistaUsuario;

/**
 *
 * @author Gaby Laínez
 */
public class tesUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        VistaUsuario v = new VistaUsuario();
//         ControladorVistaUsuario crt = new  ControladorVistaUsuario(v);
//         v.setVisible(true);
         
//          VistaEspecialidad vi = new  VistaEspecialidad();
//         ControladorConsultaVistaEspecialidad C = new ControladorConsultaVistaEspecialidad(vi);
//         vi.setVisible(true);
//    }

         VistaReceta v = new VistaReceta(); 
         ControladorVistaReceta c = new ControladorVistaReceta(v);
         v.setVisible(true);
         
    }
}
