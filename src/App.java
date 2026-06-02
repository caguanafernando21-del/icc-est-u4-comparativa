import controllers.SortPersonaMethods;
import models.Persona;
import models.Resultado;

public class App {
        public static Persona[] generarPersonas(int cantidad){
            Persona[] personas = new Persona[cantidad];
            
            for(int i = 0; i < cantidad; i++){
                String nombre = "Persona" + " "+ (i+1);
                int edad = (int) (Math.random() *101);
                personas[i] = new Persona(nombre, edad);
            }
            return personas;
        }
            
        public static void imprimirArreglo(Persona[] personas) {
        for (Persona p : personas) {
        
            System.out.println(p.getNombre() + " - Edad: " + p.getEdad());
            }
        }
    public static void imprimirResultado(Resultado resultado) {
        System.out.println(" MÉTRICAS DE RENDIMIENTO ");
        System.out.println("Algoritmo: " + resultado.getAlgoritmo());
        System.out.println("Escenario: " + resultado.getEscenario());
        System.out.println("Muestra (Tamaño): " + resultado.getSample());
        System.out.println("Tiempo en Nanosegundos: " + resultado.getTiempoNano() + " ns");
        System.out.println("Tiempo en Milisegundos: " + resultado.getTiempoMillis() + " ms");
        System.out.println("----------------------------------------");
    }    

public static void main(String[] args) {
        SortPersonaMethods sorting = new SortPersonaMethods();
        int[] tamaños = {10000, 50000, 100000};
        
        long inicio, fin;
        double tInsertion, tQuick;

        // =========================================================================
        // TABLA 1: ESCENARIO 1 (COMPLETAMENTE DESORDENADO)
        // =========================================================================
        System.out.println("Escenario 1: arreglo completamente desordenado\n");
        System.out.println("| Tamaño de muestra | Tiempo Inserción | Tiempo QuickSort | Algoritmo más rápido | Observación |");
        System.out.println("|---|---|---|---|---|");

        for (int n : tamaños) {
            Persona[] original = generarPersonas(n);

            
            Persona[] copiaInsertion = original.clone();
            inicio = System.nanoTime();
            sorting.insertionSort(copiaInsertion);
            fin = System.nanoTime();
            tInsertion = (fin - inicio) / 1_000_000.0; 
            
            
            Persona[] copiaQuick = original.clone();
            inicio = System.nanoTime();
            sorting.quickSort(copiaQuick, 0, copiaQuick.length - 1);
            fin = System.nanoTime();
            tQuick = (fin - inicio) / 1_000_000.0; // 

            String masRapido = (tInsertion < tQuick) ? "InsertionSort" : "QuickSort";
            
            System.out.printf("| %,d | %.2f ms | %.2f ms | %s | |\n", n, tInsertion, tQuick, masRapido);
        }

        System.out.println("\n");

        System.out.println(" Escenario 2: arreglo ordenado más una nueva persona\n");
        System.out.println("| Tamaño de muestra | Tiempo Inserción | Tiempo QuickSort | Algoritmo más rápido | Observación |");
        System.out.println("|---|---|---|---|---|");

        for (int n : tamaños) {
            Persona[] baseOrdenada = generarPersonas(n);
            sorting.quickSort(baseOrdenada, 0, baseOrdenada.length - 1);


            Persona[] escenario2 = new Persona[n + 1];
            System.arraycopy(baseOrdenada, 0, escenario2, 0, n);

            escenario2[n] = new Persona("Nueva Persona", (int) (Math.random() * 101));

            int tamañoTotal = escenario2.length;


            Persona[] copiaInsertion = new Persona[tamañoTotal];
            System.arraycopy(escenario2, 0, copiaInsertion, 0, tamañoTotal);
            
            inicio = System.nanoTime();
            sorting.insertionSort(copiaInsertion);
            fin = System.nanoTime();
            tInsertion = (fin - inicio) / 1_000_000.0;

            
            Persona[] copiaQuick = new Persona[tamañoTotal];
            System.arraycopy(escenario2, 0, copiaQuick, 0, tamañoTotal);
            
            inicio = System.nanoTime();
            sorting.quickSort(copiaQuick, 0, copiaQuick.length - 1);
            fin = System.nanoTime();
            tQuick = (fin - inicio) / 1_000_000.0;

            String masRapido = (tInsertion < tQuick) ? "InsertionSort" : "QuickSort";

            System.out.printf("| %,d | %.2f ms | %.2f ms | %s | |\n", tamañoTotal, tInsertion, tQuick, masRapido);
        }
    }
}

