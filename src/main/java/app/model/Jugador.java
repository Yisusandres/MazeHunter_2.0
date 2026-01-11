package app.model;

import app.model.usuarios.GuardadoPartida;
import app.model.usuarios.Usuario;
import laberinto.Posicion.Pair;
import laberinto.celdas.Bomba;

import java.util.ArrayList;
import java.util.List;

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

    // Jugador guardado
    public Jugador(String nombreUsuario, String correo, String contrasena, GuardadoPartida guardadoPartida) {
        super(nombreUsuario, correo, contrasena);
        this.llave = guardadoPartida.isLlaveObtenida();
        this.vida = guardadoPartida.getVidaGuardada();
        this.cristales = guardadoPartida.getCristalesGuardados();
        this.energia = guardadoPartida.getEnergiaGuardada();
        this.bombas = guardadoPartida.getBombasGuardadas();
    }

    public Jugador(String nombreUsuario, String correo, String contrasena) {
        super(nombreUsuario, correo, contrasena);
        this.llave = false;
        this.llaveDeExplosion = false;
        this.vida = 100;
        this.cristales = 0;
        this.energia = 100;
        this.bombas = 0;
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

    public int getCristales() {
        return cristales;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void perderVida(int i) {
        this.vida -= i;
    }

    public void setCristales(int cristales) {
        this.cristales = cristales;
    }

    public int getBombas() {
        return bombas;
    }

    public void setBombas(int bombas) {
        this.bombas = bombas;
    }

    public void aumentarBomba(){
        this.bombas += 1;
    }

    public boolean isLlaveDeExplosion() {
        return llaveDeExplosion;
    }
    public void setLlaveDeExplosion(boolean llaveDeExplosion) {
        this.llaveDeExplosion = llaveDeExplosion;
    }
}
