package app.model;

import app.model.usuarios.GuardadoPartida;
import app.model.usuarios.Usuario;
import laberinto.Posicion.Pair;
import laberinto.celdas.Bomba;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Usuario {
    private boolean llave = false;
    private double vida;
    private int cristales;
    private int energia;
    private static String direccionImagen;
    private List<Bomba> bombas;
    private Pair<Integer, Integer> posicion;
    private GuardadoPartida guardadoPartidaJugador;

    public Jugador(String nombreUsuario, String correo, String contrasena, boolean llave, double vida, GuardadoPartida guardadoPartidaJugador) {
        super(nombreUsuario, correo, contrasena);
        this.llave = llave;
        this.vida = vida;
        this.guardadoPartidaJugador = guardadoPartidaJugador;
        this.cristales = guardadoPartidaJugador.getCristalesGuardados();
        this.energia = guardadoPartidaJugador.getEnergiaGuardada();
        List<Bomba> bombasCargadas = new ArrayList<>();
        for (int i = 0; i < guardadoPartidaJugador.getBombasGuardadas(); i++) {
            bombasCargadas.add(new Bomba());
        }
        this.bombas = bombasCargadas;
    }

    public Jugador(String nombreUsuario, String correo, String contrasena) {
        super(nombreUsuario, correo, contrasena);
        this.llave = false;
        this.vida = 100;
        this.cristales = 0;
        this.energia = 100;
    }

    public boolean isLlave() {
        return llave;
    }

    public void setLlave(boolean llave) {
        this.llave = llave;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public GuardadoPartida getGuardadoPartidaJugador() {
        return guardadoPartidaJugador;
    }

    public void setGuardadoPartidaJugador(GuardadoPartida guardadoPartidaJugador) {
        this.guardadoPartidaJugador = guardadoPartidaJugador;
    }

    public int getCristales() {
        return cristales;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public List<Bomba> getBombas() {
        return bombas;
    }

    public void perderVida(int i) {
        this.vida -= i;
    }
}
