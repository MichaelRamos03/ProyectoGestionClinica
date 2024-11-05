/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import Interfaces.IMedicamento;
import Modelo.Conexion;
import Modelo.Medicamento;
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
        conectar= new Conexion();
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

    private boolean alterarRegistro(String sql, Medicamento medicamento) {
        try {
                con=conectar.getConexion();
                ps=con.prepareStatement(sql);
                //id_medicamento, nombre, cantidad_disponible, fecha_caducidad, descripcion, precio)\n"
                
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
        }finally{
            try{
                ps.close();
                conectar.closeConexion(con);
            }catch(SQLException ex){
                   
            }
            
        }

        return false;
    }
}
