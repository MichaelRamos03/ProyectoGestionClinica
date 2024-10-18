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
public class Especialidad {
    private int idEspecialidad;
    private String especialidad;
    private ArrayList<MedicoEspecialista> listMedicoEspecialista;

    public Especialidad() {
    }

    public Especialidad(int idEspecialidad, String especialidad, ArrayList<MedicoEspecialista> listMedicoEspecialista) {
        this.idEspecialidad = idEspecialidad;
        this.especialidad = especialidad;
        this.listMedicoEspecialista = listMedicoEspecialista;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<MedicoEspecialista> getListMedicoEspecialista() {
        return listMedicoEspecialista;
    }

    public void setListMedicoEspecialista(ArrayList<MedicoEspecialista> listMedicoEspecialista) {
        this.listMedicoEspecialista = listMedicoEspecialista;
    }

    
    
    
}
