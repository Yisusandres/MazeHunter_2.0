package app.model.usuarios;

public class EstadisticasUsuario {
    private int partidasGanadas;
    private int partidasPerdidas;
    private int trampasActivadas;
    private int cristalesObtenidos;
    private int laberintosJugados;

    public EstadisticasUsuario() {
    }

    public EstadisticasUsuario(int partidasGanadas, int trampasActivadas, int partidasPerdidas, int cristalesObtenidos, int laberintosJugados) {
        this.partidasGanadas = partidasGanadas;
        this.trampasActivadas = trampasActivadas;
        this.partidasPerdidas = partidasPerdidas;
        this.cristalesObtenidos = cristalesObtenidos;
        this.laberintosJugados = laberintosJugados;
    }

    public int getLaberintosJugados() {
        return laberintosJugados;
    }

    public void setLaberintosJugados(int laberintosJugados) {
        this.laberintosJugados = laberintosJugados;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
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

    public int getCristalesObtenidos() {
        return cristalesObtenidos;
    }

    public void setCristalesObtenidos(int cristalesObtenidos) {
        this.cristalesObtenidos = cristalesObtenidos;
    }
}
