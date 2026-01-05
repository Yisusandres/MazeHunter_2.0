package app.model.movimiento;

import app.model.GestorLaberinto;

public class Izquierda implements Command {
    private GestorLaberinto gestor;

    public Izquierda(GestorLaberinto gestor) {
        this.gestor = gestor;
    }

    @Override
    public void ejecutar(int fila, int columna) {
        gestor.izquierda(fila, columna);
    }
}
