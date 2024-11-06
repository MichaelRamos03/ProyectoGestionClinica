

package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Michael Ramos;
**/
public class Medicamento implements Comparable<Medicamento>{
    
    private int idMedicamento;
    private String nombre;
    private int cantidadDisponible;
    private Date fechaCaducidad;
    private String descripcion;
    private Double precio;
    ArrayList<EntregaMedicina> EntregaMedicinas; 

    public Medicamento() {
        this.EntregaMedicinas = new ArrayList();
    }

    public Medicamento(int idMedicamento, String nombre, int cantidadDisponible) {
        this.idMedicamento = idMedicamento;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.EntregaMedicinas = new ArrayList();
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public ArrayList<EntregaMedicina> getEntregaMedicinas() {
        return EntregaMedicinas;
    }

    public void setEntregaMedicinas(ArrayList<EntregaMedicina> EntregaMedicinas) {
        this.EntregaMedicinas = EntregaMedicinas;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public int compareTo(Medicamento o) {
    Medicamento actual=this;
    return actual.nombre.compareToIgnoreCase(o.nombre);
    
    }
    
    
}
