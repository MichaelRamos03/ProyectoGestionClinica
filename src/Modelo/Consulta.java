/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author MINEDUCYT
 */
public class Consulta {
    private int idConsulta;
    private int consultorio;
    private String diagnostico;
    private Recepcion recepcion;
    private MedicoEspecialista medicoEspecialista;
    private Expediente expediente;
    private ArrayList<Examen> examenes;
    private ArrayList<Receta> recetas;

    public Consulta() {
        this.examenes = new ArrayList();
        this.recetas = new ArrayList();
    }

    public Consulta(int idConsulta, int consultorio, String diagnostico, Recepcion recepcion, MedicoEspecialista medicoEspecialista, Expediente expediente) {
        this.idConsulta = idConsulta;
        this.consultorio = consultorio;
        this.diagnostico = diagnostico;
        this.recepcion = recepcion;
        this.medicoEspecialista = medicoEspecialista;
        this.expediente = expediente;
        this.examenes = new ArrayList();
        this.recetas = new ArrayList();
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

    public Recepcion getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(Recepcion recepcion) {
        this.recepcion = recepcion;
    }

    public MedicoEspecialista getMedicoEspecialista() {
        return medicoEspecialista;
    }

    public void setMedicoEspecialista(MedicoEspecialista medicoEspecialista) {
        this.medicoEspecialista = medicoEspecialista;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public ArrayList<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(ArrayList<Examen> examenes) {
        this.examenes = examenes;
    }

    public ArrayList<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(ArrayList<Receta> recetas) {
        this.recetas = recetas;
    }  
}
