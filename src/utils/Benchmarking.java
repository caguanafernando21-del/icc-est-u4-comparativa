package utils;

import java.util.concurrent.Callable;
import models.Resultado;

public class Benchmarking {
    public static Resultado medirTiempo(
        Callable<Void> funcion,
        String algoritmo,
        String escensario,
        int sample
    ){
        try {
            long inicio = System.nanoTime();
            funcion.call();
            long fin = System.nanoTime();

            double duracion = fin - inicio;
            
            return new Resultado(algoritmo, escensario, sample, duracion);
        } catch(Exception e){
            throw new RuntimeException("Error al ejecutar la funcion de ordenamiento");
        }
    }
}
