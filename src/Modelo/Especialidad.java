
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author MINEDUCYT
 */
public class Especialidad implements Comparable<Especialidad> {
    private int idEspecialidad;
    private String especialidad;
    private ArrayList<MedicoEspecialista> listMedicoEspecialista;

    public Especialidad() {
        this.listMedicoEspecialista = new ArrayList();
    }

    public Especialidad(String especialidad) {
        this.especialidad = especialidad;
        this.listMedicoEspecialista = new ArrayList();
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

    @Override
    public int compareTo(Especialidad o) {
         Especialidad actual = this;
        return actual.especialidad.compareToIgnoreCase(o.especialidad);
    }
    
    @Override
    public String toString() {
    return especialidad; // Muestra el nombre de la especialidad
}
}
