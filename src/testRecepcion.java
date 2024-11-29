
import Controlador.ControladorFormularioRecepcion;
import Controlador.ControladorRecepcion;
import Vista.VistaFormularioRecepcion;
import Vista.VistaRecepcion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author karla
 */
public class testRecepcion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        VistaRecepcion vistaRecepcion = new VistaRecepcion();
        ControladorRecepcion controladorR = new ControladorRecepcion(vistaRecepcion);
    
    }
    
}
