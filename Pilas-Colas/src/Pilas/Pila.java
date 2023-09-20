package Pilas;
import Nodo.Nodo;

public class Pila {
    private Nodo cabecera;

    public Pila() {
        this.cabecera=null;
    }

    public Pila(Nodo cabecera) {
        this.cabecera = cabecera;
    }

    public Nodo getCabecera() {
        return cabecera;
    }

    public void setCabecera(Nodo cabecera) {
        this.cabecera = cabecera;
    }

    @Override
    public String toString() {
        return "Pila{" +
                "cabecera=" + cabecera +
                '}';
    }

    public boolean empty(){
        if (cabecera==null){
            return true;
        }
        else {
            return false;
        }
    }

    public int longitudPila(){
        Nodo actual=new Nodo();
        actual=cabecera;
        int longitud=0;
        int i=1;
        if (empty()==false) {
            while (actual.siguiente != null) {
                actual = actual.siguiente;
                i++;
            }
            longitud=i;
        }else {
            longitud=0;
        }
        return longitud;
    }

    public void desplegarPila(){
        Nodo actual=new Nodo();
        actual=cabecera;
        if (empty()==false){
            System.out.println("---------");
            while (actual!=null){
                System.out.println("["+actual.dato+"]");
                actual=actual.siguiente;
            }
            System.out.println("---------");
        }
        else {
            System.out.println("La pila esta vacia");
        }
    }

    public Object peek(){
        if (longitudPila()>0){
            return cabecera.dato;
        }
        else {
            return null;
        }
    }

    public void push(Object val){
        Nodo nuevo=new Nodo();
        nuevo.dato=val;
        Nodo anterior=new Nodo();
        Nodo actual=new Nodo();
        actual=cabecera;
        if(cabecera==null)
        {
            cabecera=nuevo;
            cabecera.siguiente=null;
        }
        else {
            anterior=cabecera.siguiente;
            cabecera=nuevo;
            cabecera.siguiente=actual;
            actual.siguiente=anterior;
        }
        System.out.println("Nodo ingresado exitosamente");
        desplegarPila();
    }

    public void pop(){
        if (empty()==false){
            cabecera=cabecera.siguiente;
            System.out.println("Nodo eliminado");
            desplegarPila();
        }
        else{
            System.out.println("La pila está vacía");
        }
    }

    public void buscar(int index){
        Nodo actual=new Nodo();
        actual=cabecera;
        boolean encontrado=false;
        int i= longitudPila()-(index+1);
        if (empty() == false){
            while (actual!=null && encontrado!=true){
                if(i==0){
                    System.out.println("Nodo con el dato ["+actual.dato+"] encontrado");
                    encontrado=true;
                }
                i--;
                actual=actual.siguiente;
            }
            if (!encontrado){
                System.out.println("El nodo no fue encontrado");
            }
        }
        else{
            System.out.println("La pila está vacía");
        }
    }

}
