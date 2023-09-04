package Nodos;

public class NodoD {
    public Object dato;
    public NodoD siguiente;
    public NodoD anterior;

    public NodoD() {
    }

    public NodoD(Object dato, NodoD siguiente, NodoD anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public NodoD getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoD anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "Nodos.NodoD{" +
                "dato=" + dato +
                ", siguiente=" + siguiente +
                ", anterior=" + anterior +
                '}';
    }
}
