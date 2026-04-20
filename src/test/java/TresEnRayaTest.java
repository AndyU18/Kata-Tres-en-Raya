import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Fase TDD: RED (primero escribimos las pruebas)
public class TresEnRayaTest {

    // REQUERIMIENTO 1
    @Test
    public void colocarPieza_XFueraDeRango_lanzaExcepcion() {
        TresEnRaya juego = new TresEnRaya();
        assertThrows(IllegalArgumentException.class, () -> juego.colocarPieza(-1, 1, 'X'));
        assertThrows(IllegalArgumentException.class, () -> juego.colocarPieza(3, 1, 'X'));
    }

    @Test
    public void colocarPieza_YFueraDeRango_lanzaExcepcion() {
        TresEnRaya juego = new TresEnRaya();
        assertThrows(IllegalArgumentException.class, () -> juego.colocarPieza(1, -1, 'X'));
        assertThrows(IllegalArgumentException.class, () -> juego.colocarPieza(1, 3, 'X'));
    }

    @Test
    public void colocarPieza_PosicionOcupada_lanzaExcepcion() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarPieza(0, 0, 'X');
        assertThrows(IllegalStateException.class, () -> juego.colocarPieza(0, 0, '+'));
    }

    // REQUERIMIENTO 2
    @Test
    public void primerTurno_siNoHuboJugadas_esX() {
        TresEnRaya juego = new TresEnRaya();
        assertEquals('X', juego.obtenerSiguienteJugador());
    }

    @Test
    public void siUltimoFueX_siguienteEsMas() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarPieza(0, 0, 'X');
        assertEquals('+', juego.obtenerSiguienteJugador());
    }

    @Test
    public void siUltimoFueMas_siguienteEsX() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarPieza(0, 0, '+');
        assertEquals('X', juego.obtenerSiguienteJugador());
    }

    // REQUERIMIENTO 3
    @Test
    public void sinVictoria_noHayGanador() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarPieza(0, 0, 'X');
        juego.colocarPieza(1, 0, '+');
        juego.colocarPieza(2, 0, 'X');
        assertNull(juego.obtenerGanador());
    }

    @Test
    public void lineaHorizontal_completa_ganaJugador() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarPieza(0, 1, 'X');
        juego.colocarPieza(1, 1, 'X');
        juego.colocarPieza(2, 1, 'X');
        assertEquals(Character.valueOf('X'), juego.obtenerGanador());
    }

    @Test
    public void lineaVertical_completa_ganaJugador() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarPieza(2, 0, '+');
        juego.colocarPieza(2, 1, '+');
        juego.colocarPieza(2, 2, '+');
        assertEquals(Character.valueOf('+'), juego.obtenerGanador());
    }

    @Test
    public void diagonal_completa_ganaJugador() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarPieza(0, 0, 'X');
        juego.colocarPieza(1, 1, 'X');
        juego.colocarPieza(2, 2, 'X');
        assertEquals(Character.valueOf('X'), juego.obtenerGanador());
    }
}
