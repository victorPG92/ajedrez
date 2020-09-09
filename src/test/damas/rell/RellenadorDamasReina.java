package test.damas.rell;

import Juego.util.Posicion;
import damas.Dama;
import tableros.TableroDamas;
import tableros.rellenadores.RellenadorTablero;

public class RellenadorDamasReina implements RellenadorTablero<TableroDamas>{

	boolean mismoColor=false;
	int numPiezas= 3;
	
	boolean limitarMovs=true;
	@Override
	public void creaPiezas(TableroDamas t) 
	{
		
		if(limitarMovs)
			t.dameEscaque(0, 0).setPieza(new Dama(true, new Posicion(0, 0), t).setEsReina(true));
		else
			t.dameEscaque(2, 2).setPieza(new Dama(true, new Posicion(2, 2), t).setEsReina(true));

		t.dameEscaque(4, 4).setPieza(new Dama(mismoColor, new Posicion(4, 4), t));

		if(numPiezas==3)
			t.dameEscaque(6, 6).setPieza(new Dama(mismoColor, new Posicion(6, 6), t));
		
		if(numPiezas==4)
			t.dameEscaque(7, 7).setPieza(new Dama(mismoColor, new Posicion(7, 7), t));
		
	}

}
