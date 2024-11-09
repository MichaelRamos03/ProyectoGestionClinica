
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
    private String sexo;
    private String telefono;
    private String informacionMedica;
    private String tratamiento;
    private String notaMedica;
    private String alergias;
    private String medicamentos;
    private ArrayList<Consulta> consultas;

    public Expediente() {
        this.consultas = new ArrayList(); 
    }

    public Expediente(int idExpediente, String nombre, String apellido, Date fechaNacimiento, String sexo, String telefono, String informacionMedica, String tratamiento, String notaMedica, String alergias, String medicamentos) {
        this.idExpediente = idExpediente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.telefono = telefono;
        this.informacionMedica = informacionMedica;
        this.tratamiento = tratamiento;
        this.notaMedica = notaMedica;
        this.alergias = alergias;
        this.medicamentos = medicamentos;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getInformacionMedica() {
        return informacionMedica;
    }

    public void setInformacionMedica(String informacionMedica) {
        this.informacionMedica = informacionMedica;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getNotaMedica() {
        return notaMedica;
    }

    public void setNotaMedica(String notaMedica) {
        this.notaMedica = notaMedica;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }
    
    
}
