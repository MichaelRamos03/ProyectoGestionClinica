
import Controlador.ControladorLogin;
import Vista.VistaLogin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author karla
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaLogin vistaLogin = new VistaLogin();
        ControladorLogin controladorLogin = new ControladorLogin(vistaLogin);
    }
    
}
