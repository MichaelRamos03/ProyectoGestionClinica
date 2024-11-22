
import Controlador.ControladorRol;
import Vista.VistaRoles;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class TestRolPrueba {
    public static void main(String[] args) {
        VistaRoles frm = new VistaRoles();
        ControladorRol ctrl = new ControladorRol(frm);
        frm.setVisible(true);
    }
}
