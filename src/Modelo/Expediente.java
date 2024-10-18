
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Michael Ramos;
**/
public class Expediente {

    private int idExpediente;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    ArrayList<Consulta> consultas;

    public Expediente() {
        this.consultas = new ArrayList(); 
    }
    
    
    public Expediente(int idExpediente, String nombre, String apellido, Date fechaNacimiento) {
        this.idExpediente = idExpediente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.consultas = new ArrayList();
    }

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }
}
