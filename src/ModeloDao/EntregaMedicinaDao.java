

package ModeloDao;

import Estructuras.ABinarioBusqueda;
import Estructuras.ListaDoble;
import Interfaces.IEntregaMedicina;
import Modelo.Conexion;
import Modelo.Empleado;
import Modelo.EntregaMedicina;
import Modelo.Medicamento;
import Modelo.Receta;
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
public class EntregaMedicinaDao implements IEntregaMedicina{
    
    Conexion conectar;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public EntregaMedicinaDao() {
        this.conectar = new Conexion();
    }

    @Override
    public ListaDoble<EntregaMedicina> selectAll() {
        String sql = "SELECT e.id_entrega_medicina, m.id_medicamento, m.nombre AS nombreMedicina,r.id_receta,r.dosis,r.cantidad, em.id_empleado,em.dui,em.nombre AS nombreEmpleado FROM entrega_medicina e INNER JOIN medicamento m ON m.id_medicamento = e.id_medicamento INNER JOIN receta r ON r.id_receta = e.id_receta INNER JOIN empleado em ON em.id_empleado = e.id_empleado";
        return select(sql);
    }

    @Override
    public boolean insert(EntregaMedicina obj) {
        String sql = "INSERT INTO entrega_medicina(id_medicamento, id_receta, id_empleado) VALUES ( ?, ?, ?)";

        return alterarRegistro(sql, obj);
    }

    @Override
    public boolean update(EntregaMedicina obj) {
        String sql = "UPDATE entrega_medicina SET id_medicamento=?, id_receta=?, id_empleado=? WHERE id_entrega_medicina=" + obj.getIdEntregaMedicina();
        return alterarRegistro(sql, obj);
    }

    @Override
    public boolean delete(EntregaMedicina obj) {
         String sql = "DELETE FROM entrega_medicina WHERE id_entrega_medicina='" + obj.getIdEntregaMedicina() + "'";

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
    public ABinarioBusqueda<EntregaMedicina> buscar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     private ListaDoble<EntregaMedicina> select(String sql) {
        ListaDoble<EntregaMedicina> lista = new ListaDoble();
        EntregaMedicina obj = null;
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                obj = new EntregaMedicina();
                obj.setIdEntregaMedicina(rs.getInt("id_entrega_medicina"));
                Medicamento m = new Medicamento();
                m.setIdMedicamento(rs.getInt("id_medicamento"));
                m.setNombre(rs.getString("nombreMedicina"));
                obj.setMedicamento(m);
                Receta r = new Receta();
                r.setIdReceta(rs.getInt("id_receta"));
                r.setDosis(rs.getInt("dosis"));
                r.setDosis(rs.getInt("cantidad"));
                obj.setReceta(r);
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt("id_empleado"));
                e.setDui(rs.getString("dui"));
                e.setNombre(rs.getString("nombreEmpleado"));
                obj.setEmpleado(e);
                
                lista.insertar(obj);
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
        return lista;
    }
     
     private boolean alterarRegistro(String sql, EntregaMedicina obj) {
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, obj.getMedicamento().getIdMedicamento());
            ps.setInt(2, obj.getReceta().getIdReceta());
            ps.setInt(3, obj.getEmpleado().getIdEmpleado());
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
