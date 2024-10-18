/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author MINEDUCYT
 */
public class Consulta {
    private int idConsulta;
    private int consultorio;
    private String diagnostico;
    private String presion;
    private String peso;
    private String altura;
    private Expediente expediente;
    private MedicoEspecialista medicoEspecialista;

    public Consulta(int idConsulta, int consultorio, String diagnostico, String presion, String peso, String altura, Expediente expediente, MedicoEspecialista medicoEspecialista) {
        this.idConsulta = idConsulta;
        this.consultorio = consultorio;
        this.diagnostico = diagnostico;
        this.presion = presion;
        this.peso = peso;
        this.altura = altura;
        this.expediente = expediente;
        this.medicoEspecialista = medicoEspecialista;
    }

    public Consulta() {
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(int consultorio) {
        this.consultorio = consultorio;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPresion() {
        return presion;
    }

    public void setPresion(String presion) {
        this.presion = presion;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public MedicoEspecialista getMedicoEspecialista() {
        return medicoEspecialista;
    }

    public void setMedicoEspecialista(MedicoEspecialista medicoEspecialista) {
        this.medicoEspecialista = medicoEspecialista;
    }
    
    
}
