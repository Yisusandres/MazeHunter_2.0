package app.model;

public class GuardadoPartida {
    private int cristalesGuardados;
    private int energiaGuardada;
    private int bombasGuardadas;
    private double tiempoGuardado;
    private int vidaGuardada;

    public GuardadoPartida(int cristalesObtenidos, int energiaGuardada) {
        this.cristalesGuardados = cristalesObtenidos;
        this.energiaGuardada = energiaGuardada;
    }

     public GuardadoPartida() {
     }

    public float getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(float minutosJugados) {
        this.minutosJugados = minutosJugados;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    public int getTrampasActivadas() {
        return trampasActivadas;
    }

    public void setTrampasActivadas(int trampasActivadas) {
        this.trampasActivadas = trampasActivadas;
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
}
