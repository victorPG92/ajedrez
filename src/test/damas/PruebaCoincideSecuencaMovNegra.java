package test.damas;

import java.util.List;

import Juego.Escaque;
import Juego.util.Posicion;
import damas.Dama;
import movimientos.MovimientoEncadenado;
import tableros.TableroDamas;

public class PruebaCoincideSecuencaMovNegra 
{
	static TableroDamas t= new TableroDamas();
	static Dama dama= new Dama(true, new Posicion(0,0), t);
	
	public static MovimientoEncadenado crea3Mov()
	{
		MovimientoEncadenado mov1= new MovimientoEncadenado(dama, t.dameEscaque(2,2), null);
		MovimientoEncadenado mov2= new MovimientoEncadenado(dama, t.dameEscaque(4,4), null);
		MovimientoEncadenado mov3= new MovimientoEncadenado(dama, t.dameEscaque(6,6), null);

		mov1.concatenaMov(mov2);
		mov1.concatenaMov(mov3);
		
		return mov1;
	}
	
	public static void main(String[] args) {
		MovimientoEncadenado m = crea3Mov();
		
		System.out.println(m.numMovs());
		
		System.out.println(m.getEsqDest());

		System.out.println(m.getLastEsqDest());


		List<Escaque> escques = List.of(t.dameEscaque(2,2), t.dameEscaque(4,4),t.dameEscaque(6,6));

		System.out.println(m.sigueCaminoEnDestino(escques,  true));
		System.out.println(m.sigueCaminoEnDestino(escques,  false));
		
		
		List<Escaque> escques1 = List.of(t.dameEscaque(2,2), t.dameEscaque(4,4));

		System.out.println(m.sigueCaminoEnDestino(escques1,  true));

		System.out.println(m.sigueCaminoEnDestino(escques1,  false));

	}

}
