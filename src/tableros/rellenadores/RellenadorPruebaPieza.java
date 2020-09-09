package tableros.rellenadores;

import Juego.util.Posicion;
import piezas.Pieza;
import tableros.Tablero;

/**
 * Al ser prueba, siempre hay una pieza observada, y otras alrededor
 * @author victor
 *
 * @param <T>
 */
public interface RellenadorPruebaPieza<T extends Tablero> extends RellenadorTablero<T>{

	public Pieza getPiezaObservada();

	public Posicion[] getMovimientoElegido();
}
