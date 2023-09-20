package Colas;

import Nodo.Nodo;

public class Cola {

    private Nodo cabecera;
    private Nodo ultimo;

    public Cola() {
        this.cabecera=null;
        this.ultimo=null;
    }

    public Cola(Nodo cabecera, Nodo ultimo) {
        this.cabecera = cabecera;
        this.ultimo = ultimo;
    }

    public Nodo getCabecera() {
        return cabecera;
    }

    public void setCabecera(Nodo cabecera) {
        this.cabecera = cabecera;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    @Override
    public String toString() {
        return "Cola{" +
                "cabecera=" + cabecera +
                ", ultimo=" + ultimo +
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

    public int longitudCola(){
        Nodo actual=new Nodo();
        actual=ultimo;
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

    public void desplegarCola(){
        Nodo actual=new Nodo();
        actual=ultimo;
        String cola="";
        if (empty()==false){
            if (longitudCola()==1){
                cola=" ["+actual.dato+"] ";
            }
            else {
                while (actual!=null){
                    cola=cola+" ["+actual.dato+"] ";
                    actual=actual.siguiente;
                }
            }
            System.out.println("||"+cola+"||");
        }
        else {
            System.out.println("La cola esta vacia");
        }
    }

    public Object peek(){
        if (longitudCola()>0){
            return cabecera.dato;
        }
        else {
            return null;
        }
    }

    public void enqueue(Object val){
        Nodo nuevo=new Nodo();
        nuevo.dato=val;
        Nodo anterior=new Nodo();
        Nodo actual=new Nodo();
        actual=ultimo;
        if(ultimo==null) {
            ultimo=nuevo;
            ultimo.siguiente=null;
            cabecera=nuevo;
        }
        else {
            anterior=ultimo.siguiente;
            ultimo=nuevo;
            ultimo.siguiente=actual;
            actual.siguiente=anterior;
        }
        System.out.println("Nodo ingresado exitosamente");
        desplegarCola();
    }

    public void dequeue(){
        Nodo actual=new Nodo();
        actual=ultimo;
        Nodo anterior=new Nodo();
        anterior=null;
        if (empty()==false){
            if(longitudCola()==1) {
                    cabecera=null;
            }
            else {
                while (actual != null) {
                    if (actual == cabecera) {
                        anterior.siguiente = null;
                        cabecera = anterior;
                    }
                    anterior = actual;
                    actual = actual.siguiente;
                }
            }
            System.out.println("Nodo eliminado");
            desplegarCola();
        }
        else{
            System.out.println("La cola está vacía");
        }
    }

    public void buscar(int index){
        Nodo actual=new Nodo();
        actual=ultimo;
        boolean encontrado=false;
        int i= longitudCola()-(index+1);
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
            System.out.println("La cola está vacía");
        }
    }

}
