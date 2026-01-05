package app.model.movimiento;

public interface Command {
    public void ejecutar(int fila, int columna);
}
