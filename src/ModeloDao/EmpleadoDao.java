

package ModeloDao;

import Estructuras.ColaPrioridad;
import Interfaces.IEmpleado;
import Modelo.Conexion;
import Modelo.Empleado;
import Modelo.Rol;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Michael Ramos;
**/
public class EmpleadoDao implements IEmpleado {
    
    Conexion conectar;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public EmpleadoDao() {
        this.conectar = new Conexion();
    }

    @Override
    public ColaPrioridad<Empleado> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Empleado obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Empleado obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Empleado obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ColaPrioridad<Empleado> buscar(String dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private ColaPrioridad<Empleado> select(String sql) {
        ColaPrioridad<Empleado> colaprioridad = new ColaPrioridad(4);
        Empleado obj = null;

        try {

            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); 

            while (rs.next()) { 
                
                Empleado e = new Empleado();
                e.setDui(rs.getString("dui"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setGenero(rs.getString("genero"));
                e.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                e.setCorreo(rs.getString("correo"));
                e.setEstado(rs.getBoolean("estado"));
                
                Rol r = new Rol();
                
                r.setIdRol(rs.getInt("id_rol"));
                r.setRol(rs.getString("rol"));
                e.setRol(r);
                
               switch (e.getPrioridad()) {
                    case "Rojo":
                        colaprioridad.offer(e, 0);
                        break;

                    case "Naranja":
                        colaprioridad.offer(e, 1);
                        break;
                        
                    case "Amarillo":
                        colaprioridad.offer(e, 2);
                        break;
                    
                    case "Verde":
                        colaprioridad.offer(e, 3);
                        break;
                    
                    case "Azul":
                        colaprioridad.offer(e, 4);
                        break;
               }
            }

        } catch (SQLException ex) {
            
            DesktopNotify.setDefaultTheme(NotifyTheme.Red); // mandamos un mensaje si da error
            DesktopNotify.showDesktopMessage("Error", "Error en la base",
            DesktopNotify.ERROR, 3000);   
            ex.printStackTrace();
            
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {

            }
            conectar.closeConexion(con);
        }
        return colaprioridad;
    }

    private boolean alterarRegistro(String sql, Empleado obj){
        try{
            con = conectar.getConexion(); //agarrando la comexion
            ps = con.prepareStatement(sql); //peraparando sql
            
            // guardando la informacion con prepare stament
            //seteando cada parametro con su debido indice

            
            ps.execute(); //ejectutar
            
            return true;
            
        }catch(Exception e){ //enviando un mensaje si da error
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en el sql",
            DesktopNotify.ERROR, 3000);   
            e.printStackTrace();
       
        } finally { //cerrando la coneixon
            try {
                ps.close();
                conectar.closeConexion(con);
            } catch (SQLException ex) {

            }  
        }
       return false;
    }

}
