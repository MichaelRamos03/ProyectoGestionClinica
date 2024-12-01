/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import Estructuras.ListaDoble;
import Interfaces.IMedicoEspecialista;
import Modelo.Conexion;
import Modelo.Empleado;
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
public class MedicoEspecialistaDao implements IMedicoEspecialista{
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

}
