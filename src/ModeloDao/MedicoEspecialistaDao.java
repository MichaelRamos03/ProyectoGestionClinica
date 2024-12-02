/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import Estructuras.ListaDoble;
import Interfaces.IMedicoEspecialista;
import Modelo.Conexion;
import Modelo.Empleado;
import Modelo.Especialidad;
import Modelo.MedicoEspecialista;
//import com.sun.jdi.connect.spi.Connection;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author equipo
 */
public class MedicoEspecialistaDao implements IMedicoEspecialista {

    Conexion conexion;
    Connection accesoDB;
    PreparedStatement ps;
    ResultSet rs;

    public MedicoEspecialistaDao() {
        conexion = new Conexion();
    }

    private ListaDoble<MedicoEspecialista> select(String sql) {
        ListaDoble<MedicoEspecialista> lista = new ListaDoble();

        try {
            accesoDB = conexion.getConexion();
            ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                MedicoEspecialista me = new MedicoEspecialista();
                Empleado e = new Empleado();
                //Especialidad es = new Especialidad();

                me.setIdMedicoEspecialista(rs.getInt("id_medico_especialista"));
                e.setIdEmpleado(rs.getInt("id_empleado"));
                e.setNombre(rs.getString("nombre"));
                me.setIdEmpleado(e);
//                es.setIdEspecialidad(rs.getInt("id_especialidad"));
//                es.setEspecialidad(rs.getString(""));

                me.setIdEmpleado(e);
                //me.setIdEspecialidad(es);

                lista.insertar(me);
            }
        } catch (SQLException ex) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en la base", DesktopNotify.ERROR, 3000);
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {

            }
            conexion.closeConexion(accesoDB);
        }
        return lista;
    }

    @Override
    public ListaDoble<MedicoEspecialista> selectAll() {
        String sql = "SELECT me.id_medico_especialista, em.id_empleado, em.nombre FROM medico_especialista me INNER JOIN empleado em ON em.id_empleado = me.id_empleado";

        return select(sql);
    }
 //   @Override
    public boolean insert(MedicoEspecialista obj) {
          String sql = "INSERT INTO medico_especialista( id_medico_especialista, id_empleado, id_especialidad) VALUES ( ?, ?, ?)";

        return alterar(sql, obj, true);
       
    }
    
// @Override
    public boolean delete(MedicoEspecialista obj) {
         String sql = "DELETE FROM medico_especialista WHERE id_medico_especialista = ?";

        try {
            accesoDB = conexion.getConexion();
            ps = accesoDB.prepareStatement(sql);
            
            ps.setInt(1, obj.getIdMedicoEspecialista());
            
            ps.execute();

            return true;
        } catch (Exception e) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en el sql", DesktopNotify.ERROR, 3000);
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                conexion.closeConexion(accesoDB);
            } catch (SQLException ex) {

            }
        }
        return false;
    }
 //@Override
public boolean update(MedicoEspecialista obj) {
    String sql = "UPDATE medico_especialista SET id_empleado = ?, id_especialidad = ? WHERE id_medico_especialista = ?";

    try {
        accesoDB = conexion.getConexion();
        ps = accesoDB.prepareStatement(sql);
        
        ps.setInt(1, obj.getIdEmpleado().getIdEmpleado());
        ps.setInt(2, obj.getIdEspecialidad().getIdEspecialidad());
        ps.setInt(3, obj.getIdMedicoEspecialista());

        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;  // Si no se afectan filas, la actualización falló
    } catch (SQLException ex) {
        DesktopNotify.setDefaultTheme(NotifyTheme.Red);
        DesktopNotify.showDesktopMessage("Error", "Error en el SQL de actualización", DesktopNotify.ERROR, 3000);
        ex.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
            conexion.closeConexion(accesoDB);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return false;
}


    
    // @Override
    public ListaDoble<MedicoEspecialista> selectAllMedico() {
        String sql = "SELECT me.id_medico_especialista,e.dui, e.nombre, e.apellido, esp.especialidad, e.estado, e.correo FROM medico_especialista me INNER JOIN empleado e\n" +
"ON me.id_empleado = e.id_empleado INNER JOIN especialidad esp ON me.id_especialidad = esp.id_especialidad";
        return selectt(sql);
    }
    
    
    
   
    private ListaDoble<MedicoEspecialista> selectt(String sql) {
        ListaDoble<MedicoEspecialista> lista = new ListaDoble();

        try {
            accesoDB = conexion.getConexion();
            ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                MedicoEspecialista me = new MedicoEspecialista();
                Empleado e = new Empleado();
                Especialidad esp = new Especialidad();
              

                me.setIdMedicoEspecialista(rs.getInt("id_medico_especialista"));
               

                e.setDui(rs.getString("dui"));
                
                e.setNombre(rs.getString("nombre"));
              e.setApellido(rs.getString("apellido"));
              e.setEstado(rs.getBoolean("estado"));
              e.setCorreo(rs.getString("correo"));
                me.setIdEmpleado(e);
        
              esp.setEspecialidad(rs.getString("especialidad"));

                me.setIdEspecialidad(esp);

                lista.insertar(me);
            }
        } catch (SQLException ex) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en la base", DesktopNotify.ERROR, 3000);
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {

            }
            conexion.closeConexion(accesoDB);
        }
        return lista;
    }

    
    private boolean alterar(String sql, MedicoEspecialista obj, boolean esInsercion) {
    try {
        accesoDB = conexion.getConexion();
        ps = accesoDB.prepareStatement(sql);

        if (esInsercion) {
           
            ps.setInt(1, obj.getIdMedicoEspecialista());
            ps.setInt(2, obj.getIdEmpleado().getIdEmpleado());
            ps.setInt(3, obj.getIdEspecialidad().getIdEspecialidad());
        } else {
         
            ps.setInt(1, obj.getIdEmpleado().getIdEmpleado());
            ps.setInt(2, obj.getIdEspecialidad().getIdEspecialidad());
            ps.setInt(3, obj.getIdMedicoEspecialista()); 
        }

        ps.execute();
        return true;
    } catch (SQLException ex) {
        DesktopNotify.setDefaultTheme(NotifyTheme.Red);
        DesktopNotify.showDesktopMessage("Error", "Error en el SQL", DesktopNotify.ERROR, 3000);
        ex.printStackTrace();
    } finally {
        try {
            ps.close();
            conexion.closeConexion(accesoDB);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return false;
    }
}
