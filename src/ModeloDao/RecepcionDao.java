/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import Estructuras.ABinarioBusqueda;
import Estructuras.ColaPrioridad;
import Estructuras.ListaCircular;
import Interfaces.IRecepcion;
import Modelo.Conexion;
import Modelo.Empleado;
import java.sql.Connection;
import Modelo.Recepcion;
import Modelo.Rol;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author karla
 */
public class RecepcionDao implements IRecepcion {

    private Conexion conectar;
    private Connection con;
    private PreparedStatement ps; //para compilar la consulta sql (no tenga ningun error de sintaxis)
    private ResultSet rs;
    private Recepcion recepcion;
    private  ABinarioBusqueda<Recepcion> listaBusqueda;

    public RecepcionDao() {
        this.conectar = new Conexion();
    }

    @Override
    public boolean insert(Recepcion recepcion) {
        String sql = "INSERT INTO recepcion(\n"
                + "	id_recepcion, presion, altura, peso, temperatura, frecuencia_cardiaca, motivo_visita, observaciones, id_empleado, prioridad)\n"
                + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        return alterarRegistro(sql, recepcion);
    }

    @Override
    public boolean update(Recepcion obj) {
        String sql = "update recepcion set id_recepcion=?,presion=?,altura=?,peso=?,temperatura=?,frecuencia_cardiaca=?,motivo_visita=?,observaciones=?,id_empleado=?,prioridad=?\n"
                + "where recepcion.id_recepcion='" + obj.getIdRecepcion() + "'";
        return alterarRegistro(sql, obj);
    }

    @Override
    public ColaPrioridad<Recepcion> mostrar() {
        String sql = "select * from recepcion\n"
                + "inner join empleado e\n"
                + "on e.id_empleado = recepcion.id_empleado";
        return selectRecepcionEmpleado(sql);

    }

