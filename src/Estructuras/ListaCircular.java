package Estructuras;

import Modelo.Medicamento;
import ModeloDao.MedicamentoDao;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author karla
 */
public class ListaCircular<T> {

    // lista simple (ordenada)
    //private NodoDoble<T> lista1;
    private Nodo<T> lista;
    private MedicamentoDao medicamentoDao;

    public ListaCircular() {
        lista = null;
        //medicamentoDao= new MedicamentoDao();
    }

    /*
     public <T extends Comparable> void insertarMedicamento(T contenido) {
        Nodo nodito = new Nodo(contenido);
        Medicamento medicamento=  (Medicamento) contenido;
        
        if (isEmpty()) {
            lista = nodito;
            lista.setSiguiente(nodito);
            
        } else if (contenido.compareTo(lista.getDato()) < 0) { // almacena datos de mayor a menor
            // insertando valores que sean menores a los de la lista
            Nodo aux = fin();
            nodito.setSiguiente(lista);
            lista = nodito;
            aux.setSiguiente(nodito);
           
        } else {
            Nodo aux = ubicar(contenido);
            nodito.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nodito);
            
        }
         medicamentoDao.insert(medicamento);
    }
     */
    public <T extends Comparable> void insertar(T contenido) {
        Nodo nodito = new Nodo(contenido);

        if (isEmpty()) {
            lista = nodito;
            lista.setSiguiente(nodito);
        } else if (contenido.compareTo(lista.getDato()) < 0) { // almacena datos de mayor a menor
            // insertando valores que sean menores a los de la lista
            Nodo aux = fin();
            nodito.setSiguiente(lista);
            lista = nodito;
            aux.setSiguiente(nodito);

        } else {
            Nodo aux = ubicar(contenido);
            nodito.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nodito);

        }

    }

    public <T extends Comparable> T buscarDato(T contenido) {
        Nodo next = lista;
        if (isEmpty()) {
            return null;
        }

        do {

            if (contenido.compareTo(next.getDato()) == 0) {
                return (T) next.getDato();
            }
            next = next.getSiguiente();
        } while (next != lista);

        return null;
    }

    public <T extends Comparable> Nodo buscarNodo(T contenido) {
        Nodo aux = lista;
        if (isEmpty()) {
            return null;
        }

        do {

            if (contenido.compareTo(aux.getDato()) == 0) {
                return aux;
            }
            aux = aux.getSiguiente();

        } while (aux != lista);

        return null;
    }

    public <T extends Comparable> void eliminar(T contenido) {
        Nodo delete = buscarNodo(contenido);
        if (delete != null) {
            if (lista == delete) {
                if (lista.getSiguiente() != lista) {
                    Nodo aux = fin();
                    lista = delete.getSiguiente();
                    aux.setSiguiente(lista);
                } else {
                    lista = null;
                }

            } else {
                Nodo anterior = ubicar(contenido);
                anterior.setSiguiente(delete.getSiguiente());
            }
        }
        delete = null;

    }
    // ubica uno antes

    public <T extends Comparable> Nodo ubicar(T contenido) {
        Nodo next = lista;
        Nodo anterior = lista;
        while (next.getSiguiente() != lista && contenido.compareTo(next.getDato()) > 0) {
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

    public <T extends Comparable> Nodo fin() {
        Nodo next = lista;
        // si y solo si la lista esta vacia
        if (isEmpty()) {
            return null;
        }

        while (next.getSiguiente() != lista) {

            next = next.getSiguiente();

        }

        return next;
    }

    public boolean isEmpty() {
        return lista == null;

    }

    public ArrayList<T> toArray() {
        ArrayList<T> array = new ArrayList<>();

        Nodo<T> actual = lista;
        if (isEmpty()) {
            return null;
        }

        do {
            array.add(actual.getDato());
            actual = actual.getSiguiente();
        } while (actual != lista);
        return array;

    }

    public T get(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("La lista está vacía");
        }

        int contador = 0;
        Nodo<T> actual = lista;

        do {
            if (contador == index) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
            contador++;
        } while (actual != lista);

        throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
    }

}
