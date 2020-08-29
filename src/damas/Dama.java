package damas;

import java.util.ArrayList;
import java.util.List;

import Juego.movimientos.Movimiento;
import Juego.movimientos.MovimientoEncadenado;
import Juego.tableros.Tablero;
import Juego.tableros.TableroAjedrez;
import Juego.tableros.TableroDamas;
import Juego.util.Posicion;
import piezas.Pieza;
import vista.mapper.claves.ClaveEnumCompuesta;

public class Dama extends Pieza{

	
	
	
	boolean esReina;//o pieza a parte
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
	public ArrayList<Movimiento> movimientos() 
	{
		List<Movimiento> movs= new ArrayList<>();
		
		Posicion posActual= getPos();
		int avance= isBlanca()?1:-1;
		Posicion posDiagonIzqda= posActual.addAnotherVector(-1, avance);
		Posicion posDiagonDcha= posActual.addAnotherVector(1, avance);
		
		if(tableroAjedrez.estaOcupada(posDiagonIzqda))
			
		else
		Movimiento mov1= new Movimiento(this,posDiagonIzqda , c);
		Movimiento mov2= new Movimiento(this,posDiagonDcha , c);

		return movs;
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
	
	public MovimientoEncadenado crearMovComerSalto(Posicion pos, boolean izqda)
	{
		
	}
	
	
	
	@Override
	public List<Movimiento> getMovimientosComer(Posicion posActual) 
	{
	
		int avance= isBlanca()?1:-1;
		Posicion posDiagonIzqda= posActual.addAnotherVector(-1, avance);
		Posicion posDiagonDcha= posActual.addAnotherVector(1, avance);
		
		Movimiento mov1= new Movimiento(this, , c);
		return null;
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
