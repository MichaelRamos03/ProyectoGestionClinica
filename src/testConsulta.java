
import Controlador.ControladorConsulta;
import Vista.VistaConsulta;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MINEDUCYT
 */
public class testConsulta {
    public static void main(String[] args) {
        VistaConsulta frm = new VistaConsulta();
        ControladorConsulta ctrl = new ControladorConsulta(frm);
    }
}
