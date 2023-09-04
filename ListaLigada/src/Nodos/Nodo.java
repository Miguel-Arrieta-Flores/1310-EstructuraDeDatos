package Nodos;

public class Nodo {
    public Object dato;
    public Nodo siguiente;
    public Nodo() {
    }

    public Nodo(Object dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Nodos.Nodo{" +
                "dato=" + dato +
                ", siguiente=" + siguiente +
                '}';
    }
}
