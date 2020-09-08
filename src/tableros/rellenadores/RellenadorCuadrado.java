package tableros.rellenadores;

import Juego.util.Posicion;
import damas.Dama;
import piezas.Pieza;
import piezas.TipoFicha;
import piezas.fact.FactPiezas;
import tableros.TableroAjedrez;
import tableros.TableroCuadrado;
import vista.tablero.TableroCreado;

public abstract class RellenadorCuadrado<T extends TableroAjedrez> implements RellenadorTablero<T>
{

	

	public Pieza creaPiezaYRellena(T t,int i, int j,boolean blanca,TipoFicha ficha )
	{
		Posicion pos= new Posicion(i,j);
		Pieza p=FactPiezas.getInst().creaPieza(ficha,true,pos,t);
		t.dameEscaque(pos).setPieza(p);
		//t.dameEscaque(0, 0).setPieza(new Dama(true, new Posicion(0, 0), t).setEsReina(true));
		
		return p;
	}

}
