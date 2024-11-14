package Estructuras;

/**
 *
 * @author karla
 */
public class NodoDoble<T> {
    
    private T contenido;
    private NodoDoble<T> siguiente; // autoreferencia la misma clase se utiliza a ella misma
    private NodoDoble<T> anterior;
    
    public NodoDoble() {
        this.contenido=null;
        this.siguiente=null;
        this.anterior=null;
    }

    public NodoDoble(T contenido) {
        this.contenido = contenido;
        this.siguiente=null;
        this.anterior=null;
        
    }

    public NodoDoble(T contenido, NodoDoble<T> siguiente, NodoDoble<T> anterior) {
        this.contenido = contenido;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    
  
    

    public T getDato(){
        return contenido;
    }

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public NodoDoble<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }
    
  
    
    
}
