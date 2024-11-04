package Estructuras;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author karla
 */
public class Nodo<T> {
    
    private T contenido;
    private Nodo<T> siguiente; // autoreferencia la misma clase se utiliza a ella misma

    
    public Nodo() {
        this.contenido=null;
        this.siguiente=null;
    }

    public Nodo(T contenido) {
        this.contenido = contenido;
        this.siguiente=null;
    }

    
    public Nodo(T contenido, Nodo<T> siguiente) {
        this.contenido = contenido;
        this.siguiente = siguiente;
    }
    

    public T getDato(){
        return contenido;
    }
    
    public void setDato(T contenido){
        this.contenido=contenido;
    }
    

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
