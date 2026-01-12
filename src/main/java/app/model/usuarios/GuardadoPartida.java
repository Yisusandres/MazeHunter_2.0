package app.model.usuarios;

/**
 * Clase que actúa como un contenedor de datos para mantener el estado
 * actual de una partida.
 * @author Jesus Sifontes
 * @version 22.0.2
 * @since 11-01-2026
 */
public class GuardadoPartida {
    private int cristalesGuardados;
    private int energiaGuardada;
    private int bombasGuardadas;
    private double tiempoGuardado;
    private int vidaGuardada;
    private int[][] laberintoGuardado;

    /**
     * Constructor completo para inicializar un estado de guardado con todos los parámetros.
     * @author Jesus Sifontes
     * @param cristalesGuardados Cantidad de cristales en el inventario.
     * @param energiaGuardada Nivel de energía del jugador.
     * @param bombasGuardadas Número de bombas disponibles.
     * @param tiempoGuardado Tiempo transcurrido en la partida.
     * @param vidaGuardada Puntos de salud restantes.
     * @param laberintoGuardado Matriz de enteros que representa el diseño del laberinto.
     */
    public GuardadoPartida(int cristalesGuardados, int energiaGuardada, int bombasGuardadas, double tiempoGuardado, int vidaGuardada, int[][] laberintoGuardado) {
        this.cristalesGuardados = cristalesGuardados;
        this.energiaGuardada = energiaGuardada;
        this.bombasGuardadas = bombasGuardadas;
        this.tiempoGuardado = tiempoGuardado;
        this.vidaGuardada = vidaGuardada;
        this.laberintoGuardado = laberintoGuardado;
    }

    /**
     * Constructor por defecto que inicializa una partida vacía con valores en cero.
     * @author Jesus Sifontes
     */
    public GuardadoPartida() {
        this.laberintoGuardado = null;
        this.cristalesGuardados = 0;
        this.energiaGuardada = 100;
        this.bombasGuardadas = 0;
        this.tiempoGuardado = 0;
        this.vidaGuardada = 100;
    }

    /** @author Jesus Sifontes @return Cantidad de cristales guardados. */
    public int getCristalesGuardados() { return cristalesGuardados; }

    /** @author Jesus Sifontes @param cristalesGuardados Cantidad de cristales a guardar. */
    public void setCristalesGuardados(int cristalesGuardados) { this.cristalesGuardados = cristalesGuardados; }

    /** @author Jesus Sifontes @return Nivel de energía guardado. */
    public int getEnergiaGuardada() { return energiaGuardada; }

    /** @author Jesus Sifontes @param energiaGuardada Nivel de energía a guardar. */
    public void setEnergiaGuardada(int energiaGuardada) { this.energiaGuardada = energiaGuardada; }

    /** @author Jesus Sifontes @return Número de bombas guardadas. */
    public int getBombasGuardadas() { return bombasGuardadas; }

    /** @author Jesus Sifontes @param bombasGuardadas Cantidad de bombas a guardar. */
    public void setBombasGuardadas(int bombasGuardadas) { this.bombasGuardadas = bombasGuardadas; }

    /** @author Jesus Sifontes @return Tiempo transcurrido guardado. */
    public double getTiempoGuardado() { return tiempoGuardado; }

    /** @author Jesus Sifontes @param tiempoGuardado Tiempo a guardar. */
    public void setTiempoGuardado(double tiempoGuardado) { this.tiempoGuardado = tiempoGuardado; }

    /** @author Jesus Sifontes @return Salud guardada. */
    public int getVidaGuardada() { return vidaGuardada; }

    /** @author Jesus Sifontes @param vidaGuardada Salud a guardar. */
    public void setVidaGuardada(int vidaGuardada) { this.vidaGuardada = vidaGuardada; }

    /** @author Jesus Sifontes @return Matriz del laberinto guardado. */
    public int[][] getLaberintoGuardado() { return laberintoGuardado; }

    /** @author Jesus Sifontes @param laberintoGuardado Matriz del laberinto a guardar. */
    public void setLaberintoGuardado(int[][] laberintoGuardado) { this.laberintoGuardado = laberintoGuardado; }



    /*public int getCristalesGuardados() {
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

    public boolean isLlaveObtenida() {
        return llaveObtenida;
    }

    public void setLlaveObtenida(boolean llaveObtenida) {
        this.llaveObtenida = llaveObtenida;
    }

    public int[][] getLaberintoGuardado() {
        return laberintoGuardado;
    }

    public void setLaberintoGuardado(int[][] laberintoGuardado) {
        this.laberintoGuardado = laberintoGuardado;
    }*/
}
