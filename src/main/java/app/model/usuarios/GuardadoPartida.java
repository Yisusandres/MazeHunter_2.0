package app.model.usuarios;

public class GuardadoPartida {
    private int cristalesGuardados;
    private int energiaGuardada;
    private int bombasGuardadas;
    private double tiempoGuardado;
    private int vidaGuardada;

    public GuardadoPartida(int cristalesGuardados, int energiaGuardada, int bombasGuardadas, double tiempoGuardado, int vidaGuardada) {
        this.cristalesGuardados = cristalesGuardados;
        this.energiaGuardada = energiaGuardada;
        this.bombasGuardadas = bombasGuardadas;
        this.tiempoGuardado = tiempoGuardado;
        this.vidaGuardada = vidaGuardada;
    }

    public GuardadoPartida() {
    }

    public int getCristalesGuardados() {
        return cristalesGuardados;
    }

    public void setCristalesGuardados(int cristalesGuardados) {
        this.cristalesGuardados = cristalesGuardados;
    }

    public int getEnergiaGuardada() {
        return energiaGuardada;
    }

    public void setEnergiaGuardada(int energiaGuardada) {
        this.energiaGuardada = energiaGuardada;
    }

    public int getBombasGuardadas() {
        return bombasGuardadas;
    }

    public void setBombasGuardadas(int bombasGuardadas) {
        this.bombasGuardadas = bombasGuardadas;
    }

    public double getTiempoGuardado() {
        return tiempoGuardado;
    }

    public void setTiempoGuardado(double tiempoGuardado) {
        this.tiempoGuardado = tiempoGuardado;
    }

    public int getVidaGuardada() {
        return vidaGuardada;
    }

    public void setVidaGuardada(int vidaGuardada) {
        this.vidaGuardada = vidaGuardada;
    }
}
