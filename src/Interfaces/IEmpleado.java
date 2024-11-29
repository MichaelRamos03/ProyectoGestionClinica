
package Interfaces;

import Estructuras.ABinarioBusqueda;
import Estructuras.ColaPrioridad;
import Modelo.Empleado;

/**
 *
 * @author Michael Ramos;
 */
public interface IEmpleado {
    
    public ColaPrioridad<Empleado> selectAll();
     public ColaPrioridad<Empleado> selectAllTo(String atributo, String condicion);
    public boolean insert(Empleado obj);
    public boolean update(Empleado obj);
    public boolean delete(Empleado obj);
   public ABinarioBusqueda<Empleado> buscar();
    
}
