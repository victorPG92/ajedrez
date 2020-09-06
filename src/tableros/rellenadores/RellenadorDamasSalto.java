package tableros.rellenadores;

import Juego.util.Posicion;
import damas.Dama;
import tableros.TableroDamas;

public class RellenadorDamasSalto implements RellenadorTablero<TableroDamas>{

	@Override
	public void creaPiezas(TableroDamas t) 
	{	
		
		t.dameEscaque(new Posicion(3,2)).setPieza(new Dama(true,new Posicion(3,2),t));
		t.dameEscaque(new Posicion(4,3)).setPieza(new Dama(false,new Posicion(4,3),t));
		t.dameEscaque(new Posicion(6,5)).setPieza(new Dama(false,new Posicion(6,5),t));

		/*
		for(int i :  new int[]{0,1,6,7})
			for(int j=0;j<8;j++)
			{
				 		
				Posicion pos= new Posicion(i,j);
				
				//t.dameEscaque(pos).setPieza(FactPiezas.getInst().creaPieza(TipoFicha.D,true,pos,t));
				
				t.dameEscaque(pos).setPieza(new Dama(i<2,pos,t));
				
			}	
		*/
	
		t.cogerPiezas();
	}
	
}


