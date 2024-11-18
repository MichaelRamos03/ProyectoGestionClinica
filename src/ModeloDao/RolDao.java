/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import Estructuras.Cola;
import Interfaces.IRol;
import Modelo.Conexion;
import Modelo.Rol;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class RolDao implements IRol{
    Conexion conectar; //clase conexion para conectar a la base de datos
    Connection con; // para agarra la conexion 
    PreparedStatement ps; //para compilar la consulta sql (no tenga ningun error de sintaxis)
    ResultSet rs; //para agarra todos registros de la base
    String sql = null;

    public RolDao() {
        this.conectar = new Conexion();
    }

    @Override
    public Cola<Rol> selectAll() {
        sql="SELECT * FROM rol";
        
        return select(sql);
    }

    @Override
    public boolean insert(Rol r) {
        sql ="INSERT INTO rol(id_rol, rol) VALUES(?, ?)";
        
        return alterar(sql, r);
    }

    @Override
    public boolean update(Rol r) {
        sql = "UPDATE rol SET rol=? WHERE id_rol=" + r.getIdRol();
        
        return alterar(sql, r);
    }

    @Override
    public boolean delete(Rol r) {
        sql = "DELETE FROM rol WHERE id_rol='" + r.getIdRol() + "'";
        
        try{
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.execute();
            
            return true;
        }catch(Exception e){
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en el sql", DesktopNotify.ERROR, 3000);
            e.printStackTrace();
        }finally{
            try{
                ps.close();
                conectar.closeConexion(con);
            }catch(SQLException ex){
                
            }
        }
        return false;
    }
    
    private Cola<Rol> select(String sql){
        Cola<Rol> cola = new Cola();
        Rol r = null;
        
        try{
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
               r = new Rol();
               
               r.setIdRol(rs.getInt("id_rol"));
               r.setRol(rs.getString("rol"));
               
               cola.offer(r);
            }
        }catch(SQLException ex){
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en la Base", DesktopNotify.ERROR, 3000);
            ex.printStackTrace();
        } finally {
            try{
                ps.close();
            }catch(SQLException ex){
                
            }
            conectar.closeConexion(con);
        }
        return cola;
    }
    
    private boolean alterar(String sql, Rol r){
        try{
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, r.getIdRol());
            ps.setString(2, r.getRol());
            
            ps.execute();
            
            return true;
        }catch (SQLException ex){
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en el sql", DesktopNotify.ERROR, 3000);
            ex.printStackTrace();
        }finally{
            try{
                ps.close();
                conectar.closeConexion(con);
            }catch(SQLException ex){
                
            }
        }
        return false;
    }
}
