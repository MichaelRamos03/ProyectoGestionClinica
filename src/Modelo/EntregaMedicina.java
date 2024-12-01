
package Modelo;

/**
 *
 * @author Michael Ramos;
**/
public class EntregaMedicina implements Comparable<EntregaMedicina>{
    private int idEntregaMedicina;
    private Medicamento medicamento;
    private Receta receta;
    private Empleado empleado;

    public EntregaMedicina(){
    }

    public EntregaMedicina(int idEntregaMedicina, Medicamento medicamento, Receta receta, Empleado empleado) {
        this.idEntregaMedicina = idEntregaMedicina;
        this.medicamento = medicamento;
        this.receta = receta;
        this.empleado = empleado;
    }

    public EntregaMedicina(Medicamento medicamento, Receta receta, Empleado empleado) {
        this.medicamento = medicamento;
        this.receta = receta;
        this.empleado = empleado;
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

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int compareTo(EntregaMedicina o) {
        return Integer.compare(this.idEntregaMedicina, o.idEntregaMedicina);
    }
}
