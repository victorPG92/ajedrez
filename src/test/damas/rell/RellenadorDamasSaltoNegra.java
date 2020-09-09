package test.damas.rell;

import Juego.util.Posicion;
import damas.Dama;
import piezas.Pieza;
import tableros.TableroDamas;
import tableros.rellenadores.RellenadorPruebaPieza;

public class RellenadorDamasSaltoNegra implements RellenadorPruebaPieza<TableroDamas>{

	Pieza pieza;
	@Override
	public void creaPiezas(TableroDamas t) 
	{	
		t.dameEscaque(new Posicion(3,2)).setPieza(new Dama(true,new Posicion(3,2),t));
		t.dameEscaque(new Posicion(5,4)).setPieza(new Dama(true,new Posicion(5,4),t));
		pieza=new Dama(false,new Posicion(6,5),t);
		t.dameEscaque(new Posicion(6,5)).setPieza(pieza);

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
	
	public Pieza getPiezaObservada()
	{
		return pieza;
	}
	
	@Override
	public Posicion[] getMovimientoElegido() {
		return Posicion.creaPosiciones(4,3,2,1);
	}
}


