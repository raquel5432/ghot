import java.util.Random;

public class Tablero {
    private char[][] tablero; // Matriz 6x6
    private final int TAMANIO = 6;

    public Tablero() {
        tablero = new char[TAMANIO][TAMANIO];
        inicializarTablero();
    }

    // Inicializa el tablero con espacios vacíos
    private void inicializarTablero() {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    // Muestra el tablero en consola
    public void mostrarTablero() {
        System.out.println("   0 1 2 3 4 5");
        for (int i = 0; i < TAMANIO; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TAMANIO; j++) {
                System.out.print("|" + tablero[i][j]);
            }
            System.out.println("|");
        }
    }

    // Coloca un fantasma en una posición
    public boolean colocarFantasma(int fila, int columna, char tipoFantasma) {
        if (fila >= 0 && fila < TAMANIO && columna >= 0 && columna < TAMANIO && tablero[fila][columna] == ' ') {
            tablero[fila][columna] = tipoFantasma;
            return true;
        }
        return false;
    }

    // Mueve un fantasma a una nueva posición
    public boolean moverFantasma(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        if (esMovimientoValido(filaInicial, columnaInicial, filaFinal, columnaFinal)) {
            tablero[filaFinal][columnaFinal] = tablero[filaInicial][columnaInicial];
            tablero[filaInicial][columnaInicial] = ' ';
            return true;
        }
        return false;
    }

    // Valida el movimiento del fantasma
    private boolean esMovimientoValido(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        if (filaFinal < 0 || filaFinal >= TAMANIO || columnaFinal < 0 || columnaFinal >= TAMANIO) return false;
        if (Math.abs(filaFinal - filaInicial) + Math.abs(columnaFinal - columnaInicial) != 1) return false;
        return tablero[filaFinal][columnaFinal] == ' ';
    }
}
