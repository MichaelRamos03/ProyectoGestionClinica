/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import Estructuras.ABinarioBusqueda;
import Estructuras.Cola;
import Interfaces.IUsuario;
import Modelo.Conexion;
import Modelo.Empleado;
import Modelo.Rol;
import Modelo.Usuario;
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
public class UsuarioDao implements IUsuario {

    Conexion conectar;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario usuario;

    public UsuarioDao() {
        this.conectar = new Conexion();
    }

    @Override
    public Cola<Usuario> selectAll() {
        String sql = "SELECT u.id_usuario,u.usuario,u.contrasenia,e.id_empleado,e.dui,e.nombre FROM usuario u INNER JOIN empleado e ON e.id_empleado = u.id_empleado";
        return select(sql);
    }

    @Override
    public boolean insert(Usuario obj) {

        String sql = "INSERT INTO usuario(usuario, contrasenia, id_empleado) VALUES (?, ?, ?)";
        return alterarRegistro(sql, obj);
    }

    @Override
    public boolean update(Usuario obj) {
        String sql = "UPDATE usuario SET usuario=?, contrasenia=?, id_empleado=? WHERE id_usuario=" + obj.getIdUsuario();
        return alterarRegistro(sql, obj);
    }

    @Override
    public boolean delete(Usuario obj) {

        String sql = "DELETE FROM usuario WHERE id_usuario ='" + obj.getIdUsuario() + "'";

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

    private boolean alterarRegistro(String sql, Usuario obj) {
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, obj.getUsuario());
            ps.setString(2, obj.getContrasenia());
            ps.setInt(3, obj.getEmpleado().getIdEmpleado());
            ps.execute();

            return true;

        } catch (Exception e) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en el sql alterar registro",
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

    //SELECT
    private Cola<Usuario> select(String sql) {

        Cola<Usuario> listaUsuario = new Cola();
        Usuario obj = null;
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                obj = new Usuario();
                obj.setIdUsuario(rs.getInt("id_usuario"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setContrasenia(rs.getString("contrasenia"));
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt("id_empleado"));
                e.setDui(rs.getString("dui"));
                e.setNombre(rs.getString("nombre"));

                obj.setEmpleado(e);
                listaUsuario.offer(obj);

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
        return listaUsuario;
    }

    @Override
    public ABinarioBusqueda<Usuario>buscar() {
        ABinarioBusqueda<Usuario> listaBusqueda = new ABinarioBusqueda();
        String sql = "SELECT u.id_usuario,u.usuario,u.contrasenia,e.id_empleado,e.dui,e.nombre FROM usuario u INNER JOIN empleado e ON e.id_empleado = u.id_empleado";

        try {
            this.con = conectar.getConexion();
            this.ps = con.prepareStatement(sql);
            this.rs = ps.executeQuery();

            while (rs.next()) {
                Usuario obj = new Usuario();
                obj.setIdUsuario(rs.getInt("id_usuario"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setContrasenia(rs.getString("contrasenia"));

                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt("id_empleado"));
                e.setDui(rs.getString("dui"));
                e.setNombre(rs.getString("nombre"));

                obj.setEmpleado(e);
                listaBusqueda.insertar(obj);

            }
        } catch (SQLException ex) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en sql", DesktopNotify.ERROR, 3000);
            ex.printStackTrace();
            java.util.logging.Logger.getLogger(UsuarioDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(UsuarioDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            conectar.closeConexion(con);
        }
        return listaBusqueda;
    }

    
    // METODO DEL LOGIN
    public Usuario obtenerUsuarioPorNombre(Usuario u) {
        this.usuario = null;
        String sql = "select u.id_usuario,u.usuario,u.contrasenia,e.id_empleado,e.nombre,e.apellido,r.id_rol,r.rol\n"
                + "from usuario u\n"
                + "inner join empleado e\n"
                + "on e.id_empleado= u.id_empleado\n"
                + "inner join rol r\n"
                + "on r.id_rol = e.id_rol\n"
                + "where u.usuario=?";

        try {
            this.con = conectar.getConexion();
            this.ps = con.prepareStatement(sql);
            this.ps.setString(1, u.getUsuario()); 
            this.rs = ps.executeQuery();

            if (rs.next()) {
                this.usuario = new Usuario();
                this.usuario.setIdUsuario(rs.getInt("id_usuario"));
                this.usuario.setUsuario(rs.getString("usuario"));
                this.usuario.setContrasenia(rs.getString("contrasenia")); 

                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt("id_empleado"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido")); 
                Rol rol = new Rol();
                rol.setIdRol(rs.getInt("id_rol"));
                rol.setRol(rs.getString("rol"));
                e.setRol(rol);
                this.usuario.setEmpleado(e);
            }
        } catch (SQLException ex) {
            
            java.util.logging.Logger.getLogger(UsuarioDao.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
           
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Ocurrió un problema al recuperar los datos del usuario",
                    DesktopNotify.ERROR, 3000);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(UsuarioDao.class.getName())
                        .log(java.util.logging.Level.SEVERE, null, ex);
            }
            conectar.closeConexion(con);
        }
        return this.usuario;
    }

}
