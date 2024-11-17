/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VistaAdministrador;
import Vista.VistaConsultaExpediente;
import Vista.VistaCrudMedicamentos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 *
 * @author karla
 */
public class ControladorAdministrador extends MouseAdapter implements ActionListener{
    private VistaAdministrador vistaAdministrador;
    private ControladorMedicamentos controladorMedicamentos;

    public ControladorAdministrador(VistaAdministrador vistaAdministrador) {
        this.vistaAdministrador = vistaAdministrador;
        this.vistaAdministrador.setLocationRelativeTo(null);
        this.vistaAdministrador.setDefaultCloseOperation(vistaAdministrador.DISPOSE_ON_CLOSE);
        this.vistaAdministrador.btnAdministrarMedicamento.addActionListener(this);
        this.vistaAdministrador.btnAdministrarExpedientes.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== this.vistaAdministrador.btnAdministrarMedicamento){
            VistaCrudMedicamentos vista = new VistaCrudMedicamentos();
            ControladorMedicamentos controladorMedicamentos = new ControladorMedicamentos(vista);
   
       }
       if(e.getSource()== this.vistaAdministrador.btnAdministrarExpedientes){
            VistaConsultaExpediente v = new VistaConsultaExpediente();
        ControladorConsultaExpediente c = new ControladorConsultaExpediente(v);
        v.iniciar();
       }
    }
          
    
    
}
