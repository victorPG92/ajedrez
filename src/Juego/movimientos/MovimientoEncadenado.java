package Juego.movimientos;

import Juego.Escaque;

/**
 * Encadena movimientos para las damas 
 * @author victor
 *
 */
public class MovimientoEncadenado extends Movimiento{

	
	MovimientoEncadenado movSig;
	
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
