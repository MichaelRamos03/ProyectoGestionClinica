
package Interfaces;

import Estructuras.ABinarioBusqueda;
import Estructuras.ListaDoble;
import Modelo.Receta;

/**
 *
 * @author Gaby Laínez
 */
public interface IReceta {
    
     public ListaDoble<Receta> selectAll();
    public ListaDoble<Receta> selectAllTo(String atributo, String condicion);
    public boolean insert(Receta obj);
    public boolean update(Receta obj);
    public boolean delete(Receta obj);
    public ABinarioBusqueda<Receta> buscar();
    
}
