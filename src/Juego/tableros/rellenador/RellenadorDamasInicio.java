package Juego.tableros.rellenador;

import Juego.tableros.TableroDamas;
import Juego.util.Posicion;
import damas.Dama;

public class RellenadorDamasInicio implements RellenadorTablero<TableroDamas>{

	@Override
	public void creaPiezas(TableroDamas t) 
	{	
		
		for(int i :  new int[]{0,1,6,7})
			for(int j=0;j<8;j++)
			{
				 		
				Posicion pos= new Posicion(i,j);
				
				//t.dameEscaque(pos).setPieza(FactPiezas.getInst().creaPieza(TipoFicha.D,true,pos,t));
				
				t.dameEscaque(pos).setPieza(new Dama(true,pos,t));
				
			}	
		
	
		t.cogerPiezas();
	}
	
}


