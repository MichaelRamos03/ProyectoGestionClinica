
package Interfaces;

import Estructuras.ABinarioBusqueda;
import Estructuras.ListaDoble;
import Modelo.EntregaMedicina;

/**
 *
 * @author Michael Ramos;
 */
public interface IEntregaMedicina {
    
    public ListaDoble<EntregaMedicina> selectAll();
    public boolean insert(EntregaMedicina obj);
    public boolean update(EntregaMedicina obj);
    public boolean delete(EntregaMedicina obj);
   public ABinarioBusqueda<EntregaMedicina> buscar();
    
}
