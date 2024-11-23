package Estructuras;


/**
 *
 * @author Estudiante
 */
public class NodoArbol <T> {
    
    private T clave;
    private NodoArbol izquierda;
    private NodoArbol derecha;
    int alt;

    public NodoArbol() {
    }
    
    

    public NodoArbol(T clave) {
        this.clave = clave;
        this.izquierda = null;
        this.derecha = null;
    }

    public NodoArbol(T clave, NodoArbol izquierda, NodoArbol derecha) {
        this.clave = clave;
        this.izquierda = izquierda;
        this.derecha = derecha;
        alt = 0;
    }
    public T getClave() {
        return clave;
    }

    public void setClave(T clave) {
        this.clave = clave;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }

    public int getAlt() {
        return alt;
    }

    public void setAlt(int alt) {
        this.alt = alt;
    }
    
    

    @Override
    public String toString() {
        return clave +"";
    }
    
    
}
