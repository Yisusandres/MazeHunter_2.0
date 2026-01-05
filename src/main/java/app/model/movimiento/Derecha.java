package app.model.movimiento;

import app.model.GestorLaberinto;

public class Derecha implements Command {
    private GestorLaberinto gestor;

    public Derecha(GestorLaberinto gestor) {
        this.gestor = gestor;
    }

    @Override
    public void ejecutar(int fila, int columna) {
        gestor.derecha(fila, columna);
    }
}
