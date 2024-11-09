
package Modelo;

/**
 *
 * @author Michael Ramos;
**/
public class EntregaMedicina {
    private int idEntregaMedicina;
    private Receta receta;
    private Recepcion recepcion;
    private Medicamento medicamento;

    public EntregaMedicina() {
    }

    public EntregaMedicina(int idEntregaMedicina, Receta receta, Recepcion recepcion, Medicamento medicamento) {
        this.idEntregaMedicina = idEntregaMedicina;
        this.receta = receta;
        this.recepcion = recepcion;
        this.medicamento = medicamento;
    }

    public int getIdEntregaMedicina() {
        return idEntregaMedicina;
    }

    public void setIdEntregaMedicina(int idEntregaMedicina) {
        this.idEntregaMedicina = idEntregaMedicina;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Recepcion getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(Recepcion recepcion) {
        this.recepcion = recepcion;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
}
