package Juego.extractor;

import Juego.Jugador;
import piezas.Pieza;
import tableros.TableroAjedrez;

public interface ExtractorPiezas 
{
	//private Jugador j1;
	//private Jugador j2;
	
	public void extraerPiezas(TableroAjedrez t, Jugador j1, Jugador j2);

	
	public default void asociaPieza(Jugador jug, Pieza p)
	{
		jug.getMisPiezas().add(p);
		p.setJ(jug);
	}
}
