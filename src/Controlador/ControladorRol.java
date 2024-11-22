/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Estructuras.Cola;
import Modelo.Rol;
import ModeloDao.RolDao;
import Vista.VistaRoles;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;
import proyectoclase.utilidades.Render;

/**
 *
 * @author PC
 */
public class ControladorRol extends MouseAdapter implements ActionListener, MouseListener {

    VistaRoles frm;
    Rol r;
    RolDao daoRol;

    public ControladorRol(VistaRoles frm) {
        this.frm = frm;
        this.daoRol = new RolDao();

        this.frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
        this.frm.tbtRoles.addMouseListener(this);

        mostrar(this.daoRol.selectAll());
    }

    public void mostrar(Cola<Rol> cola) {
        DefaultTableModel md;
        this.frm.tbtRoles.setDefaultRenderer(Object.class, new Render());
        md = new DefaultTableModel();

        String[] titulos = {"ID", "NOMBRE DEL ROL"};
        md.setColumnIdentifiers(titulos);

        //int i = 0;
        for (Rol r : cola.toArray()) {
            Object datos[] = {r.getIdRol(), r.getRol()};

            md.addRow(datos);

            this.frm.tbtRoles.setModel(md);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
