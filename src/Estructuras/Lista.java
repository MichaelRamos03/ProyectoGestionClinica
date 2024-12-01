/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Lista<T> {

    private Nodo<T> lista;

    public Lista() {
    }

    public <T extends Comparable> void insertar(T contenido) {
        Nodo nodito = new Nodo(contenido);
        if (isEmpty()) {
            lista = nodito;
        } else if (contenido.compareTo(lista.getDato()) < 0) {
            nodito.setSiguiente(lista);
            lista = nodito;
        } else {
            Nodo aux = ubicar(contenido);
            nodito.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nodito);
        }
    }

    private <T extends Comparable> Nodo ubicar(T contenido) {
        Nodo aux = lista;
        Nodo ant = lista;

        while (aux.getSiguiente() != null && contenido.compareTo(aux.getDato()) > 0) {
            ant = aux;
            aux = aux.getSiguiente();
        }
        if (contenido.compareTo(aux.getDato()) > 0) {
            ant = aux;
        }

        return ant;
    }

    public <T extends Comparable> void eliminar(T contenido) {

        Nodo delete;
        delete = buscarNodo(contenido);

        if (delete != null) {
            if (lista == delete) {
                lista.getSiguiente();
            } else {
                Nodo ubicar;
                ubicar = ubicar(contenido);
                ubicar.setSiguiente(delete.getSiguiente());
            }
        }
        delete = null;
    }

    public <T extends Comparable> T buscarDato(T contenido) {

        Nodo next;
        next = lista;

        while (next != null) {
            if (contenido.compareTo(next.getDato()) == 0) {
                return (T) next.getDato();
            }
            next = next.getSiguiente();
        }

        return null;

    }

    public <T extends Comparable> Nodo buscarNodo(T contenido) {

        Nodo next;
        next = lista;

        while (next != null) {
            if (contenido.compareTo(next.getDato()) == 0) {
                return next;
            }
            next = next.getSiguiente();
        }

        return null;

    }

    public boolean isEmpty() {
        return lista == null;
    }

    public ArrayList toArray() {
        ArrayList<T> list = new ArrayList<>();
        Nodo<T> aux = lista;
        while (aux != null) {
            list.add(aux.getDato());
            aux = aux.getSiguiente();
        }

        return list;
    }
}
