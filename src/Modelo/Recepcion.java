package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Michael Ramos;
*
 */
public class Recepcion implements Comparable<Recepcion> {

    private int idRecepcion;
    private String presion;
    private String altura;
    private String peso;
    private String temperatura;
    private int frecuenciaCardiaca;
    private String motivoVisita;
    private String observaciones;
    private ArrayList<Consulta> consultas;
    private Empleado empleado;
    private String prioridad;

    public Recepcion() {

    }

    public Recepcion(int idRecepcion, String presion, String altura, String peso, String temperatura, int frecuenciaCardiaca, String motivoVisita, String observaciones, ArrayList<Consulta> consultas, Empleado empleado, String prioridad) {
        this.idRecepcion = idRecepcion;
        this.presion = presion;
        this.altura = altura;
        this.peso = peso;
        this.temperatura = temperatura;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.motivoVisita = motivoVisita;
        this.observaciones = observaciones;
        this.consultas = consultas;
        this.empleado = empleado;
        this.prioridad = prioridad;
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

   @Override
public int compareTo(Recepcion o) {
    // Asignamos un valor numérico a la prioridad de este objeto
    int prioridad1 = getPrioridadValor(this.prioridad); 
    // Asignamos un valor numérico a la prioridad del otro objeto
    int prioridad2 = getPrioridadValor(o.prioridad); 
    
    // Primero comparamos las prioridades
    int resultadoPrioridad = Integer.compare(prioridad1, prioridad2);

    // Si las prioridades son iguales, comparamos por otro atributo (por ejemplo, el id)
    if (resultadoPrioridad == 0) {
        return Integer.compare(this.idRecepcion, o.idRecepcion);  // O puedes usar cualquier otro atributo para desempatar
    }

    // Si las prioridades son diferentes, devolvemos el resultado de la comparación
    return resultadoPrioridad;
}

// Método para convertir la prioridad a un valor numérico
private int getPrioridadValor(String prioridad) {
    switch (prioridad) {
        case "Maxima Urgencia":
            return 0;
        case "Alta":
            return 1;
        case "Media":
            return 2;
        case "Baja":
            return 3;
        default:
            return Integer.MAX_VALUE; // En caso de que la prioridad no sea válida
    }
}


}
