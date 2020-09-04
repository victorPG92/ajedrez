package test.damas;

import Juego.util.Posicion;
import damas.Dama;
import tableros.TableroDamas;
import tableros.rellenadores.RellenadorTablero;

public class RellenadorDamasPruebaComer implements RellenadorTablero<TableroDamas>{

	boolean mismoColor=false;
	int numPiezas= 3;
	@Override
	public void creaPiezas(TableroDamas t) {

		t.dameEscaque(2, 2).setPieza(new Dama(true, new Posicion(2, 2), t));
		t.dameEscaque(3, 3).setPieza(new Dama(mismoColor, new Posicion(3, 3), t));

		if(numPiezas==3)
			t.dameEscaque(5, 5).setPieza(new Dama(mismoColor, new Posicion(5, 5), t));
		
		if(numPiezas==4)
			t.dameEscaque(7, 7).setPieza(new Dama(mismoColor, new Posicion(7, 7), t));
		
	}

}
