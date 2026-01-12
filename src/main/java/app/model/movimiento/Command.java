package app.model.movimiento;

/**
 * Interfaz que define la relacion para la ejecución de comandos de movimiento
 * dentro del laberinto. Sigue el patrón de diseño Command.
 * * @author Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
 */
public interface Command {
    /**
     * Ejecuta la acción de movimiento hacia una posición específica.
     * * @author Darwin Marcano
     * @param fila Coordenada de la fila destino.
     * @param columna Coordenada de la columna destino.
     */
    public void ejecutar(int fila, int columna);
}
