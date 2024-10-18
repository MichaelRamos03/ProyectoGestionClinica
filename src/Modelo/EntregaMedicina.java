
package Modelo;

/**
 *
 * @author Michael Ramos;
**/
public class EntregaMedicina {
    private int idEntregaMedicina;
    private int integer;
    private String dosis;
    private Consulta consulta;
    private Medicamento medicamento;

    public EntregaMedicina() {
    }

    public EntregaMedicina(int idEntregaMedicina, int integer, String dosis, Consulta consulta, Medicamento medicamento) {
        this.idEntregaMedicina = idEntregaMedicina;
        this.integer = integer;
        this.dosis = dosis;
        this.consulta = consulta;
        this.medicamento = medicamento;
    }

    public int getIdEntregaMedicina() {
        return idEntregaMedicina;
    }

    public void setIdEntregaMedicina(int idEntregaMedicina) {
        this.idEntregaMedicina = idEntregaMedicina;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
}
