package Estructuras;

import java.util.ArrayList;

/**
 *
 * @author Michael Ramos;
*
 */
public class ColaPrioridad<T> {

    private ArrayList<Nodo> cola;

    public ColaPrioridad(int p) {
        cola = new ArrayList();
        for (int i = 0; i < p; i++) {
            this.cola.add(null);
        }
    }

    public boolean isEmpty() {
        for (int i = 0; i < cola.size(); i++) {
            return false;
        }
        return true;
    }

    public void offer(T contenido, int p) {
        Nodo nodo = new Nodo(contenido);
        Nodo fr = cola.get(p);
        Nodo fn = cola.get(p);

        if (fr == null) {
            cola.set(p, nodo);
        } else {
            while (fn.getSiguiente() != null) {
                fn = fn.getSiguiente();
            }

            fn.setSiguiente(nodo);
        }
    }

    public T peek() {
        for (int i = 0; i < cola.size(); i++) {
            Nodo aux = cola.get(i);
            return (T) aux.getDato();
        }
        return null;
    }

    public int prioridad() {
        for (int i = 0; i < cola.size(); i++) {
            if (cola.get(i) != null) {
                return i;
            }
        }
        return -1;
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        int p = prioridad();
        Nodo fr = cola.get(p);
        T contenido = (T) fr.getDato();
        fr = fr.getSiguiente();
        cola.set(p, fr);
        return contenido;
    }

    public ArrayList<T> toArray() {
        ArrayList array = new ArrayList();
        while (isEmpty()) {
            return null;
        }
        for (int i = 0; i < cola.size(); i++) {
            Nodo fr = cola.get(i);
            while (fr != null) {
                array.add(fr.getDato());
                fr = fr.getSiguiente();
            }
        }
        return array;
    }

    public T get(int index) {
        int contador = 0;

        for (Nodo<T> nodo : cola) {
            while (nodo != null) {
                if (contador == index) {
                    return nodo.getDato();
                }
                nodo = nodo.getSiguiente();
                contador++;
            }
        }

        throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
    }

}
