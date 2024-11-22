
package Interfaces;

import Estructuras.ColaPrioridad;
import Modelo.Empleado;

/**
 *
 * @author Michael Ramos;
 */
public interface IEmpleado {
    
    public ColaPrioridad<Empleado> selectAll();
    public boolean insert(Empleado obj);
    public boolean update(Empleado obj);
    public boolean delete(Empleado obj);
    public ColaPrioridad<Empleado> buscar(String dato);
    
}
