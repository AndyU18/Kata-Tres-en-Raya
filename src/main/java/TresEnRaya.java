// Fase TDD: GREEN (implementar el código mínimo para pasar las pruebas)
public class TresEnRaya {

    private final char[][] tablero = new char[3][3];
    private char ultimoJugador = '\0';
    // Hola Andres, te cuidas
    // Devuelve el siguiente jugador a jugar según la última jugada
    public char obtenerSiguienteJugador() {
        if (ultimoJugador == '\0') return 'X';
        return (ultimoJugador == 'X') ? '+' : 'X';
    }

    // Coloca una pieza usando el siguiente jugador automático
    public void colocarPieza(int x, int y) {
        char jugador = obtenerSiguienteJugador();
        colocarPieza(x, y, jugador);
    }

    // Coloca una pieza especificando el jugador (útil para pruebas)
    public void colocarPieza(int x, int y, char jugador) {
        if (x < 0 || x > 2) throw new IllegalArgumentException("Eje X fuera de rango");
        if (y < 0 || y > 2) throw new IllegalArgumentException("Eje Y fuera de rango");
        if (tablero[y][x] != '\0') throw new IllegalStateException("Posición ya ocupada");
        tablero[y][x] = jugador;
        ultimoJugador = jugador;
    }

    // Devuelve el ganador ('X' o '+') o null si no hay ganador
    public Character obtenerGanador() {
        // filas
        for (int r = 0; r < 3; r++) {
            if (tablero[r][0] != 0 && tablero[r][0] == tablero[r][1] && tablero[r][1] == tablero[r][2]) {
                return tablero[r][0];
            }
        }
        // columnas
        for (int c = 0; c < 3; c++) {
            if (tablero[0][c] != 0 && tablero[0][c] == tablero[1][c] && tablero[1][c] == tablero[2][c]) {
                return tablero[0][c];
            }
        }
        // diagonales
        if (tablero[0][0] != 0 && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) return tablero[0][0];
        if (tablero[0][2] != 0 && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) return tablero[0][2];
        return null;
    }

    // Método auxiliar para consultar una casilla (valida índices)
    public char obtenerCasilla(int x, int y) {
        if (x < 0 || x > 2) throw new IllegalArgumentException("Eje X fuera de rango");
        if (y < 0 || y > 2) throw new IllegalArgumentException("Eje Y fuera de rango");
        return tablero[y][x];
    }

    // Fase TDD: REFACTOR (aquí se podrían hacer mejoras manteniendo tests verdes)
}
