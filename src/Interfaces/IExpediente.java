
package Interfaces;

import Estructuras.ListaDoble;
import Modelo.Expediente;

/**
 *
 * @author Michael Ramos;
 */
public interface IExpediente {
    
    public ListaDoble<Expediente> selectAll();
    public boolean insert(Expediente obj);
    public boolean update(Expediente obj);
    public boolean delete(Expediente obj);
}
