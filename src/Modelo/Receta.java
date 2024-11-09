
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Michael Ramos;
**/
public class Receta {
    private int idReceta;
    private int cantidad;
    private int dosis;
    private Consulta consulta;
    private ArrayList<EntregaMedicina> entregaMedicina;

    public Receta() {
        this.entregaMedicina = new ArrayList();
    }

    public Receta(int idReceta, int cantidad, int dosis, Consulta consulta, ArrayList<EntregaMedicina> entregaMedicina) {
        this.idReceta = idReceta;
        this.cantidad = cantidad;
        this.dosis = dosis;
        this.consulta = consulta;
        this.entregaMedicina = entregaMedicina;
        this.entregaMedicina = new ArrayList();
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public ArrayList<EntregaMedicina> getEntregaMedicina() {
        return entregaMedicina;
    }

    public void setEntregaMedicina(ArrayList<EntregaMedicina> entregaMedicina) {
        this.entregaMedicina = entregaMedicina;
    }
}