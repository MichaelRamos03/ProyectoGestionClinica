package ModeloDao;

import Estructuras.ListaDoble;
import Interfaces.IExpediente;
import Modelo.Conexion;
import Modelo.Expediente;
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
 *
 */
public class ExpedienteDao implements IExpediente {

    Conexion conectar;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public ExpedienteDao() {
        this.conectar = new Conexion();
    }

    @Override
    public ListaDoble<Expediente> selectAll() {
        String sql = "SELECT * FROM expediente";

        return select(sql);
    }

    @Override
    public boolean insert(Expediente obj) {
        String sql = "INSERT INTO expediente(nombre,apellido,fecha_nacimiento,sexo,telefono,informacionmedica,tratamientos,notamedico,alergias,medicamentos) VALUES(?,?,?,?,?,?,?,?,?,?)";

        return alterarRegistro(sql, obj);
    }

    @Override
    public boolean update(Expediente obj) {
        String sql = "UPDATE expediente SET nombre =?, apellido =?, fecha_nacimiento =?, sexo =?, telefono =?,"
                + " informacionmedica =?, tratamientos =?, notamedico =?, alergias =?, medicamentos =? WHERE id_expediente="
                + obj.getIdExpediente();
        return alterarRegistro(sql, obj);
    }

    @Override
    public boolean delete(Expediente obj) {
        String sql = "DELETE FROM expediente WHERE id_expediente ='" + obj.getIdExpediente() + "'";

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
    public ListaDoble<Expediente> buscar(String dato) {
       String sql = "SELECT * FROM expediente WHERE nombre LIKE '" + dato + "%' " +
             "OR apellido LIKE '" + dato + "%' " +
             "OR CAST(fecha_nacimiento AS TEXT) LIKE '" + dato + "%' " +
             "OR sexo LIKE '" + dato + "%' " +
             "OR telefono LIKE '" + dato + "%' " +
             "OR alergias LIKE '" + dato + "%' ";

        return select(sql);
    }

    private ListaDoble<Expediente> select(String sql) {

        ListaDoble<Expediente> lista = new ListaDoble();
        Expediente obj = null;

        try {

            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                obj = new Expediente();
                obj.setIdExpediente(rs.getInt("id_expediente"));
                obj.setNombre(rs.getString("nombre"));
                obj.setApellido(rs.getString("apellido"));
                obj.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                obj.setSexo(rs.getString("sexo"));
                obj.setTelefono(rs.getString("telefono"));
                obj.setInformacionMedica(rs.getString("informacionmedica"));
                obj.setTratamiento(rs.getString("tratamientos"));
                obj.setNotaMedica(rs.getString("notamedico"));
                obj.setAlergias(rs.getString("alergias"));
                obj.setMedicamentos(rs.getString("medicamentos"));
                lista.insertar(obj);

            }
        } catch (SQLException ex) {

            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
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
        return lista;
    }

    private boolean alterarRegistro(String sql, Expediente obj) {
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setDate(3, new java.sql.Date(obj.getFechaNacimiento().getTime()));
            ps.setString(4, obj.getSexo());
            ps.setString(5, obj.getTelefono());
            ps.setString(6, obj.getInformacionMedica());
            ps.setString(7, obj.getTratamiento());
            ps.setString(8, obj.getNotaMedica());
            ps.setString(9, obj.getAlergias());
            ps.setString(10, obj.getMedicamentos());

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
