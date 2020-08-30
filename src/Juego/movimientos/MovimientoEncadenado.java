package Juego.movimientos;

import Juego.Escaque;
import piezas.Pieza;

/**
 * Encadena movimientos para las damas 
 * @author victor
 *
 */
public class MovimientoEncadenado extends Movimiento{

	
	MovimientoEncadenado movSig;
	
	
	
	public MovimientoEncadenado(Pieza pieza, Escaque escDest, boolean c) {
		super(pieza, escDest, c);
	
	}
	
	public MovimientoEncadenado(Pieza piezaMovida, Escaque escDest, Pieza piezaComida) {
		this(piezaMovida, escDest, true);
		setPiezaComida(piezaComida);
	
	}

	public void concatenaMov(MovimientoEncadenado movEnc)
	{
		if(movSig==null)
			movSig= movEnc;
		else
			movSig.concatenaMov(movEnc);
			
	}
	
	@Override
	public int getValor() {
		int valorSig= movSig==null?0: movSig.getValor();
		return valorSig + super.getValor();
	}
	
	
	
	@Override
	public Escaque getEsqDest() {
		if(movSig==null)
			return super.getEsqDest();
		else
			return movSig.getEsqDest();
	}
	
	
	
}
