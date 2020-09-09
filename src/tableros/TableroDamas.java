package tableros;

import Juego.Escaque;
import Juego.util.Posicion;
import damas.Dama;
import movimientos.Movimiento;
import movimientos.MovimientoEncadenado;
import piezas.Pieza;

public class TableroDamas extends TableroAjedrez
{
	public TableroDamas() {
		super();
		
	}

	@Override
	public boolean sePuedeir(Escaque esc, boolean color) {
		
		return sePuedeir(esc);
	}
	
	@Override
	public boolean sePuedeir(Posicion pos, boolean color) {
		return sePuedeir(pos);
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
			System.out.println("mov enc " + movEnc.numMovs());
			while(movEnc!=null)
			{
				System.out.println(movEnc);
				Pieza piezaAmover= movEnc.getPieza();
				if(escDest!=null)
				{
					escDest.quitaPieza();
					System.out.println("quitando pieza de " + escDest);
				}
				
				escDest=movEnc.getEsqDest();System.out.println("metiendo pieza en " + escDest);
				escDest.recibirPieza(piezaAmover, false);
				
				
				Pieza piezaComida=movEnc.getPiezaComida();
			
				if(piezaComida.getJ()!=null)
					piezaComida.getJ().getMisPiezas().remove(piezaComida);
				
				if(piezaComida==null)System.err.println("null comida");
				dameEscaque(piezaComida.
						getPos()).
				quitaPieza();
				
				movEnc= movEnc.getMovSig();
			}
			System.out.println("fin");
			
		}
		else super.moverComerPiezas(m);
		
		promocionarADama(m);
		
	}
	
	protected void promocionarADama(Movimiento m)//Dama dama)
	{
		Dama dama= (Dama) m.getPieza();
		System.err.println("viendo promocion"+dama.isBlanca()+ " "+dama.getPos().getY());
		
		int fila=dama.getPos().getX();
		if(
				(dama.isBlanca()&& fila== NUM_COL-1)
			||	(!dama.isBlanca()&& fila== 0))
		{
			dama.setEsReina(true);
			m.setPromociona(true);
		}
	}
}
