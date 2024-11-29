
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author karla
 */
public class Empleado implements Comparable<Empleado>{
    
    private int idEmpleado;
    private String dui;
    private String nombre;
    private String apellido;
    private String genero;
    private Date fechaNacimiento;
    private String correo;
    private boolean estado;
    private Rol rol;
    private String Prioridad;
    private ArrayList<Usuario> usuarios;
    private ArrayList<MedicoEspecialista> especialistas;
    

    public Empleado() {
        this.usuarios = new ArrayList();
        this.especialistas = new ArrayList();
    }

    public Empleado(String dui, String nombre, String apellido, String genero, Date fechaNacimiento, String correo, boolean estado, Rol rol, String Prioridad) {
        this.dui = dui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.estado = estado;
        this.rol = rol;
        this.Prioridad = Prioridad;
    }

 

    public Empleado(int idEmpleado, String dui, String nombre, String apellido, String genero, Date fechaNacimiento, String correo, boolean estado, Rol rol, String Prioridad) {
        this.idEmpleado = idEmpleado;
        this.dui = dui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.estado = estado;
        this.rol = rol;
        this.Prioridad = Prioridad;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getPrioridad() {
        return Prioridad;
    }

    public void setPrioridad(String Prioridad) {
        this.Prioridad = Prioridad;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<MedicoEspecialista> getEspecialistas() {
        return especialistas;
    }

    public void setEspecialistas(ArrayList<MedicoEspecialista> especialistas) {
        this.especialistas = especialistas;
    }
    
    
   
    @Override
    public int compareTo(Empleado o) {
       Empleado actual=this;
    return actual.nombre.compareToIgnoreCase(o.nombre);
    
   }
    
 @Override
public String toString() {
    return "Id:" + this.idEmpleado + " " + this.nombre + " " + this.apellido;
}



}
