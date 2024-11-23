package Estructuras;


import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class ArbolBinario <T>{
    NodoArbol raiz;

    public ArbolBinario() {
        this.raiz = null;
    }
    
    public boolean isEmpty(){
        return this.raiz == null;
    } 

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
    protected ArrayList preOrdenNID(ArrayList a,NodoArbol r){
        if (r != null) {
            a.add(r.getClave());
            preOrdenNID(a, r.getIzquierda());
            preOrdenNID(a, r.getDerecha());
        }
        return a;
    }
    
    protected ArrayList InOrdenIND(ArrayList a,NodoArbol r){
        if (r != null) {
            InOrdenIND(a, r.getIzquierda());
            a.add(r.getClave());
            InOrdenIND(a, r.getDerecha());
        }
        return a;
    }
    
    protected ArrayList PostOrdenIDN(ArrayList a,NodoArbol r){
        if (r != null) {
            PostOrdenIDN(a, r.getIzquierda());
            PostOrdenIDN(a, r.getDerecha());
            a.add(r.getClave());
        }
        return a;
    }
    
    public <T extends Comparable> NodoArbol buscar(T clave){
        return buscar(clave, raiz);
    }
    
    private <T extends Comparable> NodoArbol buscar(T clave, NodoArbol r) {
        if (r == null) {
            r = null;
        } else if (clave.compareTo(r.getClave()) < 0) {
            return buscar(clave, r.getIzquierda());
        } else if (clave.compareTo(r.getClave()) > 0) {
           return buscar(clave, r.getDerecha());
        } else if (clave.compareTo(r.getClave()) == 0) {
            return r;
        }
        return r;
    }
    
}
