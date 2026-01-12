package laberinto;
/**
 * Clase estática genérica diseñada para representar un par ordenado de datos,
 * utilizada principalmente para coordenadas (Fila, Columna).
 * @author Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
 * Representa el segundo componente del par, correspondiente a la posición en el eje de las columnas.
 * @author Darwin Marcano
*/
public class Posicion {
    public static class Pair<A, B> {
        public A first; // Fila
        public B second; // Columna
    }
}
