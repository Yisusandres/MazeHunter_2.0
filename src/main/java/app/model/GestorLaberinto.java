package app.model;

import app.controller.LaberintoController;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import laberinto.Laberinto;
import laberinto.Posicion.Pair;
import laberinto.celdas.*;

import java.util.*;

public class GestorLaberinto {
    private Laberinto laberinto;
    private static Jugador jugador;
    private Pair<Integer, Integer> posicionSalida;
    private Pair<Integer, Integer> posicionJugador;
    private List<Integer> celdasEnNumero = new ArrayList<>();

    public GestorLaberinto(Laberinto laberinto, Jugador jugador)
    {
        this.laberinto = laberinto;
        GestorLaberinto.jugador = jugador;
        this.posicionSalida = laberinto.getSalidaPos();
        this.posicionJugador = laberinto.getJugadorPos();
    }


    public Pair<Integer, Integer> getPosicionJugador() {return posicionJugador;}

    public boolean posicionValida(int fila, int columna) {
        Celda[][] mapa = laberinto.getLaberinto();
        if(fila < 0 || fila >= laberinto.getFilas() || columna < 0 || columna >= laberinto.getColumnas()) {
            return false;
        }
        return mapa[fila][columna].isTraspasable();
    }

    public void derecha(int fila, int columna) {
        mover(fila, columna);
    }
    public void izquierda(int fila, int columna) {
        mover(fila, columna);
    }
    public void arriba(int fila, int columna) {
        mover(fila, columna);
    }
    public void abajo(int fila, int columna) {
        mover(fila, columna);
    }

    public static int aleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public void chequearSiEsTrampa(int fila, int columna) {
        Celda[][] mapa = laberinto.getLaberinto();
        if(mapa[fila][columna].getTipo().equals("Trampa")) {
            jugador.perderVida(20);
            System.out.println("Cuidado! Has caido en una trampa. Vida restante: " + jugador.getVida());
        }
    }

    public void chequearSiEsCristal(int fila, int columna) {
        Celda[][] mapa = laberinto.getLaberinto();
        Random random = new Random();
        int aleatorio =  aleatorio(1, 5);
        if(mapa[fila][columna].getTipo().equals("Cristal")) {
            jugador.getGuardadoPartidaJugador().setCristalesGuardados(jugador.getGuardadoPartidaJugador().getCristalesGuardados() + aleatorio);
            System.out.println("Has recogido un cristal! Cristales: " + jugador.getCristales());
        }
    }

    public void chequearSiEsVida(int fila, int columna) {
        Celda[][] mapa = laberinto.getLaberinto();
        int aleatorio =  aleatorio(1, 2);
        if(mapa[fila][columna].getTipo().equals("Vida")) {
            if(jugador.getVida() + aleatorio * 5 < 100) {
                jugador.setVida(jugador.getVida() + aleatorio * 5);
                System.out.println("Has recogido vida! Vida aumentada: " + jugador.getVida());
            }
            else {
                System.out.println("Ya tienes 100% de vida!");
            }
        }
    }

    public void chequearSiEsBomba(int fila, int columna) {
        Celda[][] mapa = laberinto.getLaberinto();
        if(mapa[fila][columna].getTipo().equals("Bomba")) {
            System.out.println("Has obtenido una bomba! Puedes usarla para destruir muros.");
            jugador.getBombas().add(new Bomba());
        }
    }

    public void chequearSiEsEnergia(int fila, int columna) {
        Celda[][] mapa = laberinto.getLaberinto();
        int aleatorio =  aleatorio(1, 2);
        if(mapa[fila][columna].getTipo().equals("Energia")) {
            jugador.setEnergia(jugador.getEnergia() + aleatorio * 10);
            System.out.println("Has recogido energia! Energia aumentada: " + jugador.getEnergia());
        }
    }

    public void chequearSiEsLlave(int fila, int columna) {
        Celda[][] mapa = laberinto.getLaberinto();
        if(mapa[fila][columna].getTipo().equals("Llave")) {
            jugador.setLlave(true);
            System.out.println("Has recogido la llave! Ahora puedes abrir la salida del laberinto.");
            mapa[posicionSalida.first][posicionSalida.second].setTraspasable(true);
        }
    }

    public boolean chequearSiEsSalida(int fila, int columna) {
        return fila == posicionSalida.first && columna == posicionSalida.second;
    }

