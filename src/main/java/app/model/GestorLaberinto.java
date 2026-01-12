package app.model;

import app.controller.LaberintoController;
import app.model.usuarios.Usuario;
import app.repository.DatosJson;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import laberinto.Laberinto;
import laberinto.Posicion.Pair;
import laberinto.celdas.*;

import java.util.*;

/**
 * Clase encargada de gestionar la lógica de interacción entre el jugador y el laberinto,
 * controlando movimientos, colisiones, recolección de objetos y estados de victoria o derrota.
 *
 * @author Darwin Marcano
 * @version 22.0.2
 * @since 11-01-2026
 */
public class GestorLaberinto {
    private static Laberinto laberinto;
    private static Jugador jugador;
    private static Usuario usuarioActivo = new Usuario();
    private Pair<Integer, Integer> posicionSalida;
    private Pair<Integer, Integer> posicionJugador;
    private static ArrayList<Integer> celdasEnNumero = new ArrayList<>();
    private final DatosJson datosJson = new DatosJson();

    /**
     * Obtiene el usuario que se encuentra actualmente en sesión.
     * @author Darwin Marcano
     * @return Objeto Usuario activo.
     */
    public static Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    /**
     * Asigna el usuario que participará en la sesión de juego.
     * @author Darwin Marcano
     * @param usuarioActivo Objeto Usuario a activar.
     */
    public static void setUsuarioActivo(Usuario usuarioActivo) {
        GestorLaberinto.usuarioActivo = usuarioActivo;
    }

    /**
     * Constructor que vincula un laberinto específico con un jugador para iniciar la gestión.
     * @author Darwin Marcano
     * @param laberinto Instancia del laberinto generado.
     * @param jugador Instancia del jugador que se moverá.
     */
    public GestorLaberinto(Laberinto laberinto, Jugador jugador)
    {
        this.laberinto = laberinto;
        GestorLaberinto.jugador = jugador;
        this.posicionSalida = laberinto.getSalidaPos();
        this.posicionJugador = laberinto.getJugadorPos();
    }


    /**
     * Recupera las coordenadas actuales del jugador dentro del mapa.
     * @author Darwin Marcano
     * @return Par de coordenadas (fila, columna).
     */
    public Pair<Integer, Integer> getPosicionJugador() {return posicionJugador;}


    /**
     * Determina si una coordenada específica está dentro de los límites y es transitable.
     * @author Darwin Marcano
     * @param fila Índice de la fila.
     * @param columna Índice de la columna.
     * @return true si el jugador puede ocupar esa celda, false en caso contrario.
     */
    public boolean posicionValida(int fila, int columna) {
        Celda[][] mapa = laberinto.getLaberinto();
        if(fila < 0 || fila >= laberinto.getFilas() || columna < 0 || columna >= laberinto.getColumnas()) {
            return false;
        }
        return mapa[fila][columna].isTraspasable();
    }


    /**
     * Obtiene la instancia del objeto Jugador gestionado.
     * @author Darwin Marcano
     * @return El objeto Jugador.
     */
    public static Jugador getJugador() {
        return jugador;
    }


    /**
     * Ejecuta el movimiento del jugador hacia la derecha.
     * @author Darwin Marcano
     * @param fila Nueva fila destino.
     * @param columna Nueva columna destino.
     */
    public void derecha(int fila, int columna) {
        mover(fila, columna);
    }

    /**
     * Ejecuta el movimiento del jugador hacia la izquierda.
     * @author Darwin Marcano
     * @param fila Nueva fila destino.
     * @param columna Nueva columna destino.
     */
    public void izquierda(int fila, int columna) {
        mover(fila, columna);
    }

    /**
     * Ejecuta el movimiento del jugador hacia arriba.
     * @author Darwin Marcano
     * @param fila Nueva fila destino.
     * @param columna Nueva columna destino.
     */
    public void arriba(int fila, int columna) {
        mover(fila, columna);
    }

    /**
     * Ejecuta el movimiento del jugador hacia abajo.
     * @author Darwin Marcano
     * @param fila Nueva fila destino.
     * @param columna Nueva columna destino.
     */
    public void abajo(int fila, int columna) {
        mover(fila, columna);
    }

