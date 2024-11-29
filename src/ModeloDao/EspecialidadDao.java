package ModeloDao;

import Estructuras.ListaDoble;
import Interfaces.IEspecialidad;
import Modelo.Conexion;
import Modelo.Especialidad;
import Modelo.Expediente;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gaby Laínez
 */
public class EspecialidadDao implements IEspecialidad {

    Conexion conectar;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public EspecialidadDao() {
        this.conectar = new Conexion();
    }
    
    @Override
    public ListaDoble<Especialidad> selectAll() {
        String sql ="SELECT * FROM especialidad";
        return select(sql);
    }

    @Override
    public boolean insert(Especialidad obj) {
        
        String sql = "INSERT INTO especialidad(especialidad) VALUES (?)";
        
       return alterarRegistro(sql, obj);
    }

    @Override
    public boolean update(Especialidad obj) {
        
        String sql = "UPDATE especialidad SET especialidad=? WHERE id_especialidad=" + obj.getIdEspecialidad();
        return alterarRegistro(sql, obj);
    }

    @Override
    public boolean delete(Especialidad obj) {
        
        String sql = "DELETE FROM especialidad WHERE id_especialidad ='" + obj.getIdEspecialidad() + "'";

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql); // prepara sql
            ps.execute(); // ejecuta la consulta (result set)

            return true;

        } catch (Exception e) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red); // mandamos un mensaje si da error
            DesktopNotify.showDesktopMessage("Error", "Error en el sql al eliminar",
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
    public ListaDoble<Especialidad> buscar(String dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     private ListaDoble<Especialidad> select(String sql) {

        ListaDoble<Especialidad> listaEspe = new ListaDoble();
        Especialidad obj = null;

        try {

            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                obj = new Especialidad();
                obj.setIdEspecialidad(rs.getInt("id_especialidad"));
                obj.setEspecialidad(rs.getString("especialidad"));
                
                listaEspe.insertar(obj);

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
        return listaEspe;
    }
    
     private boolean alterarRegistro(String sql, Especialidad obj) {
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, obj.getEspecialidad());
            ps.execute();

            return true;

        } catch (Exception e) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en el sql especialidaddao",
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
