package ModeloDao;

import Estructuras.ABinarioBusqueda;
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
 *
 */
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
        String sql = "SELECT e.id_empleado,e.dui,e.nombre,e.apellido,e.genero,e.fecha_nacimiento,e.correo,e.estado,r.id_rol, r.rol, e.prioridad FROM empleado e INNER JOIN rol r ON r.id_rol = e.id_rol";
        return select(sql);
    }

    @Override
    public ColaPrioridad<Empleado> selectAllTo(String atributo, String condicion) {
        String sql = "SELECT * FROM empleado WHERE " + atributo + " ='" + condicion + "'";
        return select(sql);
    }

    @Override
    public boolean insert(Empleado obj) {
        String sql = "INSERT INTO empleado( dui, nombre, apellido, genero, fecha_nacimiento, correo, estado, id_rol) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";

        return alterarRegistro(sql, obj);
    }

    @Override
    public boolean update(Empleado obj) {
        String sql = "UPDATE empleado SET dui=?, nombre=?, apellido=?, genero=?, fecha_nacimiento=?, correo=?, estado=?, id_rol=? WHERE id_empleado="
                + obj.getIdEmpleado();
        return alterarRegistro(sql, obj);
    }

    @Override
    public boolean delete(Empleado obj) {
        String sql = "DELETE FROM empleado WHERE id_empleado ='" + obj.getIdEmpleado() + "'";

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql); // prepara sql
            ps.execute(); // ejecuta la consulta (result set)

            return true;

        } catch (Exception e) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red); // mandamos un mensaje si da error
            DesktopNotify.showDesktopMessage("Error", "Error en el sql",
                    DesktopNotify.ERROR, 3000);
            e.printStackTrace();

        } finally { //cerrando conexion
            try {
                ps.close();
                conectar.closeConexion(con);
            } catch (SQLException ex) {

            }
        }
        return false;
    }

    @Override
    public ABinarioBusqueda<Empleado> buscar() {
        ABinarioBusqueda<Empleado> listaBusqueda = new ABinarioBusqueda();
        String sql = "SELECT e.id_empleado,e.dui,e.nombre,e.apellido,e.genero,e.fecha_nacimiento,e.correo,e.estado,r.id_rol, r.rol, e.prioridad FROM empleado e INNER JOIN rol r ON r.id_rol = e.id_rol";
        try {
            this.con = conectar.getConexion();
            this.ps = con.prepareStatement(sql);
            this.rs = ps.executeQuery();

            while (rs.next()) {
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt("id_empleado"));
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
               // e.setPrioridad(rs.getString("prioridad"));
                listaBusqueda.insertar(e);

            }
        } catch (SQLException ex) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en sql", DesktopNotify.ERROR, 3000);
            ex.printStackTrace();
            java.util.logging.Logger.getLogger(ExpedienteDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ExpedienteDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            conectar.closeConexion(con);
        }
        return listaBusqueda;
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
                e.setIdEmpleado(rs.getInt("id_empleado"));
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
/*
                e.setPrioridad(rs.getString("prioridad") != null ? rs.getString("prioridad") : "Sin asignar");

                switch (e.getPrioridad()) {
                    case "Alta":
                        colaprioridad.offer(e, 0);
                        break;
                    case "Media":
                        colaprioridad.offer(e, 1);
                        break;
                    case "Baja":
                        colaprioridad.offer(e, 2);
                        break;
                    default:
                        System.out.println("Prioridad no asignada: " + e.getPrioridad());
                        break;
                }

            }
*/
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

    private boolean alterarRegistro(String sql, Empleado obj) {
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, obj.getDui());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getApellido());
            ps.setString(4, obj.getGenero());
            ps.setDate(5, new java.sql.Date(obj.getFechaNacimiento().getTime()));
            ps.setString(6, obj.getCorreo());
            ps.setBoolean(7, obj.isEstado());
            ps.setInt(8, obj.getRol().getIdRol());
           // ps.setString(9, obj.getPrioridad());
            ps.execute();

            return true;

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
        return false;
    }
}
