/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author karla
 */
public class Usuario implements Comparable<Usuario>{
    private int idUsuario;
    private String usuario;
    private String contrasenia;
    private Empleado empleado;

    public Usuario() {
    }

    public Usuario(String usuario, String contrasenia, Empleado empleado) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.empleado = empleado;
    }
    
    public Usuario(int idUsuario, String usuario, String contrasenia, Empleado empleado) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.empleado = empleado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    } 

    @Override
    public int compareTo(Usuario o) {
     
        return this.usuario.compareTo(o.usuario);
    }

   
}
