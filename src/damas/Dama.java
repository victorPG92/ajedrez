package damas;

import java.util.ArrayList;
import java.util.List;

import Juego.Escaque;
import Juego.movimientos.Movimiento;
import Juego.movimientos.MovimientoEncadenado;
import Juego.tableros.Tablero;
import Juego.tableros.TableroAjedrez;
import Juego.tableros.TableroDamas;
import Juego.util.Posicion;
import piezas.Pieza;
import vista.mapper.claves.ClaveEnumCompuesta;

public class Dama extends Pieza{

	
	
	
	boolean esReina;//o pieza a parte , se puede reutilizar con un bucle for para recorrer diagonal
	
	
	public Dama(boolean b, Posicion pos, TableroDamas t) 
	{
		this.blanca=b;
		this.pos=pos;
		this.tableroAjedrez=t;
	}

	@Override
	public char getSigla() {
		return 0;
	}

	@Override
	public List<Movimiento> movimientos() 
	{
		List<Movimiento> movs= new ArrayList<>();
		
		movs.addAll(dameMovimientosDesde(tableroAjedrez.dameEscaque(pos)));
		
		/*
		Posicion posActual= getPos();
		int avance= isBlanca()?1:-1;
		Posicion posDiagonIzqda= posActual.addAnotherVector(-1, avance);
		Posicion posDiagonDcha= posActual.addAnotherVector(1, avance);
		
		if(tableroAjedrez.estaOcupada(posDiagonIzqda))
			
		else
		Movimiento mov1= new Movimiento(this,posDiagonIzqda , c);
		Movimiento mov2= new Movimiento(this,posDiagonDcha , c);
		 */
		return movs;
	}
	
	public List<Movimiento> dameMovimientosDesde(Escaque esc)
	{
		Escaque escIzqda=dameEscaqueDiagonal(esc, true, 1);
		Escaque escDcha=dameEscaqueDiagonal(esc, true, 1);
		
		
	}
	public List<Movimiento> dameMovimientosDesdeHaciaSimpleYEncadenados(Escaque esc, boolean izqda)
	{
		
		List<Movimiento> movs = new ArrayList<>();
		
		Escaque escIzqda=dameEscaqueDiagonal(esc, true, 1);
		Escaque escDcha=dameEscaqueDiagonal(esc, false, 1);
		
		
		if(escIzqda!=null)//si no se sale del tablero
		{
			//la casilla esta libre y no come, movimiento simple y se para ahi
			if(!escIzqda.estaOcupado())
			{
				movs.add(new Movimiento(this, escIzqda, false));
			}
			else
			{
				Escaque escIzqda2=dameEscaqueDiagonal(esc, true, 2);
				//Escaque escDcha2=dameEscaqueDiagonal(esc, false, 2);
				
				if(((TableroDamas)tableroAjedrez).sePuedeir(escIzqda2))//escIzqda2!==null && !escIzqda2.estaOcupado())
				{
					Pieza piezaComida= escIzqda.damePieza();
					//movimient despues de saltar 2: 
					MovimientoEncadenado movEncIzqda= new MovimientoEncadenado(this,escIzqda2, piezaComida);
					
					
					movEncIzqda.concatenaMov(movEnc);
				}
				movs.addAll(c);
			}
		}
		//codigo repetido, optimizar con parametro izqda
		if(escDcha!=null)
		{
			if(!escDcha.estaOcupado())
			{
				movs.add(new Movimiento(this, escDcha, false));
			}
			else
			{
				
			}
		}
		
		return movs;
	}
	
	
	
	public Escaque dameEscaqueDiagonal(Escaque esc, boolean izqda, int numAvance)
	{
		int avance= isBlanca()?1:-1;
		avance*= numAvance;
		int orientacion= izqda?-1:1;
		
		Posicion posDiagon1= esc.getPos().addAnotherVector(orientacion, avance);
		
		return tableroAjedrez.dameEscaque(posDiagon1);
	}
	
	/**
	 * crea un mov simple en diagonal, se mueve en 1
	 * @return
	 */
	public Movimiento crearMovSimple(Posicion pos, boolean izqda)
	{
		int avance= isBlanca()?1:-1;
		int orientacion= izqda?-1:1;
		
		Posicion posDiagon1= pos.addAnotherVector(orientacion, avance);
		
		if(tableroAjedrez.estaOcupada(posDiagon1))
			
		
		
	}
	
	
	
	/**
	 * crea un mov simple en diagonal, se mueve en 1
	 * @return
	 */
	public Movimiento crearMov(Posicion posAnt, Posicion posSig)
	{
		if(tableroAjedrez.estaOcupada(posSig))
		{
			return null;
		}
		else
		{
			return crearMovSimple(posAnt, posSig);
		}
			
		
		
	}
	
	public Movimiento crearMovSimple(Posicion posAnt, Posicion posSig)
	{
		return new Movimiento(this, tableroAjedrez.dameEscaque(posSig), false);
	}
	
	public MovimientoEncadenado crearMovComerSalto(Posicion posAnt, Posicion posSig)
	{
		MovimientoEncadenado movEnc = new MovimientoEncadenado()
		
		movEnc.setComer(true);
		movEnc.setPieza(this);
		movEnc.setEsqDest(tableroAjedrez.g);
				
		return movEnc;
	}
	
	
	
	@Override
	public List<Movimiento> getMovimientosComer(Escaque esc) 
	{
	
		List<Movimiento> movs= new ArrayList<>();
		
		//excepto que sea reina
		
		//la siguiente debe estar ocupada:
		int avance= isBlanca()?1:-1;
		
		//y las siguientes libres:
		int avance2= isBlanca()?2:-2;
		/*
		Posicion posDiagonIzqda= posActual.addAnotherVector(-1, avance);
		Posicion posDiagonDcha= posActual.addAnotherVector(1, avance);
		*/
		
		Escaque escIzqda= dameEscaqueDiagonal(esc, true, avance);
		Escaque escIzqda2= dameEscaqueDiagonal(esc, true, avance);
		MovimientoEncadenado mov1= new Movimiento(this, , c);
		
		
		return movs;
	}
	
	public List<MovimientoEncadenado> encadenaMov(MovimientoEncadenado movOrigen
			List<MovimientoEncadenado> movHijos)
	{
		
	}

	@Override
	public String nombre() {
		
		return "dama";
	}

	@Override
	public Object clone(TableroAjedrez t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClaveEnumCompuesta dameClave() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * Todas valen igual excepto si son reinas
	 */
	public int dameValor() {
		
		return 1;
	}

}
