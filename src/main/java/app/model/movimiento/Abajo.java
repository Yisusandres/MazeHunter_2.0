package app.model.movimiento;

import app.model.GestorLaberinto;

/**
 * Comando concreto que implementa el movimiento del jugador hacia abajo.
 * * @author Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
 */

public class Abajo implements Command {
    private GestorLaberinto gestor;

    /**
     * Constructor que asigna el gestor encargado de la lógica del laberinto.
     * * @author Darwin Marcano
     * @param gestor Instancia de GestorLaberinto.
     */
    public Abajo(GestorLaberinto gestor) {
        this.gestor = gestor;
    }


    /**
     * Llama al método abajo del gestor para mover al jugador.
     * * @author Darwin Marcano
     * @param fila Nueva fila.
     * @param columna Columna actual.
     */
    @Override
    public void ejecutar(int fila, int columna) {
        gestor.abajo(fila, columna);
    }
}
