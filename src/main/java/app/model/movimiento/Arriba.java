package app.model.movimiento;

import app.model.GestorLaberinto;

public class Arriba implements Command {
    private GestorLaberinto gestor; // Antes era MovimientoJugador

    public Arriba(GestorLaberinto gestor) {
        this.gestor = gestor;
    }

    @Override
    public void ejecutar(int fila, int columna) {
        gestor.arriba(fila, columna);
    }
}
