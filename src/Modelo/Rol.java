
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Michael Ramos;
**/
public class Rol {
    private int idRol;
    private String rol;
    private ArrayList<Empleado> listEmpleado;

    public Rol() {
        this.listEmpleado = new ArrayList();
    }
    
    public Rol(int idRol, String rol) {
        this.idRol = idRol;
        this.rol = rol;
        this.listEmpleado = new ArrayList();
    }


    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public ArrayList<Empleado> getListEmpleado() {
        return listEmpleado;
    }

    public void setListEmpleado(ArrayList<Empleado> listEmpleado) {
        this.listEmpleado = listEmpleado;
    }
}
