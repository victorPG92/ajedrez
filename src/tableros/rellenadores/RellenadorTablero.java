package tableros.rellenadores;

import Juego.util.Posicion;
import damas.Dama;
import piezas.Pieza;
import piezas.TipoFicha;
import piezas.fact.FactPiezas;
import tableros.Tablero;

public interface RellenadorTablero<T extends Tablero> {

	public default void rellena(T t)
	{
		creaPiezas(t);
		t.cogerPiezas();

	}
	
	void creaPiezas(T t);

}
