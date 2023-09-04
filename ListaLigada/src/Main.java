import Listas.Lista;
import Listas.ListaC;
import Listas.ListaD;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Object val;
        int index=0;
        int opcionMenu=0;
        Scanner teclado=new Scanner(System.in);

        Lista listaS=new Lista();
        ListaD listaD=new ListaD();
        ListaC listaC=new ListaC();
        int tipo=0;

        System.out.println("\n|---------------------------------|");
        System.out.println("|         \"TIPO DE LISTA\"         |");
        System.out.println("|---------------------------------|");
        System.out.println("| 1.Lista Simples | 2.Lista Doble |");
        System.out.println("|         3.Lista Circular        |");
        boolean salir=false;
        while(salir==false) {
            System.out.println("Escoja una opcion: 1");
            opcionMenu=teclado.nextInt();
            switch (opcionMenu) {
                case 1:
                    tipo = 1;
                    salir = true;
                    break;
                case 2:
                    tipo = 2;
                    salir = true;
                    break;
                case 3:
                    tipo = 3;
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    salir = false;
                    break;
            }
        }


        do {
            System.out.println("\n|------------------------------------------------|");
            System.out.println("|              \"ACCIONES DE LISTA\"               |");
            System.out.println("|------------------------------------------------|");
            System.out.println("| 1.Agregar            | 6. Modificar            |");
            System.out.println("| 2.Agregar por Indice | 7. Eliminar             |");
            System.out.println("| 3.Buscar por dato    | 8. Invertir Lista       |");
            System.out.println("| 4.Buscar por Indice  | 9. Longitud de la Lista |");
            System.out.println("| 5.Mostrar Lista      | 10. Salir               |");
            System.out.println("|------------------------------------------------|");
            System.out.println("Escoja una opcion");
            opcionMenu=teclado.nextInt();
            switch (opcionMenu){
                case 1:
                    System.out.println("Ingrese el valor del nodo");
                    val=teclado.next();
                    if (tipo==1){
                        listaS.insertarNodo(val);
                    } else if (tipo==2) {
                        listaD.insertarNodo(val);
                    }else {
                        listaC.insertarNodo(val);
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el indice");
                    index=teclado.nextInt();
                    System.out.println("Ingrese el valor del nodo");
                    val=teclado.next();
                    if (tipo==1){
                        listaS.insertarPorIndice(index,val);
                    } else if (tipo==2) {
                        listaD.insertarPorIndice(index,val);
                    }else {
                        listaC.insertarPorIndice(index,val);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el valor del nodo");
                    val=teclado.next();
                    if (tipo==1){
                        listaS.buscarNodo(val);
                    } else if (tipo==2) {
                        listaD.buscarNodo(val);
                    }else {
                        listaC.buscarNodo(val);
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el indice");
                    index=teclado.nextInt();
                    if (tipo==1){
                        listaS.buscarPorIndice(index);
                    } else if (tipo==2) {
                        listaD.buscarPorIndice(index);
                    }else {
                        listaC.buscarPorIndice(index);
                    }
                    break;
                case 5:
                    System.out.println("Mostrando la lista de nodos: ");
                    if (tipo==1){
                        listaS.desplegarLista();
                    } else if (tipo==2) {
                        listaD.desplegarLista();
                    }else {
                        listaC.desplegarLista();
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el indice");
                    index=teclado.nextInt();
                    System.out.println("Ingrese el nuevo valor del nodo");
                    val=teclado.next();
                    if (tipo==1){
                        listaS.modificarNodo(index,val);
                    } else if (tipo==2) {
                        listaD.modificarNodo(index,val);
                    }else {
                        listaC.modificarNodo(index,val);
                    }
                    break;
                case 7:
                    System.out.println("Ingrese el indice");
                    index=teclado.nextInt();
                    if (tipo==1){
                        listaS.eliminarNodo(index);
                    } else if (tipo==2) {
                        listaD.eliminarNodo(index);
                    }else {
                        listaC.eliminarNodo(index);
                    }
                    break;
                case 8:
                    System.out.println("Invertida la lista de nodos:");
                    if (tipo==1){
                        listaS.invertirLista();
                    } else if (tipo==2) {
                        listaD.invertirLista();
                    }else {
                        listaC.invertirLista();
                    }
                    break;
                case 9:
                    int longitud;
                    if (tipo==1){
                        longitud =listaS.longitudLista();
                    } else if (tipo==2) {
                        longitud =listaD.longitudLista();
                    }else {
                        longitud =listaC.longitudLista();
                    }

                    System.out.println("Longitud de la lista es: "+ longitud);
                    break;
                case 10:
                    System.out.println("Programa finalizado....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }while (opcionMenu != 10);
    }
}