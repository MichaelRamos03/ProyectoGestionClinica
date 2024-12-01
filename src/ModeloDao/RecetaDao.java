package ModeloDao;

import Estructuras.ABinarioBusqueda;
import Estructuras.ListaDoble;
import Interfaces.IReceta;
import Modelo.Conexion;
import Modelo.Consulta;
import Modelo.Expediente;
import Modelo.Receta;
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
public class RecetaDao implements IReceta{
    
    
    Conexion conectar;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public RecetaDao() {
        this.conectar = new Conexion();
    }

    @Override
    public ListaDoble<Receta> selectAll() {
        String sql ="SELECT r.id_receta, r.cantidad, r.dosis, c.id_consulta, c.diagnostico, e.id_expediente, e.nombre FROM receta r INNER JOIN consulta c ON c.id_consulta = r.id_consulta INNER JOIN expediente e ON e.id_expediente = c.id_expediente";
        return select(sql);
    }

    @Override
    public ListaDoble<Receta> selectAllTo(String atributo, String condicion) {
        String sql = "SELECT r.id_receta, r.cantidad, r.dosis, c.id_consulta, c.diagnostico, e.id_expediente, e.nombre FROM receta r INNER JOIN consulta c ON c.id_consulta = r.id_consulta INNER JOIN expediente e ON e.id_expediente = c.id_expediente WHERE " + atributo + " ='" + condicion + "'";
        return select(sql);
    }

    @Override
    public boolean insert(Receta obj) {
        String sql ="INSERT INTO usuario(usuario, contrasenia, id_empleado) VALUES (?, ?, ?)";
         return alterarRegistro(sql, obj);
    }

    @Override
    public boolean update(Receta obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Receta obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ABinarioBusqueda<Receta> buscar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private ListaDoble<Receta> select(String sql) {

      ListaDoble<Receta> listaReceta = new ListaDoble();
      
       Receta obj = null;
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                obj = new Receta();
                obj.setIdReceta(rs.getInt("id_receta"));
                obj.setCantidad(rs.getInt("cantidad"));
                obj.setDosis(rs.getInt("dosis"));
                
                Consulta c = new Consulta();
                c.setIdConsulta(rs.getInt("id_consulta"));
                c.setDiagnostico(rs.getString("diagnostico"));
                
                Expediente e = new Expediente();
                e.setIdExpediente(rs.getInt("id_expediente"));
                e.setNombre(rs.getString("nombre"));
                
                c.setExpediente(e);
                obj.setConsulta(c);
                listaReceta.insertar(obj);

            }
        } catch (SQLException ex) {

            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en la base SELECT",
                    DesktopNotify.ERROR, 3000);
            ex.printStackTrace();

        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {

            }
            conectar.closeConexion(con);
        }
        return listaReceta;
    }
    
    private boolean alterarRegistro(String sql, Receta obj) {
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, obj.getCantidad());
            ps.setInt(2, obj.getDosis());
            ps.setInt(3, obj.getConsulta().getIdConsulta());
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