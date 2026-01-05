package app.model.movimiento;

import app.model.GestorLaberinto;

public class Abajo implements Command {
    private GestorLaberinto gestor;

    public Abajo(GestorLaberinto gestor) {
        this.gestor = gestor;
    }

    @Override
    public void ejecutar(int fila, int columna) {
        gestor.abajo(fila, columna);
    }
}
