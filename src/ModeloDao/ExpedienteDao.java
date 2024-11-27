package ModeloDao;

import Estructuras.ABinarioBusqueda;
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
    
     public ABinarioBusqueda<Expediente> buscar(){
         ABinarioBusqueda<Expediente> listaBusqueda = new ABinarioBusqueda();
       String sql = "SELECT * FROM expediente";
        try {
            this.con = conectar.getConexion();
            this.ps=con.prepareStatement(sql);
            this.rs = ps.executeQuery();
            
            while(rs.next()){
                Expediente e = new Expediente();
                e.setIdExpediente(rs.getInt("id_expediente"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                e.setSexo(rs.getString("sexo"));
                e.setTelefono(rs.getString("telefono"));
                e.setInformacionMedica(rs.getString("informacionmedica"));
                e.setTratamiento(rs.getString("tratamientos"));
                e.setNotaMedica(rs.getString("notamedico"));
                e.setAlergias(rs.getString("alergias"));
                e.setMedicamentos(rs.getString("medicamentos"));
                listaBusqueda.insertar(e);
            }
            
        } catch (SQLException ex) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en sql", DesktopNotify.ERROR, 3000);
            ex.printStackTrace();
            java.util.logging.Logger.getLogger(ExpedienteDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ExpedienteDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            conectar.closeConexion(con);
        }
        return listaBusqueda;
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
