package test;

import org.junit.Assert;

import entidad.Casilla;
import junit.framework.TestCase;
import modelo.TableroBuscaminas;

public class TableroBuscaminasTest extends TestCase {

	public void testInicializacionTablero() {

		TableroBuscaminas tablero = new TableroBuscaminas(5, 5, 5);
		Assert.assertNotNull("El tablero debe inicializarse correctamente.", tablero);
	}

	public void testCantidadMinasGeneradas() {
		int numFilas = 5;
		int numColumnas = 5;
		int numMinas = 5;
		TableroBuscaminas tablero = new TableroBuscaminas(numFilas, numColumnas, numMinas);

		// Contar el número de minas generadas
		int minasContadas = 0;
		for (int i = 0; i < numFilas; i++) {
			for (int j = 0; j < numColumnas; j++) {
				if (tablero.getCasillas()[i][j].isMina()) {
					minasContadas++;
				}
			}
		}

		assertEquals(numMinas, minasContadas);
	}

	public void testObtenerCasillasAlrededor() {
		TableroBuscaminas tablero = new TableroBuscaminas(3, 3, 0);

		// Verificar las casillas alrededor de una posición central
		var casillasAlrededor = tablero.obtenerCasillasAlrededor(1, 1);
		assertEquals(8, casillasAlrededor.size());

		// Verificar las casillas alrededor de una esquina
		var casillasEsquina = tablero.obtenerCasillasAlrededor(0, 0);
		assertEquals(3, casillasEsquina.size());
	}

	public void testNumeroMinasAlrededor() {
		TableroBuscaminas tablero = new TableroBuscaminas(3, 3, 1);

		// Verificar el número de minas alrededor de una casilla
		int filaMina = -1, columnaMina = -1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tablero.getCasillas()[i][j].isMina()) {
					filaMina = i;
					columnaMina = j;
				}
			}
		}

		assertTrue("Debe haber una mina en el tablero.", -1 != filaMina);

		// Verificar casillas alrededor
		for (int i = Math.max(0, filaMina - 1); i <= Math.min(2, filaMina + 1); i++) {
			for (int j = Math.max(0, columnaMina - 1); j <= Math.min(2, columnaMina + 1); j++) {
				if (i != filaMina || j != columnaMina) { // Excepto la casilla de la mina
					assertEquals("El número de minas alrededor debe ser 1.", 1,
							tablero.getCasillas()[i][j].getNumMinasAlrededor());
				}
			}
		}
	}

	public void testIncrementarNumeroMinasAlrededor() {
		Casilla casilla = new Casilla(2, 2);

		assertEquals("Inicialmente, el número de minas alrededor debería ser 0.", 0, casilla.getNumMinasAlrededor());
		casilla.incrementarNumeroMinasAlrededor();
		assertEquals("El número de minas alrededor debería incrementarse a 1.", 1, casilla.getNumMinasAlrededor());
		casilla.incrementarNumeroMinasAlrededor();
		assertEquals("El número de minas alrededor debería incrementarse a 2.", 2, casilla.getNumMinasAlrededor());
	}

}
