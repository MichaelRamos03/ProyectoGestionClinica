/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import Estructuras.Lista;
import Estructuras.ListaCircular;
import Interfaces.IConsulta;
import Modelo.Conexion;
import Modelo.Consulta;
import Modelo.Empleado;
import Modelo.Especialidad;
import Modelo.Expediente;
import Modelo.MedicoEspecialista;
import Modelo.Recepcion;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MINEDUCYT
 */
public class ConsultaDao implements IConsulta {

    Conexion conexion;
    Connection accesoDB;
    PreparedStatement ps;
    ResultSet rs;

    public ConsultaDao() {
        this.conexion = new Conexion();
    }

    @Override
    public Lista<Consulta> selectAll() {
        String sql = "SELECT c.id_consulta,c.consultorio,c.diagnostico,e.id_expediente, e.nombre, me.id_medico_especialista, em.id_empleado, em.nombre FROM consulta c INNER JOIN expediente e ON e.id_expediente = c.id_expediente INNER JOIN medico_especialista me ON me.id_medico_especialista = c.id_medico_especialista INNER JOIN recepcion ON recepcion.id_recepcion = c.id_recepcion INNER JOIN empleado em ON em.id_empleado = me.id_empleado";

        return select(sql);
    }

    @Override
    public boolean insert(Consulta obj) {
        String sql = "INSERT INTO consulta( id_consulta, consultorio, diagnostico, id_expediente, id_medico_especialista, id_recepcion) VALUES (?, ?, ?, ?, ?, ?)";

        return alterar(sql, obj, true);
    }

    @Override
    public boolean update(Consulta obj) {
        String sql = "UPDATE consulta SET consultorio = ?, diagnostico = ?, id_expediente = ?, id_medico_especialista = ?, id_recepcion = ? WHERE id_consulta = ?";

        return alterar(sql, obj, false);
    }

    @Override
    public boolean delete(Consulta obj) {
        String sql = "DELETE FROM consulta WHERE id_consulta = ?";

        try {
            accesoDB = conexion.getConexion();
            ps = accesoDB.prepareStatement(sql);
            
            ps.setInt(1, obj.getIdConsulta());
            
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

    @Override
    public Lista<Consulta> buscar(String dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Lista<Consulta> select(String sql) {
        Lista<Consulta> lista = new Lista();

        try {
            accesoDB = conexion.getConexion();
            ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Consulta c = new Consulta();
                Expediente e = new Expediente();
                MedicoEspecialista me = new MedicoEspecialista();
                Expediente ex = new Expediente();
                Empleado em = new Empleado();

                c.setIdConsulta(rs.getInt("id_consulta"));
                c.setConsultorio(rs.getInt("consultorio"));
                c.setDiagnostico(rs.getString("diagnostico"));

                ex.setIdExpediente(rs.getInt("id_expediente"));
                ex.setNombre(rs.getString("nombre"));

                c.setExpediente(ex);

                e.setIdExpediente(rs.getInt("id_expediente"));
                e.setNombre(rs.getString("nombre"));
                c.setExpediente(e);

                em.setIdEmpleado(rs.getInt("id_empleado"));
                em.setNombre(rs.getString("nombre"));

                me.setIdMedicoEspecialista(rs.getInt("id_medico_especialista"));
                me.setIdEmpleado(em);

                c.setMedicoEspecialista(me);

                lista.insertar(c);
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

    
    private boolean alterar(String sql, Consulta obj, boolean esInsercion) {
    try {
        accesoDB = conexion.getConexion();
        ps = accesoDB.prepareStatement(sql);

        if (esInsercion) {
            // Orden para INSERT
            ps.setInt(1, obj.getIdConsulta());
            ps.setInt(2, obj.getConsultorio());
            ps.setString(3, obj.getDiagnostico());
            ps.setInt(4, obj.getExpediente().getIdExpediente());
            ps.setInt(5, obj.getMedicoEspecialista().getIdMedicoEspecialista());
            ps.setInt(6, obj.getRecepcion().getIdRecepcion());
        } else {
            // Orden para UPDATE
            ps.setInt(1, obj.getConsultorio());
            ps.setString(2, obj.getDiagnostico());
            ps.setInt(3, obj.getExpediente().getIdExpediente());
            ps.setInt(4, obj.getMedicoEspecialista().getIdMedicoEspecialista());
            ps.setInt(5, obj.getRecepcion().getIdRecepcion());
            ps.setInt(6, obj.getIdConsulta()); // El ID para el WHERE
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

//    private boolean alterar(String sql, Consulta obj) {
//        try {
//            accesoDB = conexion.getConexion();
//            ps = accesoDB.prepareStatement(sql);
//
//            ps.setInt(1, obj.getIdConsulta());
//            ps.setInt(2, obj.getConsultorio());
//            ps.setString(3, obj.getDiagnostico());
//            ps.setInt(4, obj.getExpediente().getIdExpediente());
//            ps.setInt(5, obj.getMedicoEspecialista().getIdMedicoEspecialista());
//            ps.setInt(6, obj.getRecepcion().getIdRecepcion());
//
//            ps.execute();
//            return true;
//        } catch (SQLException ex) {
//            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
//            DesktopNotify.showDesktopMessage("Error", "Error en el sql", DesktopNotify.ERROR, 3000);
//            ex.printStackTrace();
//        } finally {
//            try {
//                ps.close();
//                conexion.closeConexion(accesoDB);
//            } catch (SQLException ex) {
//
//            }
//        }
//        return false;
//    }
public ListaCircular<Consulta> getConsultasPDF() {

        ListaCircular<Consulta> listaConsultas = new ListaCircular<Consulta>();

        try {
            String sql = "select e.especialidad,sum(cn.precio) AS total_ingresos\n"
                    + "from consulta cn\n"
                    + "inner join medico_especialista me\n"
                    + "on cn.id_medico_especialista = me.id_medico_especialista\n"
                    + "inner join especialidad e\n"
                    + "on e.id_especialidad = me.id_especialidad\n"
                    + "group by e.especialidad";
            accesoDB = conexion.getConexion();
            ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
               Especialidad esp = new Especialidad();
               Consulta consulta = new Consulta();
               MedicoEspecialista med = new MedicoEspecialista();
               esp.setEspecialidad(rs.getString("especialidad"));
               consulta.setPrecio(rs.getDouble("total_ingresos"));
               med.setIdEspecialidad(esp);
               consulta.setMedicoEspecialista(med);
               listaConsultas.insertar(consulta);
               
               
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
            conexion.closeConexion(accesoDB);

        }

        return listaConsultas;

    }

    @Override
    public Lista<Consulta> selectAllTo(String atributo, String condicion) {
    String sql = "SELECT c.id_consulta,c.consultorio,c.diagnostico,e.id_expediente, e.nombre, me.id_medico_especialista, em.id_empleado, em.nombre FROM consulta c INNER JOIN expediente e ON e.id_expediente = c.id_expediente INNER JOIN medico_especialista me ON me.id_medico_especialista = c.id_medico_especialista INNER JOIN recepcion ON recepcion.id_recepcion = c.id_recepcion INNER JOIN empleado em ON em.id_empleado = me.id_empleado WHERE " + atributo + " ='" + condicion + "'";
    return select(sql);
    }
}