    public void mover(int fila, int columna) {

        if(!posicionValida(fila, columna)) {
            System.out.println("Ups no puedes pasar por aqui.");
            return;
        }

        Celda[][] mapa = laberinto.getLaberinto();
        chequearSiEsTrampa(fila, columna);
        chequearSiEsCristal(fila, columna);
        chequearSiEsVida(fila, columna);
        chequearSiEsBomba(fila, columna);
        chequearSiEsEnergia(fila, columna);
        chequearSiEsLlave(fila, columna);
        if(chequearSiEsSalida(fila, columna)) {
            if(jugador.isLlave()) {
                System.out.println("Felicidades! Has salido del laberinto.");
                return;
            } else {
                System.out.println("Necesitas la llave para salir del laberinto.");
                return;
            }
        }

        mapa[posicionJugador.first][posicionJugador.second] = new Celda();
        mapa[posicionJugador.first][posicionJugador.second] = new Camino();
        mapa[fila][columna] = new Celda();
        mapa[fila][columna] = new JugadorCelda();

        this.posicionJugador.first = fila;
        this.posicionJugador.second = columna;
        laberinto.setJugadorPos(posicionJugador);
        laberinto.setLaberinto(mapa);
    }

    public void guardarLaberinto() {
        Map<String, Integer> celdas = new HashMap<>();
        celdas.put("Muro", 1);
        celdas.put("MuroRojo", 2);
        celdas.put("Camino", 3);
        celdas.put("Trampa", 4);
        celdas.put("Cristal", 5);
        celdas.put("Bomba", 6);
        celdas.put("Energia", 7);
        celdas.put("Vida", 8);
        celdas.put("Jugador", 9);
        celdas.put("Llave", 10);
        celdas.put("Salida", 11);
        String celda;
        Celda[][] mapa = laberinto.getLaberinto();
        for (int i = 0; i < laberinto.getFilas(); i++) {
            for (int j = 0; j < laberinto.getColumnas(); j++) {
                celda = mapa[i][j].getTipo();
                celdasEnNumero.add(celdas.get(celda));
            }
        }
    }

    public void radearBomba(int filaActual, int columnaActual) {
        Celda[][] mapa = laberinto.getLaberinto();
        Pair<Integer, Integer> posicionDelJugador = new Pair<>();
        posicionDelJugador.first = filaActual;
        posicionDelJugador.second = columnaActual;
        List<Pair<Integer, Integer>> posicionesParaBomba = laberinto.definirVecinosParaBomba(posicionDelJugador);
        for(Pair<Integer, Integer> indicadorBomba : posicionesParaBomba) {
            if(mapa[indicadorBomba.first][indicadorBomba.second].getTipo().equals("Camino")) {
                mapa[indicadorBomba.first][indicadorBomba.second] = new Celda();
                mapa[indicadorBomba.first][indicadorBomba.second] = new CaminoConPunto();
            }
        }
    }

    public void ponerBomba(int filaObjetivo, int columnaObjetivo) {
        Celda[][] mapa = laberinto.getLaberinto();
        if(mapa[filaObjetivo][columnaObjetivo].getTipo().equals("Muro")) return;
        if(mapa[filaObjetivo][columnaObjetivo].getTipo().equals("MuroRojo")) return;
        mapa[filaObjetivo][columnaObjetivo] = new Celda();
        mapa[filaObjetivo][columnaObjetivo] = new Bomba();
        mapa[filaObjetivo][columnaObjetivo].setTraspasable(false);
        System.out.println("Bomba puesta en posicion: " + filaObjetivo + " " + columnaObjetivo);
        PauseTransition pausa = new PauseTransition(Duration.seconds(1));
        pausa.setOnFinished(event -> {
            explotarBomba(filaObjetivo, columnaObjetivo);
        });
        pausa.play();
    }

    public void explotarBomba(int filaObjetivo, int columnaObjetivo) {
        Celda[][] mapa = laberinto.getLaberinto();
        Pair<Integer, Integer> posicionBomba = new Pair<>();
        posicionBomba.first = filaObjetivo;
        posicionBomba.second = columnaObjetivo;
        List<Pair<Integer, Integer>> vecinosDeBomba = laberinto.definirVecinosParaBomba(posicionBomba);
        for(Pair<Integer, Integer> indicadorBomba : vecinosDeBomba) {
            if(mapa[indicadorBomba.first][indicadorBomba.second].getTipo().equals("MuroRojo")) {
                mapa[indicadorBomba.first][indicadorBomba.second] = new Celda();
                mapa[indicadorBomba.first][indicadorBomba.second] = new Camino();
            }
        }
        mapa[filaObjetivo][columnaObjetivo] = new Celda();
        mapa[filaObjetivo][columnaObjetivo] = new Camino();
    }

    public void quitarCaminosConPuntos() {
        Celda[][] mapa = laberinto.getLaberinto();
        Pair<Integer, Integer> posicionDelJugador = laberinto.getJugadorPos();
        List<Pair<Integer, Integer>> posicionesParaBomba = laberinto.definirVecinosParaBomba(posicionDelJugador);
        for(Pair<Integer, Integer> indicadorBomba : posicionesParaBomba) {
            if(mapa[indicadorBomba.first][indicadorBomba.second].getTipo().equals("CaminoConPunto")) {
                mapa[indicadorBomba.first][indicadorBomba.second] = new Celda();
                mapa[indicadorBomba.first][indicadorBomba.second] = new Camino();
            }
        }
    }
}
