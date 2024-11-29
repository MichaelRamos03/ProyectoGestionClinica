package Estructuras;


import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class ABinarioBusqueda<T> extends ArbolBinario {

    public ABinarioBusqueda() {
        super();
    }

    public <T extends Comparable> void insertar(T clave) {
        super.setRaiz(insertar(clave, super.getRaiz()));
    }

    private <T extends Comparable> NodoArbol insertar(T clave, NodoArbol r) {
        if (r == null) {
            r = new NodoArbol(clave);
        } else if (clave.compareTo(r.getClave()) < 0) {
            NodoArbol izd;
            izd = insertar(clave, r.getIzquierda());
            r.setIzquierda(izd);
        } else if (clave.compareTo(r.getClave()) > 0) {
            NodoArbol drcha;
            drcha = insertar(clave, r.getDerecha());
            r.setDerecha(drcha);
        } else {
            JOptionPane.showMessageDialog(null, "Error claves duplicadas");
        }
        return r;
    }

    public ArrayList preOrdenNID() {
        ArrayList a = new ArrayList();
        return super.preOrdenNID(a, super.getRaiz());
    }

    public ArrayList InOrdenIND() {
        ArrayList a = new ArrayList();
        return super.InOrdenIND(a, super.getRaiz());
    }

    public ArrayList PostOrdenIDN() {
        ArrayList a = new ArrayList();
        return super.PostOrdenIDN(a, super.getRaiz());
    }
    
    public <T extends Comparable> void eliminar(T clave) {
        super.setRaiz(eliminar(clave, super.getRaiz()));
    }

    public <T extends Comparable> NodoArbol eliminar(T clave, NodoArbol r) {
        if (r == null) {
            r = null;
        } else if (clave.compareTo(r.getClave()) < 0) {
            NodoArbol actIz;
            actIz = eliminar(clave, r.getIzquierda());
            r.setIzquierda(actIz);
        } else if (clave.compareTo(r.getClave()) > 0) {
            NodoArbol actDe;
            actDe = eliminar(clave, r.getDerecha());
            r.setDerecha(actDe);
        } else {
            NodoArbol quitar = r;
            
            if (quitar.getIzquierda() == null) {
                r = quitar.getDerecha();
            } else if (quitar.getDerecha() == null) {
                r = quitar.getIzquierda();
            } else {
               quitar = remplazar(quitar);
            }
        }
        return r;
    }
    
    private NodoArbol remplazar(NodoArbol actual){
        NodoArbol ant;
        NodoArbol aux;
        
        ant = actual;
        aux = actual.getIzquierda();
        while(aux.getDerecha() != null){
            ant = aux;
            aux = aux.getDerecha();
        }
        actual.setClave(aux.getClave());
        if (ant == actual) {
            ant.setIzquierda(aux.getIzquierda());
        } else {
            ant.setDerecha(aux.getIzquierda());
        }
        return aux;
    }
}
