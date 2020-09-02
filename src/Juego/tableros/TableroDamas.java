package Juego.tableros;

import Juego.Escaque;
import Juego.movimientos.Movimiento;
import Juego.movimientos.MovimientoEncadenado;
import Juego.util.Posicion;
import piezas.Pieza;

public class TableroDamas extends TableroAjedrez
{
	public TableroDamas() {
		super();
		
	}

	/**
	 * En las damas a un escaque se puede ir si :
	 * no esta ocupado
	 * y si entra en el rango del tablero
	 * @param esc
	 * @return
	 */
	public boolean sePuedeir(Posicion pos)
	{
		//dame escaque no lanza excepcion y si se sale del tablero devuelve null.
		Escaque esc= dameEscaque(pos);
		return sePuedeir(esc);
	}
	
	public boolean sePuedeir(Escaque esc)
	{
		//no se puede ir porque no existe
		if(esc==null)
			return false;
		
		return
			!esc.estaOcupado();
	}

	@Override
	protected void moverComerPiezas(Movimiento m) {
		
		//System.out.println("comer piezas damas");

		//en el movimiento encadenado, se comen piezas saltando, por lo que la casilla destino, es diferente a la de la pieza comida
		if(m instanceof MovimientoEncadenado)
		{
		//	System.out.println("es mov enc");
			MovimientoEncadenado movEnc= (MovimientoEncadenado) m;
			Escaque escDest= null;
			System.out.println("mov enc");
			while(movEnc!=null)
			{
				System.out.println(movEnc);
				Pieza piezaAmover= movEnc.getPieza();
				if(escDest!=null)
					escDest.quitaPieza();
				
				escDest=movEnc.getEsqDest();
				escDest.recibirPieza(piezaAmover, false);
				
				Pieza piezaComida=movEnc.getPiezaComida();
			
				if(piezaComida==null)System.err.println("null comida");
				dameEscaque(piezaComida.
						getPos()).
				quitaPieza();
				
				movEnc= movEnc.getMovSig();
			}
			System.out.println("fin");
			
		}
		else super.moverComerPiezas(m);
		
	}
}
