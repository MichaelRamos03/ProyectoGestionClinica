

package Modelo;

import java.util.Date;

/**
 *
 * @author Michael Ramos;
**/
public class Examen {
    
    private int idExamen;
    private String nombre;
    private String tipo;
    private String descripcion;
    private Date fechaProgramada;
    private Date fechaRealizacion;
    private Consulta consulta;

    public Examen() {
    }

    public Examen(int idExamen, String nombre, String tipo, String descripcion, Date fechaProgramada, Date fechaRealizacion, Consulta consulta) {
        this.idExamen = idExamen;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaProgramada = fechaProgramada;
        this.fechaRealizacion = fechaRealizacion;
        this.consulta = consulta;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(Date fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
