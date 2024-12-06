public class Tablero {
    private char[][] tablero = new char[6][6];
    private int buenosJugador1, malosJugador1;
    private int buenosJugador2, malosJugador2;

    public void inicializarTablero() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    public void inicializarContadores(int cantidadFantasmas) {
        buenosJugador1 = malosJugador1 = cantidadFantasmas / 2;
        buenosJugador2 = malosJugador2 = cantidadFantasmas / 2;
    }

    public void colocarFantasma(int fila, int columna, char tipo) {
        tablero[fila][columna] = tipo;
    }

    public boolean moverFantasma(int filaOrigen, int colOrigen, int filaDestino, int colDestino, char jugador) {
        if (!esMovimientoValido(filaOrigen, colOrigen, filaDestino, colDestino, jugador)) {
            return false;
        }

        char contenido = tablero[filaDestino][colDestino];
        if (contenido == 'B' || contenido == 'M') {
            if (contenido == 'B') {
                if (jugador == '1') buenosJugador2--;
                else buenosJugador1--;
            } else {
                if (jugador == '1') malosJugador2--;
                else malosJugador1--;
            }
        }

        tablero[filaDestino][colDestino] = tablero[filaOrigen][colOrigen];
        tablero[filaOrigen][colOrigen] = ' ';
        return true;
    }

    private boolean esMovimientoValido(int filaOrigen, int colOrigen, int filaDestino, int colDestino, char jugador) {
        if (filaDestino < 0 || filaDestino >= 6 || colDestino < 0 || colDestino >= 6) return false;
        if (Math.abs(filaDestino - filaOrigen) + Math.abs(colDestino - colOrigen) != 1) return false;
        char fantasma = tablero[filaOrigen][colOrigen];
        if ((jugador == '1' && (fantasma != 'B' && fantasma != 'M')) ||
            (jugador == '2' && (fantasma != 'b' && fantasma != 'm'))) {
            return false;
        }
        return tablero[filaDestino][colDestino] == ' ' || tablero[filaDestino][colDestino] != jugador;
    }

    public boolean revisarFinDeJuego() {
        return (buenosJugador1 == 0 || malosJugador2 == 0 || buenosJugador2 == 0 || malosJugador1 == 0);
    }

    public void mostrarTablero() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("[" + tablero[i][j] + "]");
            }
            System.out.println();
        }
    }
}
