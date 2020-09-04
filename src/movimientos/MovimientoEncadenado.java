package movimientos;

import java.util.List;

import Juego.Escaque;
import piezas.Pieza;

/**
 * Encadena movimientos para las damas 
 * @author victor
 *
 */
public class MovimientoEncadenado extends Movimiento implements Cloneable{

	
	MovimientoEncadenado movSig;
	
	
	
	public MovimientoEncadenado(Pieza pieza, Escaque escDest, boolean c) {
		super(pieza, escDest, c);
	
	}
	
	public MovimientoEncadenado(Pieza piezaMovida, Escaque escDest, Pieza piezaComida) {
		this(piezaMovida, escDest, true);
		setPiezaComida(piezaComida);
	
	}

	public MovimientoEncadenado(MovimientoEncadenado movOrigen) {

		
	
	}

	public void concatenaMov(MovimientoEncadenado movEnc)
	{
		if(movSig==null)
			movSig= movEnc;
		else
			movSig.concatenaMov(movEnc);
			
	}
	/*
	public boolean sigueCaminoEnDestino(List<Escaque> escques)
	{
		if(escques.isEmpty())
			return true;
		else
		{
			Escaque esqPrimer= escques.remove(0);
			return dest.equals(esqPrimer) && movSig.sigueCaminoEnDestino(escques); 
		}
	}*/
	
	public boolean sigueCaminoEnDestino(List<Escaque> escques, int ind, boolean exacto)
	{
		if(escques.isEmpty() )
		{
			if(!exacto || movSig==null)
				return true;
			else return false;
		}
		else
		{
			if(ind>=escques.size())
				return false;
			
			Escaque esqPrimer= escques.get(ind);
			return dest.equals(esqPrimer) //coincide
					&& movSig !=null // omo la lista no es vacia, deberia haber mas movs 
					&& movSig.sigueCaminoEnDestino(escques,ind+1,exacto);  
		}
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
	
	@Override
	public Object clone() throws CloneNotSupportedException {
			MovimientoEncadenado clon= (MovimientoEncadenado) super.clone();
			if(this.movSig!=null)
				clon.movSig= (MovimientoEncadenado) this.movSig.clone();
			return clon;
	}

	public final MovimientoEncadenado getMovSig() {
		return movSig;
	}
	
	
	
	
	
}
