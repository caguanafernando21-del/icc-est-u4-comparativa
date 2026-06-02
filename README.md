
# Práctica: Comparativa

## Datos del Estudiante
- **Nombre:** Fernando Caguana
- **Curso:** Estructura de datos G2
- **Fecha:** 01/06/2026

---


## Tabla 1. Escenario 1: arreglo completamente desordenado

| Tamaño de muestra | Tiempo Inserción | Tiempo QuickSort | Algoritmo más rápido | Observación |
|---|---|---|---|---|
| 10.000 | 59.00ms | 13.35ms | quickSort | Mejor rendimiento de QuickSort ante desorden inicial | 
| 50.000 | 1934.02ms | 85.63ms |  quickSort|Buena escabilidad  de QuickSort ante desorden inicial |
| 100.000 | 9046.66ms |  155.68ms| quickSort | gran diferencia de tiempo entre insercion y quick; evidencia la ventaja del comportamiento O(n \log n) | 

## Tabla 2. Escenario 2: arreglo ordenado más una nueva persona

| Tamaño de muestra | Tiempo Inserción | Tiempo QuickSort | Algoritmo más rápido | Observación |
|---|---|---|---|---|
| 10.000 |13.75ms  | 62.50ms | Insertion Sort |Insercion aprovecha que el arreglo está casi ordenado, requiriendo un mínimo de comparaciones e intercambios  |
| 50.000 | 520.33 | 723.45ms | Insertion sort | A pesar de incrementar el volumen insercion mantiene la ventaja al no requerir particiones recursivas.  |
| 100.000 | 1201.44ms | 2235.01ms | insertion sort | Demuestra que para datos casi ordenados, el metodo de Inserción supera el rendimiento de QuickSort al evitar el overhead recursivo |

## Análisis requerido

Después de completar las tablas, se debe responder:

- ¿Qué algoritmo fue más rápido en el escenario desordenado?
QuickSort este demostro una gran ventaja en todas las pruebas, resolviendo 100.000 datos en 155.68ms frente a los 9046.66ms de Inserción
- ¿Qué algoritmo fue más rápido en el escenario casi ordenado?
Insertion, en la muestra de 100.000 datos fue casi el doble de rapido que quickshort 1201.44ms frente a 2235.01ms
- ¿El crecimiento del tamaño de muestra afectó por igual a los dos algoritmos?
Falso, en el caso desordenado, el crecimiento afecto a Inserción por su forma de actuar. Pero en el otro caso fue afectado mas el QuickSort debido al overhead de sus particiones y llamadas recursivas innecesarias.
- ¿Por qué Inserción puede mejorar cuando el arreglo ya está casi ordenado?
Porque encuentra la posición del nuevo elemento casi de inmediato. Esto reduce los desplazamientos de memoria e intercambios, acercandose a su mejor caso, la complejidad lineal O(n).
- ¿Por qué QuickSort suele ser mejor cuando los datos están muy desordenados?
Porque divide el problema en subarreglos mediante un pivote. Gracias a esto optimiza las comparaciones y mantiene su eficiencia en una complejidad promedio de O(n \log n), evitando el recorrido de los metdos cuadraticos

*Nota:* Los resultados, observaciones y análisis deben ser escritos por cada uno con base en su ejecución. No se permite presentar análisis generados por IA.

## Conclusiones

Se debe redactar al menos tres conclusiones propias. Las conclusiones deben estar relacionadas directamente con los tiempos obtenidos.

- Conclusión 1: En los arreglos desordenados, QuickSort es mucho mejor que el Insercion debido a su eficiencia logaritmica frente al crecimiento cuadratico de este ultimo
- Conclusión 2: En los arreglos casi ordenados, Insercion supera a QuickSort en todas las pruebas al evitar usar el overhead de la recursividad y las particiones
- Conclusión 3: Los resultados demuestran que el algoritmo optimo depende por completo de como se encuntran los datos en ese mommento.

*Importante:* Las conclusiones no pueden ser generadas con IA. Deben reflejar su análisis a partir de los resultados reales de la práctica.