package app.model;

import app.model.usuarios.GuardadoPartida;
import app.model.usuarios.Usuario;
import laberinto.Posicion.Pair;
import laberinto.celdas.Bomba;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa al personaje controlado por el usuario dentro del juego.
 * Extiende de Usuario e incluye estadísticas de juego como vida, energía,
 * bombas y estado de llaves.
 * @author Jesus Sifontes y Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
 */
public class Jugador extends Usuario {
    private boolean llave;
    private boolean llaveDeExplosion;
    private double vida;
    private int cristales;
    private int energia;
    private static String direccionImagen;
    private int bombas;
    private int trampas;
    private Pair<Integer, Integer> posicion;


    /**
     * Constructor para reanudar una partida guardada.
     * @author Jesus Sifontes y Darwin Marcano
     * @param nombreUsuario Nombre del perfil.
     * @param correo Correo electrónico.
     * @param contrasena Contraseña del usuario.
     * @param guardadoPartida Objeto que contiene las estadísticas guardadas (vida, cristales, etc.).
     */
    public Jugador(String nombreUsuario, String correo, String contrasena, GuardadoPartida guardadoPartida) {
        super(nombreUsuario, correo, contrasena);
        this.vida = guardadoPartida.getVidaGuardada();
        this.cristales = guardadoPartida.getCristalesGuardados();
        this.energia = guardadoPartida.getEnergiaGuardada();
        this.bombas = guardadoPartida.getBombasGuardadas();
    }

    /**
     * Constructor para iniciar un nuevo jugador con estadísticas base (100% vida, 100% energía).
     * @author Jesus Sifontes y Darwin Marcano
     * @param nombreUsuario Nombre del perfil.
     * @param correo Correo electrónico.
     * @param contrasena Contraseña del usuario.
     */
    public Jugador(String nombreUsuario, String correo, String contrasena) {
        super(nombreUsuario, correo, contrasena);
        this.llave = false;
        this.llaveDeExplosion = false;
        this.vida = 100;
        this.cristales = 0;
        this.energia = 100;
        this.bombas = 0;
    }

    /**
     * Indica si el jugador posee la llave para abrir la salida.
     * @author Jesus Sifontes y Darwin Marcano
     * @return true si tiene la llave.
     */
    public boolean isLlave() {
        return llave;
    }

    /**
     * Asigna el estado de posesión de la llave de salida.
     * @author Jesus Sifontes y Darwin Marcano
     * @param llave true para otorgar la llave.
     */
    public void setLlave(boolean llave) {
        this.llave = llave;
    }

    /**
     * Obtiene el nivel de salud actual del jugador.
     * @author Jesus Sifontes y Darwin Marcano
     * @return Valor numérico de la vida.
     */
    public double getVida() {
        return vida;
    }

    /**
     * Actualiza el nivel de salud del jugador.
     * @author Jesus Sifontes y Darwin Marcano
     * @param vida Nuevo valor de salud.
     */
    public void setVida(double vida) {
        this.vida = vida;
    }

    /**
     * Obtiene la cantidad de cristales recolectados.
     * @author Jesus Sifontes y Darwin Marcano
     * @return Cantidad de cristales.
     */
    public int getCristales() {
        return cristales;
    }

    /**
     * Obtiene el nivel de energía actual.
     * @author Jesus Sifontes y Darwin Marcano
     * @return Valor de energía.
     */
    public int getEnergia() {
        return energia;
    }

    /**
     * Establece el nivel de energía del jugador.
     * @author Jesus Sifontes y Darwin Marcano
     * @param energia Nuevo valor de energía.
     */
    public void setEnergia(int energia) {
        this.energia = energia;
    }

    /**
     * Reduce la salud del jugador en una cantidad específica.
     * @author Jesus Sifontes y Darwin Marcano
     * @param i Cantidad de puntos de vida a restar.
     */
    public void perderVida(int i) {
        this.vida -= i;
    }


    /**
     * Establece la cantidad de cristales recolectados.
     * @author Jesus Sifontes y Darwin Marcano
     * @return Cantidad de cristales.
     */
    public void setCristales(int cristales) {
        this.cristales = cristales;
    }

    /**
     * Obtiene la cantidad de bombas disponibles del jugador.
     * @author Jesus Sifontes y Darwin Marcano
     * @return Número de bombas.
     */
    public int getBombas() {
        return bombas;
    }


    public void setBombas(int bombas) {
        this.bombas = bombas;
    }

    /**
     * Incrementa en uno el contador de bombas del jugador.
     * @author Jesus Sifontes y Darwin Marcano
     */
    public void aumentarBomba(){
        this.bombas += 1;
        System.out.println(this.bombas);
    }

    /**
     * Indica si el jugador posee la llave necesaria para realizar explosiones.
     * @author Jesus Sifontes y Darwin Marcano
     * @return true si posee la llave de explosión.
     */
    public boolean isLlaveDeExplosion() {
        return llaveDeExplosion;
    }

    /**
     * Establece el estado de la llave de explosiones
     * @author Jesus Sifontes y Darwin Marcano
     * @return true si posee la llave de explosión.
     */
    public void setLlaveDeExplosion(boolean llaveDeExplosion) {
        this.llaveDeExplosion = llaveDeExplosion;
    }
}