    /**
     * Genera un número entero aleatorio dentro de un rango específico.
     * @author Darwin Marcano
     * @param min Valor mínimo inclusivo.
     * @param max Valor máximo inclusivo.
     * @return Número aleatorio generado.
     */
    public static int aleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Verifica si la posición actual contiene una trampa y resta vida al jugador si es así.
     * @author Darwin Marcano
     * @param fila Fila a comprobar.
     * @param columna Columna a comprobar.
     */
    public void chequearSiEsTrampa(int fila, int columna) {
        Celda[][] mapa = laberinto.getLaberinto();
        if(mapa[fila][columna].getTipo().equals("Trampa")) {
            jugador.perderVida(20);
            System.out.println("Cuidado! Has caido en una trampa. Vida restante: " + jugador.getVida());
            usuarioActivo.setTrampasActivadas(usuarioActivo.getTrampasActivadas()+1);
            System.out.println(usuarioActivo.getTrampasActivadas() + " - " + usuarioActivo.getCorreo());
            GestionUsuario.actualizarUsuario(usuarioActivo);
            datosJson.actualizarDatos(GestionUsuario.getListaUsuarios());
        }
    }

    /**
     * Comprueba si hay un cristal en la celda y añade una cantidad aleatoria al inventario.
     * @author Darwin Marcano
     * @param fila Fila a comprobar.
     * @param columna Columna a comprobar.
     */
    public void chequearSiEsCristal(int fila, int columna) {
        Celda[][] mapa = laberinto.getLaberinto();
        int aleatorio =  aleatorio(1, 5);
        if(mapa[fila][columna].getTipo().equals("Cristal")) {
            jugador.setCristales(jugador.getCristales() + aleatorio);
            System.out.println("Has recogido un cristal! Cristales: " + jugador.getCristales());
            usuarioActivo.setCristalesObtenidos(usuarioActivo.getCristalesObtenidos()+aleatorio);
            System.out.println(usuarioActivo.getCristalesObtenidos() + " - " + usuarioActivo.getCorreo());
            GestionUsuario.actualizarUsuario(usuarioActivo);
            datosJson.actualizarDatos(GestionUsuario.getListaUsuarios());
        }
    }


    /**
     * Verifica si la celda contiene un ítem de vida y cura al jugador si no tiene la salud máxima.
     * @author Darwin Marcano
     * @param fila Fila a comprobar.
     * @param columna Columna a comprobar.
     */
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

    /**
     * Verifica si el jugador ha recogido una bomba para aumentar su munición.
     * @author Darwin Marcano
     * @param fila Fila a comprobar.
     * @param columna Columna a comprobar.
     */
    public void chequearSiEsBomba(int fila, int columna) {
        Celda[][] mapa = laberinto.getLaberinto();
        if(mapa[fila][columna].getTipo().equals("Bomba")) {
            System.out.println("Has obtenido una bomba! Puedes usarla para destruir muros.");
            jugador.aumentarBomba();
            usuarioActivo.setBombasRecolectadas(usuarioActivo.getBombasRecolectadas()+1);
            System.out.println(usuarioActivo.getBombasRecolectadas() + " - " + usuarioActivo.getCorreo());
            GestionUsuario.actualizarUsuario(usuarioActivo);
            datosJson.actualizarDatos(GestionUsuario.getListaUsuarios());
        }
    }


    /**
     * Comprueba si la celda contiene energía y aumenta la reserva del jugador.
     * @author Darwin Marcano
     * @param fila Fila a comprobar.
     * @param columna Columna a comprobar.
     */
    public void chequearSiEsEnergia(int fila, int columna) {
        Celda[][] mapa = laberinto.getLaberinto();
        int aleatorio =  aleatorio(1, 2);
        if(mapa[fila][columna].getTipo().equals("Energia")) {
            jugador.setEnergia(jugador.getEnergia() + aleatorio * 10);
            System.out.println("Has recogido energia! Energia aumentada: " + jugador.getEnergia());
        }
    }


    /**
     * Verifica si el jugador ha obtenido la llave de salida o la llave de explosión.
     * @author Darwin Marcano
     * @param fila Fila a comprobar.
     * @param columna Columna a comprobar.
     */
    public void chequearSiEsLlave(int fila, int columna) {
        Celda[][] mapa = laberinto.getLaberinto();
        if(mapa[fila][columna].getTipo().equals("Llave")) {
            jugador.setLlave(true);
            System.out.println("Has recogido la llave! Ahora puedes abrir la salida del laberinto.");
            mapa[posicionSalida.first][posicionSalida.second].setTraspasable(true);
        }
        else if(mapa[fila][columna].getTipo().equals("LlaveDeExplosion")) {
            System.out.println("Has recogido la llave de explosion, ahora puedes poner bombas!");
            jugador.setLlaveDeExplosion(true);
        }
    }


