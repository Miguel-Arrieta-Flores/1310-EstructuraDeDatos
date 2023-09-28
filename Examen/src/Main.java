import java.util.List;

public class Main{

    //Función para sacar el valor máximo después de las operaciones
    public static int valorMaximoDelArreglo(int n, List<int[]> queries) {
        int[] array = new int[n+1];   //Declaración de variable, n

        for (int[] query : queries) {  // Inicialización del arreglo, O(m)
            int a = query[0];         //Declaración de variable, 0(1)
            int b = query[1];         //Declaración de variable, 0(1)
            int k = query[2];         //Declaración de variable, 0(1)
            array[a] += k;       // Operación de incremento, O(1)
            if (b + 1 <= n) {           //O(1)
                array[b + 1] -= k;   // Operación de decremento,O(1)
            }
        }

        int valorMaximo = 0;       //Declaración de variable, 1
        int valorActual = 0;       //Declaración de variable, 1

        for (int x : array) {     // Iteración a través del arreglo, O(n)
            valorActual += x;     // Operación de suma, O(1)
            if (valorActual > valorMaximo) {   //O(1)
                valorMaximo = valorActual; // Actualización del valor máximo, O(1)
            }
        }

        return valorMaximo;     //Solo regresa el valor, O(1)
    }
    //El analisis es: (m(1+1+1+1+1(1))+n(1+1(1))+1)=(m(4)+n(2)+1)=(4m+2n+1)=(m+n)=n, O(n)

    public static void main(String[] args) {
        int n = 10;
        List<int[]> queries = List.of(new int[]{1, 5, 3}, new int[]{4, 8, 7}, new int[]{6, 9, 1});
        int result = valorMaximoDelArreglo(n, queries);
        System.out.println("El valor máximo después de las operaciones es: " + result);
    }
}