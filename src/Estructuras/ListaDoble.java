package Estructuras;
import java.util.ArrayList;

public class ListaDoble<T> {

    private NodoDoble<T> lista;

    public ListaDoble() {
        lista = null;
    }

    public <T extends Comparable> void insertar(T contenido) {
        NodoDoble nodito = new NodoDoble(contenido);
        if (isEmpty()) {
            lista = nodito;
            
        } // si lo que se quiere ingresar de lo que tiene lista 
        else if (contenido.compareTo(lista.getDato()) < 0) { // almacena datos de mayor a menor
            nodito.setSiguiente(lista);

            lista = nodito;

            nodito.getSiguiente().setAnterior(nodito);

        } else {
            NodoDoble aux = ubicar(contenido);
            nodito.setSiguiente(aux.getSiguiente());
            if (aux.getSiguiente() != null) {
                aux.getSiguiente().setAnterior(nodito);
            }

            aux.setSiguiente(nodito);

            nodito.setAnterior(aux);

            //aux.getSiguiente().setAnterior(aux);
        }

    }
    // deberia funcionar bien igual que buscarnodo

    public <T extends Comparable> T buscarDato(T contenido) {
        NodoDoble next = lista;
        while (next != null) {

            if (contenido.compareTo(next.getDato()) == 0) {
                return (T) next.getDato();
            }
            next = next.getSiguiente();
        }
        return null;
    }

    public <T extends Comparable> NodoDoble buscarNodoDoble(T contenido) {
        NodoDoble aux = lista;
        while (aux != null) {
            if (contenido.compareTo(aux.getDato()) == 0) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    // modificar
    public <T extends Comparable> void eliminar(T contenido) {
        NodoDoble aux = buscarNodoDoble(contenido);
        if (aux != null) {
            if (lista == aux) {
                lista = lista.getSiguiente();
                if (lista != null) {
                    lista.setAnterior(null);
                }
            } else {
                NodoDoble ubicar = ubicar(contenido);
                ubicar.setSiguiente(aux.getSiguiente());
                if (ubicar.getSiguiente() != null) {
                    ubicar.getSiguiente().setAnterior(ubicar);
                }
            }
        }
        aux = null;

    }

    public <T extends Comparable> NodoDoble ubicar(T contenido) {
        NodoDoble next = lista;
        NodoDoble anterior = lista;
        while (next.getSiguiente() != null && contenido.compareTo(next.getDato()) > 0) {
            anterior = next;
            next = next.getSiguiente();

        }
        //insertando 55 para que anterior sea 50
        // al querer insertar al final ya que en el while anterior termina en 25 y deberia quedar en 50, haciendo que no sea entre dos numeros
        if (contenido.compareTo(next.getDato()) > 0) {
            anterior = next;
        }

        return anterior;
    }

    public boolean isEmpty() {
        return lista == null;

    }

    public ArrayList<T> toArray() {
        ArrayList<T> array = new ArrayList<>();

        NodoDoble<T> actual = lista;
        while (actual != null) {
            array.add(actual.getDato());
            actual = actual.getSiguiente();
        }
        return array;

    }

    public ArrayList<T> toArrayDes() {
        ArrayList<T> array = new ArrayList<>();

        NodoDoble<T> actual = fin();

        while (actual != null) {
            array.add(actual.getDato());
            actual = actual.getAnterior();
        }
        return array;

    }

    public NodoDoble<T> fin() {
        NodoDoble<T> next = lista;
        // si y solo si la lista esta vacia
        if (isEmpty()) {
            return null;
        }

        while (next.getSiguiente() != null) {

            next = next.getSiguiente();
        }

        return next;
    }

    public T get(int index) {
        NodoDoble<T> actual = lista;
        int contador = 0;

        while (actual != null) {
            if (contador == index) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
            contador++;
        }
        return null;
    }

}
