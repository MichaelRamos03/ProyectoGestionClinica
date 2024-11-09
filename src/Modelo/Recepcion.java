

package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Michael Ramos;
**/
public class Recepcion {
    private int idRecepcion;
    private String presion;
    private String altura;
    private String peso;
    private String temperatura;
    private int frecuenciaCardiaca;
    private String motivoVisita;
    private String observaciones;
    private ArrayList<Consulta> consultas;
    private EntregaMedicina entregaMedicina;

    public Recepcion() {
        this.consultas = new ArrayList();
    }

    public Recepcion(int idRecepcion, String presion, String altura, String peso, String temperatura, int frecuenciaCardiaca, String motivoVisita, String observaciones, EntregaMedicina entregaMedicina) {
        this.idRecepcion = idRecepcion;
        this.presion = presion;
        this.altura = altura;
        this.peso = peso;
        this.temperatura = temperatura;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.motivoVisita = motivoVisita;
        this.observaciones = observaciones;
        this.entregaMedicina = entregaMedicina;
        this.consultas = new ArrayList();
    }

    public int getIdRecepcion() {
        return idRecepcion;
    }

    public void setIdRecepcion(int idRecepcion) {
        this.idRecepcion = idRecepcion;
    }

    public String getPresion() {
        return presion;
    }

    public void setPresion(String presion) {
        this.presion = presion;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public int getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

    public EntregaMedicina getEntregaMedicina() {
        return entregaMedicina;
    }

    public void setEntregaMedicina(EntregaMedicina entregaMedicina) {
        this.entregaMedicina = entregaMedicina;
    }
}
