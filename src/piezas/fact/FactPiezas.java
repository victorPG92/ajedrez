package piezas.fact;

import Juego.util.Posicion;
import piezas.Pieza;
import piezas.TipoFicha;
import tableros.TableroAjedrez;

public abstract class FactPiezas 
{
	
	private static FactPiezas inst;
	
	public static FactPiezas getInst()
	{
		if(inst==null) inst=new FactPiezasImp();
		return inst;
	}

	
	
	public abstract Pieza creaPieza(TipoFicha tf,boolean isBlanca, Posicion pos, TableroAjedrez t);
	public abstract Pieza creaPieza(TipoFicha tf,boolean isBlanca, Posicion pos, TableroAjedrez t,int id);
	
	public abstract Pieza clonarPieza(Pieza p,TableroAjedrez t);
	
	
	
	
	public abstract void reiniciarCont();
	
	
}
