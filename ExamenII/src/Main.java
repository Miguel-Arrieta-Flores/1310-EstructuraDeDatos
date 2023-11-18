import java.util.Arrays;

public class Main{
    // Función del algoritmo de Bubble Sort
    private static void bubbleSort(int[] lista) {
        int n = lista.length;
        //Se recorre la lista
        for (int i = 0; i < n - 1; i++) {
            //Se comparan los elementos adyacentes
            for (int j = 0; j < n - i - 1; j++) {
                // Realizamos un swap entre lista[j] y lista[j+1], si no están en el orden correcto
                if (lista[j] > lista[j + 1]) {
                    int temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
    }

    // Función del algoritmo de Quick Sort
    private static void quickSort(int[] lista, int low, int high) {
        //Si el indice inicial no es el mismo que el indice final
        if (low < high) {
            //Se divide en segmentos la lista, luego utilizamos recursividad
            int segmento = segmentar(lista, low, high);
            quickSort(lista, low, segmento - 1); // Se ordena la parte superior del pivote
            quickSort(lista, segmento + 1, high); // Se ordena la parte inferior del pivote

            //Se realiza hasta que no haya intercambios o el segmento es igual a 1 elemento
        }
    }

    // Función para segmentar la lista, a partir de escoger un pivote
    private static int segmentar(int[] lista, int low, int high) {
        int pivote = lista[high];  //Se asigna un pivote (punto de partida)
        int i = (low - 1);
        //Se recorre la lista
        for (int j = low; j < high; j++) {
            if (lista[j] < pivote) {
                i++;
                // Realizamos un swap entre lista[i] y lista[j]
                int temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
            }
        }
        // Realizamos un swap entre lista[i+1] y lista[high] (o el pivote)
        int temp = lista[i + 1];
        lista[i + 1] = lista[high];
        lista[high] = temp;
        // Regresa el indice (pivote) de donde vamos a partir la lista
        return i + 1;
    }

    public static void main(String[] args) {
        int[] lista = {95, 36, 42, 0, 32, 58, 73, 28, 43, 12, 50};
        int[] lista2 ={95, 36, 42, 0, 32, 58, 73, 28, 43, 12, 50};

        // Ordenamiento con Bubble Sort
        System.out.println("Lista original: " + Arrays.toString(lista));
        bubbleSort(lista);
        System.out.println("Ordenado con Bubble Sort: " + Arrays.toString(lista));

        // Ordenamiento con Quick Sort
        System.out.println("\nLista original: " + Arrays.toString(lista2));
        quickSort(lista2, 0, lista2.length - 1);
        System.out.println("Ordenado con Quick Sort: " + Arrays.toString(lista2));
    }
}

