package app.model;

public class GuardadoPartida {
    private float minutosJugados;
    private int partidasGanadas;
    private int partidasPerdidas;
    private int trampasActivadas;
    private int cristalesGuardados;
    private int energiaGuardada;
    private int bombasGuardadas;

    public GuardadoPartida(float minutosJugados, int partidasGanadas, int partidasPerdidas, int trampasActivadas,
                           int cristalesObtenidos, int energiaGuardada) {
        this.minutosJugados = minutosJugados;
        this.partidasGanadas = partidasGanadas;
        this.partidasPerdidas = partidasPerdidas;
        this.trampasActivadas = trampasActivadas;
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

    public int getTrampasActivadas() {
        return trampasActivadas;
    }

    public void setTrampasActivadas(int trampasActivadas) {
        this.trampasActivadas = trampasActivadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
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