    @Override
    public boolean delete(Recepcion obj) {

        String sql = "delete from recepcion \n"
                + "where recepcion.id_recepcion='" + obj.getIdRecepcion() + "'";
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

    private boolean alterarRegistro(String sql, Recepcion recepcion) {
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            //id_recepcion, presion, altura, peso, temperatura, frecuencia_cardiaca, motivo_visita, observaciones, id_empleado, prioridad)\n"
            ps.setInt(1, recepcion.getIdRecepcion());
            ps.setString(2, recepcion.getPresion());
            ps.setString(3, recepcion.getAltura());
            ps.setString(4, recepcion.getPeso());
            ps.setString(5, recepcion.getTemperatura());
            ps.setInt(6, recepcion.getFrecuenciaCardiaca());
            ps.setString(7, recepcion.getMotivoVisita());
            ps.setString(8, recepcion.getObservaciones());
            ps.setInt(9, recepcion.getEmpleado().getIdEmpleado());
            ps.setString(10, recepcion.getPrioridad());

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

    public ListaCircular<Empleado> getEmpleadosCombo() {
        ListaCircular<Empleado> listaEmpleados = new ListaCircular<Empleado>();

        try {
            String sql = "select e.id_empleado,e.nombre,e.apellido,r.id_rol,r.rol\n"
                    + "from empleado e\n"
                    + "inner join rol r\n"
                    + "on r.id_rol = e.id_rol\n"
                    + "where r.id_rol=3";
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado empleado = new Empleado();
                Rol rol = new Rol();
                empleado.setIdEmpleado(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                rol.setIdRol(rs.getInt("id_rol"));
                rol.setRol(rs.getString("rol"));
                empleado.setRol(rol);
                listaEmpleados.insertar(empleado);

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

        return listaEmpleados;
    }

    /*
    public Empleado getBuscarEmpleado(){
        
        
        
    }

     */
    private ColaPrioridad<Recepcion> selectRecepcionEmpleado(String sql) {
        ColaPrioridad<Recepcion> colaRecepcionPrioridad = new ColaPrioridad<Recepcion>(4);

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
//--id_recepcion,presion,altura,peso,temperatura,frecuencia_cardiaca,motivo_visita,observaciones,id_empleado,proridad
                Recepcion recepcion = new Recepcion();
                recepcion.setIdRecepcion(rs.getInt("id_recepcion"));
                recepcion.setPresion(rs.getString("presion"));
                recepcion.setAltura(rs.getString("altura"));
                recepcion.setPeso(rs.getString("peso"));
                recepcion.setTemperatura(rs.getString("temperatura"));
                recepcion.setFrecuenciaCardiaca(rs.getInt("frecuencia_cardiaca"));
                recepcion.setMotivoVisita(rs.getString("motivo_visita"));
                recepcion.setObservaciones(rs.getString("observaciones"));
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                recepcion.setEmpleado(empleado);
                recepcion.setPrioridad(rs.getString("prioridad"));

                if (recepcion.getPrioridad().equals("Maxima Urgencia")) {
                    colaRecepcionPrioridad.offer(recepcion, 0);

                } else if (recepcion.getPrioridad().equals("Alta")) {

                    colaRecepcionPrioridad.offer(recepcion, 1);
                } else if (recepcion.getPrioridad().equals("Media")) {
                    colaRecepcionPrioridad.offer(recepcion, 2);
                } else {
                    // baja
                    colaRecepcionPrioridad.offer(recepcion, 3);
                }

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
        return colaRecepcionPrioridad;

    }

    public Recepcion buscarRecepcion(int id) {
        this.recepcion = null;
        try {
            String sql = "select r.id_recepcion,r.presion,r.altura,r.peso,r.temperatura,r.frecuencia_cardiaca,r.motivo_visita,r.observaciones,e.id_empleado,r.prioridad,e.nombre\n"
                    + "from recepcion r\n"
                    + "inner join empleado e\n"
                    + "on e.id_empleado = r.id_empleado\n"
                    + "where  r.id_recepcion='" + id + "'";

            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                this.recepcion = new Recepcion();
                Empleado e = new Empleado();
                this.recepcion.setIdRecepcion(rs.getInt("id_recepcion"));
                this.recepcion.setPresion(rs.getString("presion"));
                this.recepcion.setAltura(rs.getString("altura"));
                this.recepcion.setPeso(rs.getString("peso"));
                this.recepcion.setTemperatura(rs.getString("temperatura"));
                this.recepcion.setFrecuenciaCardiaca(rs.getInt("frecuencia_cardiaca"));
                this.recepcion.setMotivoVisita(rs.getString("motivo_visita"));
                this.recepcion.setObservaciones(rs.getString("observaciones"));
                e.setIdEmpleado(rs.getInt("id_empleado"));
                this.recepcion.setPrioridad(rs.getString("prioridad"));
                e.setNombre(rs.getString("nombre"));

                this.recepcion.setEmpleado(e);
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
        return this.recepcion;

    }

    public boolean verificarExiste(int id) {
        boolean encontrada = false;
        try {
            String sql = "SELECT * from recepcion\n"
                    + "where recepcion.id_recepcion='" + id + "'";
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

    public ABinarioBusqueda<Recepcion> buscarTodasRecepcionesPrioridad(String prioridad) {
               this.listaBusqueda = new ABinarioBusqueda();
        String sql = "select r.id_recepcion,r.presion,r.altura,r.peso,r.temperatura,r.frecuencia_cardiaca,r.motivo_visita,r.observaciones,e.id_empleado,e.nombre,e.apellido,r.prioridad\n"
                + "from recepcion r\n"
                + "inner join empleado e\n"
                + "on e.id_empleado = r.id_empleado\n"
                + "where r.prioridad='"+prioridad+"'";
        try {
            this.con = conectar.getConexion();
            this.ps = con.prepareStatement(sql);
            this.rs = ps.executeQuery();
         
            while (rs.next()) {
                Recepcion r = new Recepcion();
                //id_recepcion,presion,altura,peso,temperatura,frecuencia_cardiaca,motivo_visita,observaciones,id_empleado,prioridad
                r.setIdRecepcion(rs.getInt("id_recepcion"));
                r.setPresion(rs.getString("presion"));
                r.setAltura(rs.getString("altura"));
                r.setPeso(rs.getString("peso"));
                r.setTemperatura(rs.getString("temperatura"));
                r.setFrecuenciaCardiaca(rs.getInt("frecuencia_cardiaca"));
                r.setMotivoVisita(rs.getString("motivo_visita"));
                r.setObservaciones(rs.getString("observaciones"));
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                r.setPrioridad(rs.getString("prioridad"));
                r.setEmpleado(empleado);

                listaBusqueda.insertar(r);
            
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
