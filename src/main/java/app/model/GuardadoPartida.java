package app.model;

public class GuardadoPartida {
    private float minutosJugados;
    private int partidasGanadas;
    private int partidasPerdidas;
    private int trampasActivadas;
    private int cristalesObtenidos;

    public GuardadoPartida(float minutosJugados, int partidasGanadas, int partidasPerdidas, int trampasActivadas, int cristalesObtenidos) {
        this.minutosJugados = minutosJugados;
        this.partidasGanadas = partidasGanadas;
        this.partidasPerdidas = partidasPerdidas;
        this.trampasActivadas = trampasActivadas;
        this.cristalesObtenidos = cristalesObtenidos;
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

    public int getCristalesObtenidos() {
        return cristalesObtenidos;
    }

    public void setCristalesObtenidos(int cristalesObtenidos) {
        this.cristalesObtenidos = cristalesObtenidos;
    }
}
