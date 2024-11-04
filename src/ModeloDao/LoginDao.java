/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import Modelo.Conexion;
import Modelo.Usuario;
import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author karla
 */
public class LoginDao extends Conexion{
    
    // falta completar
    
    private Conexion conexion;
    private Usuario usuario;

    public LoginDao() {
        this.conexion.getConexion();
    }
    
    public Usuario ValidarLogin(Usuario usuario) throws SQLException{
        Usuario user = new Usuario();
        ResultSet rs1=null;
       
        try{
           // Connection accesDB =conexion.getConexion();
           // String
        }catch (Exception e){
                        JOptionPane.showMessageDialog(null, "ERROR AL LOGEARSE" + e, "Error",JOptionPane.ERROR_MESSAGE);
  
        }
        return usuario;
    }
    
    
}
