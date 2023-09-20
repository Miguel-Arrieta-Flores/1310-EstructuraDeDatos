import Colas.Cola;
import Pilas.Pila;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Object val;
            int index=0;
            int opcionMenu=0;
            Scanner teclado=new Scanner(System.in);

            Pila pila=new Pila();
            Cola cola=new Cola();
            int tipo=0;

            System.out.println("\n|---------------------|");
            System.out.println("|        \"TIPO\"       |");
            System.out.println("|---------------------|");
            System.out.println("|  1.Pila  |  2.Cola  |");
            boolean salir=false;
            while(salir==false) {
                System.out.println("Escoja una opcion: ");
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
                    default:
                        System.out.println("Opcion no valida");
                        salir = false;
                        break;
                }
            }


            do {
                System.out.println("\n|---------------------------------------------------|");
                System.out.println("|                    \"ACCIONES\"                     |");
                System.out.println("|---------------------------------------------------|");
                System.out.println("| 1.Agregar  (Push,Enqueue)  |  4. Mostrar todo     |");
                System.out.println("| 2.Eliminar (Pop, Dequeue)  |  5. Buscar elemento  |");
                System.out.println("| 3.Acceso (Peek)            |  6. Longitud         |");
                System.out.println("|                    7. Salir                       |");
                System.out.println("|---------------------------------------------------|");
                System.out.println("Escoja una opcion: ");
                opcionMenu=teclado.nextInt();
                switch (opcionMenu){
                    case 1:
                        System.out.println("Ingrese el valor del nodo: ");
                        val=teclado.next();
                        if (tipo==1){
                            pila.push(val);
                        }else {
                            cola.enqueue(val);
                        }
                        break;
                    case 2:
                        if (tipo==1){
                            pila.pop();
                        }else {
                            cola.dequeue();
                        }
                        break;
                    case 3:
                        System.out.println("Su cabecera es:");
                        if (tipo==1){
                            System.out.println(pila.peek());
                        }else {
                            System.out.println(cola.peek());
                        }
                        break;
                    case 4:
                        if (tipo==1){
                            System.out.println("Pila:");
                            pila.desplegarPila();
                        }else {
                            System.out.println("Cola:");
                            cola.desplegarCola();
                        }
                        break;
                    case 5:
                        System.out.println("Ingrese el indice: ");
                        index=teclado.nextInt();
                        if (tipo==1){
                            pila.buscar(index);
                        }else {
                            cola.buscar(index);
                        }
                        break;
                    case 6:
                        if (tipo==1){
                            System.out.println("La longitud de la pila es: "+pila.longitudPila());
                        }else {
                            System.out.println("La longitud de la cola es: "+cola.longitudCola());
                        }
                        break;
                    case 7:
                        System.out.println("Programa finalizado....");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no valida");
                        break;
                }
            }while (opcionMenu != 7);

    }
}