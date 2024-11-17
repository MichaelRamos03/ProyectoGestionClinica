/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import Controlador.ControladorMedicamentos;
import Vista.VistaCrudMedicamentos;

/**
 *
 * @author karla
 */
public class testeoCRUDMEDICAMENTO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VistaCrudMedicamentos vista = new VistaCrudMedicamentos();
        
        ControladorMedicamentos controlador = new ControladorMedicamentos(vista);
   
    }
    
}
