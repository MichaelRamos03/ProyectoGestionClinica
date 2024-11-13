/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import Interfaces.ILogin;
import Modelo.Conexion;
import Modelo.Empleado;
import Modelo.Rol;
import Modelo.Usuario;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author karla
 */
public class LoginDao implements ILogin {

    // falta completar
    private Conexion conectar;
    private Usuario usuario;
    Connection con; // para agarra la conexion 
    PreparedStatement ps; //para compilar la consulta sql (no tenga ningun error de sintaxis)
    ResultSet rs; //para agarra todos registros de la base

    public LoginDao() {
        this.conectar= new Conexion();
    }

    public Conexion getConectar() {
        return conectar;
    }

    public void setConectar(Conexion conectar) {
        this.conectar = conectar;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    
    
    @Override
    public Usuario validarLogin(String usuario, String contrasenia) {
        this.usuario = new Usuario();
        Rol rol = new Rol();
        Empleado empleado = new Empleado();
        String sql = "SELECT r.id_rol,r.rol,e.nombre,u.usuario,u.contrasenia from usuario u\n"
                + "inner join empleado e\n"
                + "on e.id_empleado= u.id_empleado\n"
                + "inner join rol r\n"
                + "on r.id_rol = e.id_rol\n";
        // OBTENER UN OBJETO DE TIPO USUARIO AL NETBEANS PARA VERIFICAR SU ROL 
        try {
          con=conectar.getConexion();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
          
        } catch (Exception e) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en el sql",
                    DesktopNotify.ERROR, 3000);
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                conectar.closeConexion(con);
            } catch (SQLException ex) {

            }

        }

        return this.usuario;
    }

}
