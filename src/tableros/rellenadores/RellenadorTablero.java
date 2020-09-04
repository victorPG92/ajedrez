package tableros.rellenadores;

import tableros.Tablero;

public interface RellenadorTablero<T extends Tablero> {

	public default void rellena(T t)
	{
		creaPiezas(t);
		t.cogerPiezas();

	}
	void creaPiezas(T t);

}
