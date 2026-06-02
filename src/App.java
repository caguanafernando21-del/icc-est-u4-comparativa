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
        int cantidadMuestras = 10;
        SortPersonaMethods sorting = new SortPersonaMethods();
        long inicio, fin;
        double duracion;

        Persona[] arregloOriginal = generarPersonas(cantidadMuestras);
        
        System.out.println("--- Arreglo Original (Desordenado) ---");
        imprimirArreglo(arregloOriginal);

        
        Persona[] copiaInsertion = arregloOriginal.clone(); // clonar
        
        inicio = System.nanoTime();          
        sorting.insertionSort(copiaInsertion); 
        fin = System.nanoTime();             
        
        duracion = fin - inicio;
        Resultado resultadoInsertion = new Resultado("InsertionSort","Ordenado", cantidadMuestras, duracion);
        
        System.out.println("--- Arreglo Ordenado (InsertionSort) ---");
        imprimirArreglo(copiaInsertion);
        imprimirResultado(resultadoInsertion);


   
        Persona[] copiaQuick = arregloOriginal.clone();
        
        inicio = System.nanoTime();          
        sorting.quickSort(copiaQuick, 0, copiaQuick.length - 1); 
        fin = System.nanoTime();             
        
        duracion = fin - inicio;
        Resultado resultadoQuick = new Resultado("QuickSort", "Completamente Desordenado", cantidadMuestras, duracion);
        
        System.out.println("--- Arreglo Ordenado (QuickSort) ---");
        imprimirArreglo(copiaQuick);
        imprimirResultado(resultadoQuick);
    }
}

