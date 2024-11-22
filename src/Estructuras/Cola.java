package Estructuras;

import java.util.ArrayList;

public class Cola<T> {

    private Nodo<T> fr;
    private Nodo<T> fn;

    public Cola() {
        this.fn = this.fr = null; //SE ENCARGA DE HACER UNA COLA VACIA (NULA)
        //this.fn = null;
        //this.fr = null; 
    }

    public boolean isEmpty() {
        return fr == null && fn == null;  //REVISA QUE AMBAS PARTES ESTEN VACIAS
    }

    public ArrayList<T> toArray() {
        ArrayList<T> lista = new ArrayList<>();
        Nodo<T> actual = fr;
        while (actual != null) {
            lista.add(actual.getDato());
            actual = actual.getSiguiente();
        }
        return lista;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return fr.getDato();
    }

    public void offer(T contenido) {
        Nodo nodito = new Nodo(contenido);
        if (isEmpty()) {
            fr = nodito;
            fn = nodito;
        } else {
            fn.setSiguiente(nodito);
            //fn = fn.getSiguiente();
            //OTRA FORMA 
        }
        fn = nodito;
    }

    public T poll() { //ATIENDE AL PRIMERO OWO
        if (!isEmpty()) {
            T contenido = fr.getDato();

            if (fr == fn) { //OTRA FORMA: fr.getSiguiente() == null
                fr = fn = null;
            } else {
                fr = fr.getSiguiente();
            }
            return contenido;
        }
        return null;
    }
    
    public void clearAll(){
        fr = fn = null;
        System.out.println("COLA VACIADA");
    }

}