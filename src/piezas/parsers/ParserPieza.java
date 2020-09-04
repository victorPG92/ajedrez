package piezas.parsers;

import Juego.Juego;
import Juego.JuegoAjedrez;
import Juego.Jugador;
import Juego.util.Posicion;
import piezas.Pieza;
import piezas.TipoFicha;
import piezas.fact.FactPiezas;
import tableros.TableroAjedrez;

public class ParserPieza// extends Parser<Pieza>
{
	FactPiezas fp;
	
	public ParserPieza()
	{
		super();
		fp= FactPiezas.getInst();
		fp.reiniciarCont();
	}

	

	
	public Pieza damePieza(String linea,Posicion pos,TableroAjedrez t,Juego j)
	{
		Pieza p=null;
		
		try{
		if(!linea.equalsIgnoreCase("----"))
		{
			TipoFicha tf=TipoFicha.parse(linea.charAt(0));
			boolean isBlanca=Character.isUpperCase(linea.charAt(0));
			Jugador jug=isBlanca?j.getJ1():j.getJ2();
			
			int numDig=2;
			int id=Integer.valueOf(linea.substring(1,2));
			
			
			p=fp.creaPieza(tf, isBlanca, pos, t, id);
			p.setJ(jug);
			p.setMovida(linea.charAt(3)=='M');
			
			
		}
		}catch(Exception e ){return null;}
		return p;
	}
	
	

}
