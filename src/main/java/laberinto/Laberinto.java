package laberinto;

import laberinto.celdas.Celda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import laberinto.Posicion.Pair;
import laberinto.celdas.*;

/**
 * Clase que contiene un arreglo bidimensional de Celdas para almacenar,
 * dinámicamente clases que hereden de Celda. También crea el arreglo y
 * permite el movimiento del jugador del usuario
 *
 * @author Jesus Sifontes y Darwin Marcano
 * @version 22.0.2
 * @since 02-11-2025
 */

public class Laberinto {
    private Celda[][] laberinto;
    private int filas, columnas;
    private Posicion.Pair<Integer, Integer> jugadorPos;
    private Pair<Integer, Integer> salidaPos;
    private Pair<Integer, Integer> llavePos;
    private Random random;
    public Laberinto(int filas, int columnas, int dificultad) {
        this.filas = filas;
        this.columnas = columnas;
        this.random = new Random();
        this.laberinto = new Celda[filas][columnas];
        generarLaberinto();
    }

    public Celda[][] getLaberinto() {
        return laberinto;
    }

    public void setLaberinto(Celda[][] laberinto) {
        this.laberinto = laberinto;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public Pair<Integer, Integer> getJugadorPos() {
        return jugadorPos;
    }

    public void setJugadorPos(Pair<Integer, Integer> jugadorPos) {
        this.jugadorPos = jugadorPos;
    }

    public Pair<Integer, Integer> getSalidaPos() {
        return salidaPos;
    }

    public void setSalidaPos(Pair<Integer, Integer> salidaPos) {
        this.salidaPos = salidaPos;
    }

    public Pair<Integer, Integer> getLlavePos() {
        return llavePos;
    }

    public void setLlavePos(Pair<Integer, Integer> llavePos) {
        this.llavePos = llavePos;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    private void inicializarLaberinto() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                laberinto[i][j] = new Muro();
            }
        }
    }
    private void generarLaberinto() {
        inicializarLaberinto();
        generarCaminosDFS();
        colocarElementos();
    }

    private void generarCaminosDFS() {

        boolean[][] visitado = new boolean[filas][columnas];
        Stack<Pair<Integer, Integer>> pila = new Stack<>();
        Pair<Integer, Integer> comienzo;

        comienzo = seleccionarComienzo(laberinto);
        pila.push(comienzo);
        visitado[comienzo.first][comienzo.second] = true;
        laberinto[comienzo.first][comienzo.second] = new Camino();

        while (!pila.isEmpty()) {
            Pair<Integer, Integer> actual = pila.pop();
            List<Pair<Integer, Integer>> vecinos = definirVecinos(actual);
            List<Pair<Integer, Integer>> vecinosNoVisitados = new ArrayList<>();

            for(Pair<Integer, Integer> vecino : vecinos) {
                if(!visitado[vecino.first][vecino.second]) {
                    vecinosNoVisitados.add(vecino);
                }
            }
            if(!vecinosNoVisitados.isEmpty()) {
                pila.push(actual);
                Random random = new Random();
                Pair<Integer, Integer> elegido = vecinosNoVisitados.get(random.nextInt(vecinosNoVisitados.size())) ;
                visitado[elegido.first][elegido.second] = true;
                laberinto[elegido.first][elegido.second] = new Camino();
                int paredFila = (actual.first + elegido.first) / 2;
                int paredColumna = (actual.second + elegido.second) / 2;
                laberinto[paredFila][paredColumna] = new Camino();
                pila.push(elegido);
            }
        }
    }

    private void colocarElementos() {
        Pair<Integer, Integer> posicion_usuario = seleccionarPosicionUsuario(laberinto);
        laberinto[posicion_usuario.first][posicion_usuario.second] = new Jugador();
        this.jugadorPos = posicion_usuario;

        Pair<Integer, Integer> posicion_puerta = seleccionarPosicionPuerta(posicion_usuario);
        laberinto[posicion_puerta.first][posicion_puerta.second] = new Salida();
        this.salidaPos = posicion_puerta;

        Pair<Integer, Integer> posicion_llave = seleccionarPosicionLlave(posicion_puerta, posicion_usuario);
        laberinto[posicion_llave.first][posicion_llave.second] = new LLave();
        this.llavePos = posicion_llave;

        verificarMuros(posicion_puerta);
        verificarMuros(posicion_llave);
    }

    private Pair<Integer, Integer> seleccionarComienzo(Celda[][] laberinto) {
        int random1, random2;

        if (random.nextBoolean()) {
            random1 = 1 + 2 * random.nextInt((filas - 1) / 2);
            random2 = 2 + 2 * random.nextInt((columnas - 2) / 2);
        } else {
            random1 = 2 + 2 * random.nextInt((filas - 2) / 2);
            random2 = 1 + 2 * random.nextInt((columnas - 1) / 2);
        }

        random1 = Math.min(random1, filas - 2);
        random2 = Math.min(random2, columnas - 2);

        Pair<Integer, Integer> comienzo = new Pair<>();
        comienzo.first = random1;
        comienzo.second = random2;
        return comienzo;
    }

    private List<Pair<Integer, Integer>> definirVecinos(Pair<Integer, Integer> actual) {
        List<Pair<Integer, Integer>> vecinos = new ArrayList<>();
        // Arriba
        if(actual.first - 2 > 0)
        {
            Pair<Integer, Integer> vecino = new Pair<>();
            vecino.first = actual.first - 2;
            vecino.second = actual.second;
            vecinos.add(vecino);
        }
        //Izquierda
        if(actual.second - 2 > 0)
        {
            Pair<Integer, Integer> vecino = new Pair<>();
            vecino.first = actual.first;
            vecino.second = actual.second - 2;
            vecinos.add(vecino);
        }
        //Derecha
        if(actual.second + 2 < columnas - 1)
        {
            Pair<Integer, Integer> vecino = new Pair<>();
            vecino.first = actual.first;
            vecino.second = actual.second + 2;
            vecinos.add(vecino);
        }
        //Abajo
        if(actual.first + 2 < filas - 1)
        {
            Pair<Integer, Integer> vecino = new Pair<>();
            vecino.first = actual.first + 2;
            vecino.second = actual.second;
            vecinos.add(vecino);
        }
        return vecinos;
    }

    public Pair<Integer, Integer> seleccionarPosicionUsuario(Celda[][] laberinto) {

        Random rand = new Random();
        Pair<Integer, Integer> posicion_a_retornar = new Pair<>();
        int fila = rand.nextInt(filas);
        int columna = rand.nextInt(columnas);
        Celda posicion = laberinto[fila][columna];
        while(posicion.getTipo().equals("Muro")) {
            fila = rand.nextInt(filas);
            columna = rand.nextInt(columnas);
            posicion =  laberinto[fila][columna];
        }
        posicion_a_retornar.first = fila;
        posicion_a_retornar.second = columna;
        return posicion_a_retornar;
    }

    public Pair<Integer, Integer> seleccionarPosicionPuerta(Pair<Integer, Integer> posicion_usuario) {

        Pair<Integer, Integer> posicion_puerta = new Pair<>();

        if(posicion_usuario.first >= (filas / 2) && posicion_usuario.second >= (columnas / 2)) {
            posicion_puerta.first = 1;
            posicion_puerta.second = 1;
        }
        else if(posicion_usuario.first <= (filas / 2) && posicion_usuario.second <= (columnas / 2)) {
            posicion_puerta.first = filas - 2;
            posicion_puerta.second = columnas - 2;
        }
        else if(posicion_usuario.first <= (filas / 2) && posicion_usuario.second > (columnas / 2)) {
            posicion_puerta.first = filas - 2;
            posicion_puerta.second = (columnas / 2) - 1;
        }
        else {
            posicion_puerta.first = posicion_usuario.second;
            posicion_puerta.second = posicion_usuario.first;
        }
        return posicion_puerta;
    }

    public Pair<Integer, Integer> seleccionarPosicionLlave(Pair<Integer, Integer> posicion_puerta, Pair<Integer, Integer> posicion_usuario) {

        Pair<Integer, Integer> posicion_llave = new Pair<>();
        Random rand1 = new Random();
        Random rand2 = new Random();

        if(posicion_puerta.first < (filas / 2) && posicion_puerta.second < (columnas / 2)) {
            int max = filas - 2;
            int min = filas / 2;
            int aleatorio1 = rand1.nextInt(max -  min + 1) + min;
            int aleatorio2 = rand2.nextInt(max -  min + 1) + min;
            while(aleatorio1 == posicion_usuario.first || aleatorio2 == posicion_usuario.second) {
                aleatorio1 = rand1.nextInt(max -  min + 1) + min;
                aleatorio2 = rand2.nextInt(max -  min + 1) + min;
            }
            posicion_llave.first = aleatorio1;
            posicion_llave.second = aleatorio2;
        }

        if(posicion_puerta.first >= filas / 2 && posicion_puerta.second >= columnas / 2) {
            int max = (filas / 2) - 1;
            int min = 1;
            int aleatorio3 = rand1.nextInt(max -  min + 1) + min;
            int aleatorio4 = rand2.nextInt(max -  min + 1) + min;
            while(aleatorio3 == posicion_usuario.first || aleatorio4 == posicion_usuario.second) {
                aleatorio3 = rand1.nextInt(max -  min + 1) + min;
                aleatorio4 = rand2.nextInt(max -  min + 1) + min;
            }
            posicion_llave.first = aleatorio3;
            posicion_llave.second = aleatorio4;
        }

        if(posicion_puerta.first <= filas / 2 && posicion_puerta.second >= columnas / 2) {
            int max = filas - 2;
            int min = 1;
            int aleatorio5 = rand1.nextInt(max -  min + 1) + min;
            int aleatorio6 = rand2.nextInt(max -  min + 1) + min;
            while(aleatorio5 == posicion_usuario.first || aleatorio6 == posicion_usuario.second) {
                aleatorio5 = rand1.nextInt(max -  min + 1) + min;
                aleatorio6 = rand2.nextInt(max -  min + 1) + min;
            }
            posicion_llave.first = aleatorio5;
            posicion_llave.second = aleatorio6;
        }

        if(posicion_puerta.first >= filas / 2 && posicion_puerta.second <= columnas / 2) {
            int max = filas - 2;
            int min = filas / 2;
            int aleatorio7 = rand1.nextInt(max -  min + 1) + min;
            int aleatorio8 = rand2.nextInt(max -  min + 1) + min;
            while(aleatorio7 == posicion_usuario.first || aleatorio8 == posicion_usuario.second) {
                aleatorio7 = rand1.nextInt(max -  min + 1) + min;
                aleatorio8 = rand2.nextInt(max -  min + 1) + min;
            }
            posicion_llave.first = aleatorio7;
            posicion_llave.second = aleatorio8;
        }

        return posicion_llave;
    }


    private void verificarMuros(Pair<Integer, Integer> posicion) {
        //Arriba
        if(posicion.first - 1 > 0 && !laberinto[posicion.first - 1][posicion.second
                ].isTraspasable())
        {
            laberinto[posicion.first - 1][posicion.second] = new Camino();
            return;
        }
        //Abajo
        if(posicion.first + 1 < filas - 1 && !laberinto[posicion.first + 1][posicion.second].isTraspasable())
        {
            laberinto[posicion.first + 1][posicion.second] = new Camino();
            return;
        }
        //Izquierda
        if(posicion.second - 1 > 0 && !laberinto[posicion.first][posicion.second - 1].isTraspasable())
        {
            laberinto[posicion.first][posicion.second - 1] = new Camino();
            return;
        }
        //Derecha
        if(posicion.second + 1 < columnas - 1 && !laberinto[posicion.first][posicion.second + 1].isTraspasable())
        {
            laberinto[posicion.first][posicion.second + 1] = new Camino();
            return;
        }
    }
    public void imprimirLaberinto() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(laberinto[i][j].getTipo());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Laberinto laberinto = new Laberinto(15, 25, 1);
        laberinto.imprimirLaberinto();
    }
}
