
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author MINEDUCYT
 */
public class MedicoEspecialista {
    private int idMedicoEspecialista;
    private Empleado idEmpleado;
    private Especialidad idEspecialidad;
    private ArrayList<Consulta> listaConsultas;

    public MedicoEspecialista(int idMedicoEspecialista, Empleado idEmpleado, Especialidad idEspecialidad, ArrayList<Consulta> listaConsultas) {
        this.idMedicoEspecialista = idMedicoEspecialista;
        this.idEmpleado = idEmpleado;
        this.idEspecialidad = idEspecialidad;
        this.listaConsultas = listaConsultas;
    }

    public MedicoEspecialista() {
    }

    public int getIdMedicoEspecialista() {
        return idMedicoEspecialista;
    }

    public void setIdMedicoEspecialista(int idMedicoEspecialista) {
        this.idMedicoEspecialista = idMedicoEspecialista;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Especialidad getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Especialidad idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public ArrayList<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(ArrayList<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }
}
