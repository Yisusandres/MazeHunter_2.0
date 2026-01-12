package laberinto;

import app.model.GestorLaberinto;
import laberinto.celdas.Celda;

import java.security.Key;
import java.util.*;

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
    private int filas, columnas, dificultad;
    private Pair<Integer, Integer> jugadorPos;
    private Pair<Integer, Integer> salidaPos;
    private Pair<Integer, Integer> llavePos;
    private Random random;
    /**
     * Constructor que inicializa las dimensiones, dificultad y genera la estructura del laberinto.
     *
     * @author Jesus Sifontes y Darwin Marcano
     * @param filas Número de filas del laberinto.
     * @param columnas Número de columnas del laberinto.
     * @param dificultad Nivel de dificultad que determina la cantidad de obstáculos y objetos.
     * @version 22.0.2
     * @since 11-01-2026
     */
    public Laberinto(int filas, int columnas, int dificultad) {
        this.filas = filas;
        this.columnas = columnas;
        this.dificultad = dificultad;
        this.random = new Random();
        this.laberinto = new Celda[filas][columnas];
        generarLaberinto();
    }

    /**
     * Obtiene la matriz bidimensional de celdas que representa el laberinto.
     * @author Jesus Sifontes y Darwin Marcano
     * @return La matriz de objetos Celda.
     * @version 22.0.2
     * @since 11-01-2026
     * */
    public Celda[][] getLaberinto() {
        return laberinto;
    }

    /**
     * Establece una nueva matriz de celdas para el laberinto.
     * @author Jesus Sifontes y Darwin Marcano
     * @param laberinto Matriz de celdas a asignar.
     * @version 22.0.2
     * @since 11-01-2026
     * */
    public void setLaberinto(Celda[][] laberinto) {
        this.laberinto = laberinto;
    }


    /**
     * Obtiene la cantidad total de filas del laberinto.
     * @author Jesus Sifontes y Darwin Marcano
     * @return Entero con el número de filas.
     * @version 22.0.2
     * @since 11-01-2026
     * */
    public int getFilas() {
        return filas;
    }

    /**
     * Obtiene la cantidad total de columnas del laberinto.
     * @author Jesus Sifontes y Darwin Marcano
     * @return Entero con el número de columnas.
     * @version 22.0.2
     * @since 11-01-2026
     * */
    public int getColumnas() {
        return columnas;
    }


    /**
     * Obtiene las coordenadas actuales del jugador en el tablero.
     * @author Jesus Sifontes y Darwin Marcano
     * @return Un objeto Pair con la fila (first) y columna (second).
     * @version 22.0.2
     * @since 11-01-2026
     * */
    public Pair<Integer, Integer> getJugadorPos() {
        return jugadorPos;
    }

    /**
     * Actualiza la posición del jugador en el sistema de coordenadas.
     * @author Jesus Sifontes y Darwin Marcano
     * @param jugadorPos Objeto Pair con la nueva ubicación.
     * @version 22.0.2
     * @since 11-01-2026
     * */
    public void setJugadorPos(Pair<Integer, Integer> jugadorPos) {
        this.jugadorPos = jugadorPos;
    }

    /**
     * Obtiene la ubicación de la celda de salida del laberinto.
     * @author Jesus Sifontes y Darwin Marcano
     * @return Coordenadas de la salida.
     * @version 22.0.2
     * @since 11-01-2026
     * */
    public Pair<Integer, Integer> getSalidaPos() {return salidaPos;}


    /**
     * Rellena la matriz inicial con muros y muros rojos de forma aleatoria antes de generar caminos.
     * Ejecuta el proceso completo de creación: inicialización, generacion de caminos y colocación de elementos.
     * Implementa el algoritmo de búsqueda en profundidad (DFS) con una pila para crear los pasillos del laberinto.
     * Distribuye dinámicamente al jugador, la llave, la salida y los consumibles según la dificultad elegida.
     * Elige un punto de origen aleatorio para comenzar la excavación del algoritmo DFS.
     * Identifica las celdas vecinas a una distancia de dos posiciones para la generación de caminos.
     * Localiza celdas adyacentes inmediatas (distancia 1) para calcular el área de efecto de una explosión.
     * Busca una posición aleatoria que no sea un muro para situar al usuario al inicio del juego.
     * Determina la ubicación de la salida intentando que esté lo más alejada posible del jugador.
     * Decide la ubicación de la llave de forma que no coincida con el jugador ni con la salida.
     * Asegura que una posición clave (como la llave o salida) tenga al menos un camino adyacente para ser accesible.
     * Imprime en la consola la representación visual del laberinto basada en el tipo de cada celda.
     * @author Darwin Marcano
     * @version 22.0.2
     * @since 11-01-2026
     * */
    private void inicializarLaberinto() {
        int aleatorio, numeroMurosRojos = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if(i % 2 != 0 && j % 2 != 0) numeroMurosRojos = GestorLaberinto.aleatorio(6, 8);
                else numeroMurosRojos = 0;
                aleatorio = (int)(Math.random()*2);
                if(aleatorio == 1 && i != 0 && j != 0 && i != 1 && j != 1 && i != filas - 1 && j != columnas - 1 && i != filas - 2 && j != columnas - 2 && numeroMurosRojos > 0) {
                    laberinto[i][j] = new MuroRojo();
                }
                else {
                    laberinto[i][j] = new Muro();
                }
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
        laberinto[posicion_usuario.first][posicion_usuario.second] = new JugadorCelda();
        this.jugadorPos = posicion_usuario;

        Pair<Integer, Integer> posicion_puerta = seleccionarPosicionPuerta(posicion_usuario);
        laberinto[posicion_puerta.first][posicion_puerta.second] = new Salida();
        this.salidaPos = posicion_puerta;

        Pair<Integer, Integer> posicion_llave = seleccionarPosicionLlave(posicion_puerta, posicion_usuario);
        laberinto[posicion_llave.first][posicion_llave.second] = new LLave();
        this.llavePos = posicion_llave;

        verificarMuros(posicion_puerta);
        verificarMuros(posicion_llave);

        int numeroTrampas = 0, numeroVidas, numeroCristales, numeroBombas = 0, numeroEnergias = 0;

        if(this.dificultad == 1) {
            numeroBombas = 5;
            if(this.filas >= 5 && this.filas <= 10) {
                numeroTrampas = 2;
                numeroEnergias = 2;
            } else {
                numeroTrampas = 3;
                numeroEnergias = 3;
            }
        }

        if(this.dificultad == 2) {
            numeroBombas = 15;
            if(this.filas >= 16 && this.filas <= 20) {
                numeroTrampas = 4;
                numeroEnergias = 4;
            } else {
                numeroTrampas = 5;
                numeroEnergias = 5;
            }
        }

        if(this.dificultad == 3) {
            numeroBombas = 20;
            if(this.filas >= 26 && this.filas <= 45) {
                numeroTrampas = 6;
                numeroEnergias = 6;
                if (this.filas >= 31 && this.filas <= 40) {
                    numeroTrampas = 12;
                    numeroEnergias = 12;
                }
                if (this.filas >= 41) {
                    numeroTrampas = 18;
                    numeroEnergias = 18;
                }
            }
        }

        if(this.dificultad == 4) {
            numeroBombas = 25;
            numeroTrampas = 40;
            numeroEnergias = 25;
        }

        Random rand = new Random();
        int max = filas - 1;
        int min = 1;
        while(numeroTrampas > 0) {
            int aleatorio1 =  rand.nextInt(max -  min + 1) + min;
            int aleatorio2 =  rand.nextInt(max -  min + 1) + min;
            if(laberinto[aleatorio1][aleatorio2].isTraspasable() && !(laberinto[aleatorio1][aleatorio2] instanceof LLave) && !(laberinto[aleatorio1][aleatorio2] instanceof Salida) && aleatorio1 != posicion_usuario.first && aleatorio2 != posicion_usuario.second) {
                laberinto[aleatorio1][aleatorio2] = new Trampa();
                numeroTrampas--;
            }
        }

        numeroVidas = (filas / 3) / 2;
        rand = new Random();
        max = filas - 2;
        while(numeroVidas > 0) {
            int aleatorio1 =  rand.nextInt(max -  min + 1) + min;
            int aleatorio2 =  rand.nextInt(max -  min + 1) + min;
            if(laberinto[aleatorio1][aleatorio2].isTraspasable() && !(laberinto[aleatorio1][aleatorio2] instanceof Trampa) && !(laberinto[aleatorio1][aleatorio2] instanceof Salida) && !(laberinto[aleatorio1][aleatorio2] instanceof LLave) && aleatorio1 != posicion_usuario.first && aleatorio2 != posicion_usuario.second) {
                laberinto[aleatorio1][aleatorio2] = new VidaExtra(10);
                numeroVidas--;
            }
        }

        numeroCristales = filas / 2;
        rand = new Random();
        max = filas - 2;
        while(numeroCristales > 0) {
            int aleatorio1 = rand.nextInt(max - min + 1) + min;
            int aleatorio2 = rand.nextInt(max - min + 1) + min;
            if (laberinto[aleatorio1][aleatorio2].isTraspasable() && !(laberinto[aleatorio1][aleatorio2] instanceof Trampa) && !(laberinto[aleatorio1][aleatorio2] instanceof Salida) && !(laberinto[aleatorio1][aleatorio2] instanceof VidaExtra) && !(laberinto[aleatorio1][aleatorio2] instanceof LLave) && aleatorio1 != posicion_usuario.first && aleatorio2 != posicion_usuario.second) {
                int valor = rand.nextInt(4) + 1;
                laberinto[aleatorio1][aleatorio2] = new Cristal(valor);
                numeroCristales--;
            }
        }

        rand = new Random();
        max = filas - 2;
        while(numeroBombas > 0) {
            int aleatorio1 = rand.nextInt(max - min + 1) + min;
            int aleatorio2 = rand.nextInt(max - min + 1) + min;
            if (laberinto[aleatorio1][aleatorio2].isTraspasable() && !(laberinto[aleatorio1][aleatorio2] instanceof Trampa) && !(laberinto[aleatorio1][aleatorio2] instanceof Salida) && !(laberinto[aleatorio1][aleatorio2] instanceof VidaExtra) && !(laberinto[aleatorio1][aleatorio2] instanceof Cristal) && !(laberinto[aleatorio1][aleatorio2] instanceof LLave) && aleatorio1 != posicion_usuario.first && aleatorio2 != posicion_usuario.second) {
                laberinto[aleatorio1][aleatorio2] = new Bomba();
                numeroBombas--;
            }
        }


        rand = new Random();
        max = filas - 1;
        while(numeroEnergias > 0) {
            int aleatorio1 = rand.nextInt(max - min + 1) + min;
            int aleatorio2 = rand.nextInt(max - min + 1) + min;
            if (laberinto[aleatorio1][aleatorio2].isTraspasable() && !(laberinto[aleatorio1][aleatorio2] instanceof Trampa) && !(laberinto[aleatorio1][aleatorio2] instanceof Salida) && !(laberinto[aleatorio1][aleatorio2] instanceof VidaExtra) && !(laberinto[aleatorio1][aleatorio2] instanceof Cristal) && !(laberinto[aleatorio1][aleatorio2] instanceof Bomba) && !(laberinto[aleatorio1][aleatorio2] instanceof LLave) && aleatorio1 != posicion_usuario.first && aleatorio2 != posicion_usuario.second) {
                laberinto[aleatorio1][aleatorio2] = new Energia();
                numeroEnergias--;
            }
        }
        int aleatorio1, aleatorio2;
        do {
            aleatorio1 = GestorLaberinto.aleatorio(1, filas - 2);
            aleatorio2 = GestorLaberinto.aleatorio(1, columnas - 2);
        } while(laberinto[aleatorio1][aleatorio2].getTipo().equals("Muro") || laberinto[aleatorio1][aleatorio2].getTipo().equals("MuroRojo") || laberinto[aleatorio1][aleatorio2].getTipo().equals("Trampa") || laberinto[aleatorio1][aleatorio2].getTipo().equals("Salida") || laberinto[aleatorio1][aleatorio2].getTipo().equals("Llave") || laberinto[aleatorio1][aleatorio2].getTipo().equals("Cristal") || laberinto[aleatorio1][aleatorio2].getTipo().equals("Bomba") || laberinto[aleatorio1][aleatorio2].getTipo().equals("Energia") || laberinto[aleatorio1][aleatorio2].getTipo().equals("Vida") || laberinto[aleatorio1][aleatorio2].getTipo().equals("Jugador"));
        laberinto[aleatorio1][aleatorio2] = new LLaveDeExplosion();
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

    public List<Pair<Integer, Integer>> definirVecinos(Pair<Integer, Integer> actual) {
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

    public List<Pair<Integer, Integer>> definirVecinosParaBomba(Pair<Integer, Integer> actual) {
        List<Pair<Integer, Integer>> vecinos = new ArrayList<>();
        // Arriba
        if(actual.first - 1 > 0)
        {
            Pair<Integer, Integer> vecino = new Pair<>();
            vecino.first = actual.first - 1;
            vecino.second = actual.second;
            vecinos.add(vecino);
        }
        //Izquierda
        if(actual.second - 1 > 0)
        {
            Pair<Integer, Integer> vecino = new Pair<>();
            vecino.first = actual.first;
            vecino.second = actual.second - 1;
            vecinos.add(vecino);
        }
        //Derecha
        if(actual.second + 1 < columnas - 1)
        {
            Pair<Integer, Integer> vecino = new Pair<>();
            vecino.first = actual.first;
            vecino.second = actual.second + 1;
            vecinos.add(vecino);
        }
        //Abajo
        if(actual.first + 1 < filas - 1)
        {
            Pair<Integer, Integer> vecino = new Pair<>();
            vecino.first = actual.first + 1;
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
}
