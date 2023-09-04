package Listas;

import Nodos.NodoD;

public class ListaD extends Lista{
    NodoD primero;
    NodoD ultimo;

    public ListaD(){
        primero=null;
        ultimo=null;
    }

    public ListaD(NodoD primero, NodoD ultimo) {
        this.primero = primero;
        this.ultimo = ultimo;
    }

    public NodoD getPrimero() {
        return primero;
    }

    public void setPrimero(NodoD primero) {
        this.primero = primero;
    }

    public NodoD getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoD ultimo) {
        this.ultimo = ultimo;
    }

    @Override
    public String toString() {
        return "Listas.ListaD{" +
                "primero=" + primero +
                ", ultimo=" + ultimo +
                ", primero=" + primero +
                ", ultimo=" + ultimo +
                "} " + super.toString();
    }

    //Inserta un nodo con el valor que se indique
    public void insertarNodo(Object val){
        NodoD nuevo=new NodoD();
        nuevo.dato=val;
        if (primero==null){
            primero=nuevo;
            primero.siguiente=null;
            primero.anterior=null;
            ultimo=nuevo;
        }
        else {
            ultimo.siguiente=nuevo;
            nuevo.siguiente=null;
            nuevo.anterior=ultimo;
            ultimo=nuevo;
        }
        System.out.println("\nNodo ingresado\n");
    }

    //Inserta un nodo en el indice y conel valor que se indique
    public void insertarPorIndice(int index, Object val){
        NodoD actual=new NodoD();
        actual=primero;
        boolean encontrado=false;
        int i=index-1;
        NodoD anterior=new NodoD();
        NodoD nuevo=new NodoD();
        nuevo.dato=val;
        if (primero != null){
            while (actual!=null && encontrado!=true){
                if (index==1){
                    anterior=primero.siguiente;
                    primero.siguiente = nuevo;
                    actual = actual.siguiente;
                    actual.siguiente = anterior;
                    actual.anterior=nuevo;
                    encontrado=true;
                    System.out.println("Nodo ingresado");
                } else if (index==0) {
                    anterior=primero.siguiente;
                    primero=nuevo;
                    primero.siguiente=actual;
                    actual.siguiente=anterior;
                    primero.siguiente.anterior=primero;
                    encontrado=true;
                    System.out.println("Nodo ingresado");
                }else if (index==longitudLista()){
                    ultimo.siguiente=nuevo;
                    nuevo.siguiente=null;
                    nuevo.anterior=ultimo;
                    ultimo=nuevo;
                    encontrado=true;
                    System.out.println("Nodo ingresado");
                }
                if(i==0){
                    anterior = actual.siguiente;
                    actual.siguiente = nuevo;
                    actual = actual.siguiente;
                    actual.siguiente = anterior;
                    actual.anterior=nuevo;
                    encontrado=true;
                    System.out.println("Nodo ingresado");
                }
                i--;
                actual=actual.siguiente;
            }
            if (!encontrado){
                System.out.println("El indice no fue encontrado");
            }
        }
        else{
            System.out.println("La lista está vacía");
        }
    }

    //Muestra la lista hecha con los nodos
    public void desplegarLista(){
        NodoD actual=new NodoD();
        actual=primero;
        String lista="[";
        if (primero != null){
            while (actual!=null){
                if (actual!=ultimo) {
                    lista = lista + actual.dato + ",";
                }else {
                    lista=lista+actual.dato+"]";
                }
                actual=actual.siguiente;
            }
        }
        else{
            System.out.println("La lista está vacía");
        }
        System.out.println(lista);
    }

    //Modifica un nodo en el indice y con el valor que se indique
    public void modificarNodo(int index, Object val){
        NodoD actual=new NodoD();
        actual=primero;
        boolean encontrado=false;
        int i=index;
        if (primero != null){
            while (actual!=null && encontrado!=true){
                if(i==0){
                    System.out.println("El nodo con el dato "+actual.dato+" fue encontrado");
                    actual.dato=val;
                    System.out.println("Nodo Modificado");
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
            System.out.println("La lista está vacía");
        }
    }

    //Elimina un nodo en el indice que se indique
    public void eliminarNodo(int index){
        NodoD actual=new NodoD();
        actual=primero;
        NodoD anterior=new NodoD();
        anterior=null;
        boolean encontrado=false;
        int i=index;
        if (primero != null){
            while (actual!=null && encontrado!=true){
                if (i==0){
                    if (actual == primero){
                        primero=primero.siguiente;
                        primero.anterior=null;
                    } else if (actual == ultimo) {
                        anterior.siguiente=null;
                        ultimo=anterior;
                    }else {
                        anterior.siguiente=actual.siguiente;
                        actual.siguiente.anterior=anterior;
                    }
                    System.out.println("Nodo eliminado");
                    encontrado=true;
                }
                i--;
                anterior=actual;
                actual=actual.siguiente;
            }
            if (!encontrado){
                System.out.println("El nodo no fue encontrado");
            }
        }
        else{
            System.out.println("La lista está vacía");
        }
    }

    //Nos dice cuantos datos hay en la lista, regresando un entero
    public int longitudLista(){
        NodoD actual=new NodoD();
        actual=primero;
        int longitud=0;
        while(actual!=null){
            actual=actual.siguiente;
            longitud++;
        }
        return longitud;
    }

    //Invierte el orden de los nodos
    public void invertirLista(){
        NodoD actual=primero;
        NodoD nuevo=actual;
        NodoD temp=ultimo;
        NodoD anterior=new NodoD();
        int i=longitudLista();
        if (primero!=null) {
            if (i>= 2) {
                primero = primero.siguiente;
                ultimo.siguiente = nuevo;
                nuevo.siguiente = null;
                ultimo = nuevo;
                if (i>=3) {
                    actual = primero;
                    nuevo = actual;
                    primero = primero.siguiente;
                    temp.siguiente = nuevo;
                    nuevo.siguiente = ultimo;
                    anterior = temp.siguiente;
                    if (i>=4){
                        for (int j = 0; j < i-3; j++) {
                            actual = primero;
                            nuevo = actual;
                            primero = primero.siguiente;
                            temp.siguiente = nuevo;
                            nuevo.siguiente = anterior;
                            anterior = temp.siguiente;
                        }
                    }
                }
            }
            desplegarLista();
        }
        else{
            System.out.println("La lista esta vacía");
        }
    }

}
