package Listas;

import Nodos.Nodo;

public class Lista {

    Nodo primero=new Nodo();
    Nodo ultimo=new Nodo();

    public Lista(){
        primero=null;
        ultimo=null;
    }

    public Lista(Nodo primero, Nodo ultimo) {
        this.primero = primero;
        this.ultimo = ultimo;
    }

    public Nodo getFirst() {
        return primero;
    }

    public void setFirst(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getLast() {
        return ultimo;
    }

    public void setLast(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    @Override
    public String toString() {
        return "Listas.Lista{" +
                "primero=" + primero +
                ", ultimo=" + ultimo +
                '}';
    }

    //Inserta un nodo con el valor que se indique
    public void insertarNodo(Object val){
        Nodo nuevo=new Nodo();
        nuevo.dato=val;
        if (primero==null){
            primero=nuevo;
            primero.siguiente=null;
            ultimo=nuevo;
        }
        else {
            ultimo.siguiente=nuevo;
            nuevo.siguiente=null;
            ultimo=nuevo;
        }
        System.out.println("\nNodo ingresado\n");
    }

    //Inserta un nodo en el indice y con el valor que se indique
    public void insertarPorIndice(int index, Object val){
        Nodo actual=new Nodo();
        actual=primero;
        boolean encontrado=false;
        int i=index-1;
        Nodo anterior=new Nodo();
        Nodo nuevo=new Nodo();
        nuevo.dato=val;
        if (primero != null){
            while (actual!=null && encontrado!=true){
                if (index==1){
                    anterior=primero.siguiente;
                    primero.siguiente = nuevo;
                    actual = actual.siguiente;
                    actual.siguiente = anterior;
                    encontrado=true;
                    System.out.println("Nodo ingresado");
                } else if (index==0) {
                    anterior=primero.siguiente;
                    primero=nuevo;
                    primero.siguiente=actual;
                    actual.siguiente=anterior;
                    encontrado=true;
                    System.out.println("Nodo ingresado");
                }else if (index==longitudLista()){
                    ultimo.siguiente=nuevo;
                    nuevo.siguiente=null;
                    ultimo=nuevo;
                    encontrado=true;
                    System.out.println("Nodo ingresado");
                }
                if(i==0){
                    anterior = actual.siguiente;
                    actual.siguiente = nuevo;
                    actual = actual.siguiente;
                    actual.siguiente = anterior;
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
        Nodo actual=new Nodo();
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

    //Buscar un nodo con el valor que se indique
    public void buscarNodo(Object val){
        Nodo actual=new Nodo();
        actual=primero;
        boolean encontrado=false;
        Object nodoBuscado=val;
        if (primero != null){
            int index=0;
            while (actual!=null && encontrado!=true){
                if (actual.dato.equals(nodoBuscado)){
                    System.out.println("Nodo con el dato ["+actual.dato+"] encontrado");
                    System.out.println("Esta ubicando en el indice: "+index);
                    encontrado=true;
                }
                index++;
                actual=actual.siguiente;
            }
            if (!encontrado){
                System.out.println("No fue encontrado");
            }
        }
        else{
            System.out.println("La lista está vacía");
        }
    }

    //Buscar un nodo en el indice que se indique
    public void buscarPorIndice(int index){
        Nodo actual=new Nodo();
        actual=primero;
        boolean encontrado=false;
        int i=index;
        if (primero != null){
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
            System.out.println("La lista está vacía");
        }
    }

    //Modifica un nodo en el indice y con el valor que se indique
    public void modificarNodo(int index, Object val){
        Nodo actual=new Nodo();
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
        Nodo actual=new Nodo();
        actual=primero;
        Nodo anterior=new Nodo();
        anterior=null;
        boolean encontrado=false;
        int i=index;
        if (primero != null){
            while (actual!=null && encontrado!=true){
                if (i==0){
                    if (actual == primero){
                        primero=primero.siguiente;
                    } else if (actual == ultimo) {
                        anterior.siguiente=null;
                        ultimo=anterior;
                    }else {
                        anterior.siguiente=actual.siguiente;
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
        Nodo actual=new Nodo();
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
        Nodo actual=primero;
        Nodo nuevo=actual;
        Nodo temp=ultimo;
        Nodo anterior=new Nodo();
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
