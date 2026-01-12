package app.model.movimiento;

import app.model.GestorLaberinto;

/**
 * Comando concreto que implementa el movimiento del jugador hacia arriba.
 * * @author Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
 */
public class Arriba implements Command {
    private GestorLaberinto gestor; // Antes era MovimientoJugador

    /**
     * Constructor que asigna el gestor encargado de la lógica del laberinto.
     * * @author Darwin Marcano
     * @param gestor Instancia de GestorLaberinto.
     */
    public Arriba(GestorLaberinto gestor) {
        this.gestor = gestor;
    }

    /**
     * Llama al método arriba del gestor para mover al jugador.
     * * @author Darwin Marcano
     * @param fila Nueva fila.
     * @param columna Columna actual.
     */
    @Override
    public void ejecutar(int fila, int columna) {
        gestor.arriba(fila, columna);
    }
}
