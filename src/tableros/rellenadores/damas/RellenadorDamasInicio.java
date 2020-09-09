package tableros.rellenadores.damas;

import Juego.Escaque;
import Juego.util.Posicion;
import damas.Dama;
import tableros.TableroDamas;
import tableros.rellenadores.RellenadorTablero;

public class RellenadorDamasInicio implements RellenadorTablero<TableroDamas>{

	@Override
	public void creaPiezas(TableroDamas t) 
	{	
		
		for(int i :  new int[]{0,1,2,5,6,7})
			for(int j=0;j<8;j++)
			{
				 		
				Posicion pos= new Posicion(i,j);
				
				//t.dameEscaque(pos).setPieza(FactPiezas.getInst().creaPieza(TipoFicha.D,true,pos,t));
				Escaque esq=t.dameEscaque(pos);
				if(!esq.isBlanca())
					esq.setPieza(new Dama(i<3,pos,t));
				
			}	
		
	
		t.cogerPiezas();
	}
	
}