    /**
     * Determina si las coordenadas dadas corresponden a la ubicación de la salida.
     * @author Darwin Marcano
     * @param fila Fila a comprobar.
     * @param columna Columna a comprobar.
     * @return true si es la celda de salida.
     */
    public boolean chequearSiEsSalida(int fila, int columna) {
        return fila == posicionSalida.first && columna == posicionSalida.second;
    }

    /**
     * Evalúa si el jugador ha llegado a la salida poseyendo la llave.
     * @author Darwin Marcano
     * @return true si se cumplen las condiciones de victoria.
     */
    public boolean verificarVictoria() {
        int fila = laberinto.getSalidaPos().first;
        int columna = laberinto.getSalidaPos().second;
        return fila == getPosicionJugador().first && columna == getPosicionJugador().second && jugador.isLlave();
    }

    /**
     * Evalúa si el jugador ha perdido toda su vida.
     * @author Darwin Marcano
     * @return true si la vida es menor o igual a cero.
     */
    public boolean verificarDerrota() {
        return jugador.getVida() <= 0;
    }

    private static boolean haPerdido;


    /**
     * Consulta el estado actual de derrota del jugador.
     * @author Darwin Marcano
     * @return true si el jugador ha perdido.
     */
    public static boolean isHaPerdido() {
        return haPerdido;
    }

    /**
     * Establece el estado de derrota del jugador.
     * @author Darwin Marcano
     * @param estado Nuevo estado de pérdida.
     */
    public static void setHaPerdido(boolean estado) {
        haPerdido = estado;
    }

    /**
     * Gestiona el desplazamiento del jugador, validando la celda y procesando los ítems encontrados.
     * @author Darwin Marcano
     * @param fila Fila destino.
     * @param columna Columna destino.
     */
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
                posicionJugador.first = laberinto.getSalidaPos().first;
                posicionJugador.second = laberinto.getSalidaPos().second;
                System.out.println("Felicidades! Has salido del laberinto.");
            } else {
                System.out.println("Necesitas la llave para salir del laberinto.");
            }
            return;
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

    /**
     * Transforma la matriz de celdas en una lista de enteros para facilitar su almacenamiento.
     * @author Darwin Marcano
     * @return ArrayList con los identificadores numéricos de cada celda.
     */
    public static ArrayList<Integer> guardarLaberinto() {
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
        celdas.put("LlaveDeExplosion", 12);
        String celda;
        Celda[][] mapa = laberinto.getLaberinto();
        for (int i = 0; i < laberinto.getFilas(); i++) {
            for (int j = 0; j < laberinto.getColumnas(); j++) {
                celda = mapa[i][j].getTipo();
                celdasEnNumero.add(celdas.get(celda));
            }
        }
        return celdasEnNumero;
    }

    /**
     * Marca visualmente los caminos adyacentes donde el jugador puede colocar una bomba.
     * @author Darwin Marcano
     * @param filaActual Fila donde se encuentra el jugador.
     * @param columnaActual Columna donde se encuentra el jugador.
     */
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

    /**
     * Coloca una bomba en la posición indicada e inicia el temporizador para su explosión.
     * @author Darwin Marcano
     * @param filaObjetivo Fila donde se sitúa la bomba.
     * @param columnaObjetivo Columna donde se sitúa la bomba.
     */
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

    /**
     * Procesa la explosión de la bomba, eliminando muros rojos en las cercanías y consumiendo energía.
     * @author Darwin Marcano
     * @param filaObjetivo Fila origen de la explosión.
     * @param columnaObjetivo Columna origen de la explosión.
     */
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
        jugador.setEnergia(jugador.getEnergia() - 20);
        mapa[filaObjetivo][columnaObjetivo] = new Celda();
        mapa[filaObjetivo][columnaObjetivo] = new Camino();
    }

    /**
     * Elimina los indicadores visuales de colocación de bomba del laberinto.
     * @author Darwin Marcano
     */
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
