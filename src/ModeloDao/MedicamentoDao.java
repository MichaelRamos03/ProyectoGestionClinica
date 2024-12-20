/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import Estructuras.ABinarioBusqueda;
import Estructuras.ListaCircular;
import Interfaces.IMedicamento;
import Modelo.Conexion;
import Modelo.Consulta;
import Modelo.Especialidad;
import Modelo.Expediente;
import Modelo.Medicamento;
import Modelo.MedicoEspecialista;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author karla
 */
public class MedicamentoDao implements IMedicamento {

    Conexion conectar; //clase conexion para conectar a la base de datos
    Connection con; // para agarra la conexion 
    PreparedStatement ps; //para compilar la consulta sql (no tenga ningun error de sintaxis)
    ResultSet rs; //para agarra todos registros de la base

    public MedicamentoDao() {
        conectar = new Conexion();
    }

    public Conexion getConectar() {
        return conectar;
    }

    public void setConectar(Conexion conectar) {
        this.conectar = conectar;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    @Override
    public boolean insert(Medicamento medicamento) {
        String sql = "INSERT INTO medicamento(\n"
                + "	nombre, cantidad_disponible, fecha_caducidad, descripcion, precio)\n"
                + "	VALUES (?, ?, ?, ?, ?)";
        return alterarRegistro(sql, medicamento);
    }

    @Override
    public boolean update(Medicamento obj) {
        String sql = "update medicamento set nombre=?,cantidad_disponible=?,fecha_caducidad=?,descripcion=?,precio=?\n"
                + "where id_medicamento='" + obj.getIdMedicamento() + "'";
        return alterarRegistro(sql, obj);
    }
    
    public ListaCircular<Medicamento> selectAllTo(String atributo, String condicion) {
        String sql = "SELECT * FROM medicamento WHERE " + atributo + " ='" + condicion + "'";
        return select(sql);
    }

    private boolean alterarRegistro(String sql, Medicamento medicamento) {
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);

            //ps.setInt(1, medicamento.getIdMedicamento());
            ps.setString(1, medicamento.getNombre());
            ps.setInt(2, medicamento.getCantidadDisponible());
            ps.setDate(3, new java.sql.Date(medicamento.getFechaCaducidad().getTime()));
            ps.setString(4, medicamento.getDescripcion());
            ps.setDouble(5, medicamento.getPrecio());
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

    @Override
    public ListaCircular<Medicamento> mostrar() {

        String sql = "select * from medicamento\n"
                + "order by medicamento.fecha_caducidad ASC";
        return select(sql);
    }

    private ListaCircular<Medicamento> select(String sql) {
        ListaCircular<Medicamento> listaC = new ListaCircular();

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Medicamento med = new Medicamento();
                med.setIdMedicamento(rs.getInt("id_medicamento"));
                med.setNombre(rs.getString("nombre"));
                med.setCantidadDisponible(rs.getInt("cantidad_disponible"));
                med.setFechaCaducidad(rs.getDate("fecha_caducidad"));
                med.setDescripcion(rs.getString("descripcion"));
                med.setPrecio(rs.getDouble("precio"));
                listaC.insertar(med);

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
        return listaC;

    }

    @Override
    public boolean delete(Medicamento obj) {
        String sql = "delete \n"
                + "from medicamento\n"
                + "where id_medicamento='" + obj.getIdMedicamento() + "'";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red); // mandamos un mensaje si da error
            DesktopNotify.showDesktopMessage("Error", "Error en el sql",
                    DesktopNotify.ERROR, 3000);
            e.printStackTrace();
        } finally {

            try {
                ps.close();
                conectar.closeConexion(con);
            } catch (SQLException e) {

            }
        }

        return false;
    }

    public boolean verificarExiste(String nombre) {
        boolean encontrada = false;
        try {
            String sql = "select * from medicamento where medicamento.nombre ='" + nombre + "'";
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                encontrada = true;
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
        return encontrada;
    }

    public ABinarioBusqueda<Medicamento> buscarTodosMedicamentos() {
        ABinarioBusqueda<Medicamento> listaBusqueda = new ABinarioBusqueda();
        String sql = "select * from medicamento";
        try {
            this.con = conectar.getConexion();
            this.ps = con.prepareStatement(sql);
            this.rs = ps.executeQuery();

            while (rs.next()) {
                Medicamento medicamento = new Medicamento();
                medicamento.setIdMedicamento(rs.getInt("id_medicamento"));
                medicamento.setNombre(rs.getString("nombre"));
                medicamento.setCantidadDisponible(rs.getInt("cantidad_disponible"));
                medicamento.setFechaCaducidad(rs.getDate("fecha_caducidad"));
                medicamento.setDescripcion(rs.getString("descripcion"));
                medicamento.setPrecio(rs.getDouble("precio"));
                listaBusqueda.insertar(medicamento);
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
    
     

}
