package movimientos;

import java.util.ArrayList;
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
	
	public boolean sigueCaminoEnDestino(List<Escaque> escques,  boolean exacto)
	{
		List<Escaque> escsMov = getListEscaques();
		if(exacto) // compara toda la lista
			return escsMov.equals(escques);
		else
		{
			int min= Math.min(escques.size(),escsMov.size());
			return escques.subList(0, min).equals(escsMov.subList(0, min));
			/*
			for (int i = 0; i < min; i++) 
			{
				
			}*/
		}
		//return sigueCaminoEnDestino(escques, 0, exacto);
	}
	
	
	public boolean sigueCaminoEnDestino2(List<Escaque> escques,  boolean exacto)
	{
		return sigueCaminoEnDestino(escques, 0, exacto);
	}
		
	public boolean sigueCaminoEnDestino(List<Escaque> escques, int ind, boolean exacto)
	{
		if(ind>=escques.size())//if(escques.isEmpty() )
		{
			if(!exacto || movSig==null)
				return true;
			else return false;
		}
		else
		{
			
			Escaque esqPrimer= escques.get(ind);
			boolean igualPrimerElem=dest.equals(esqPrimer);  //coincide

			if(movSig !=null)
				return igualPrimerElem && movSig.sigueCaminoEnDestino(escques,ind+1,exacto);
			else
			{
				if(ind< escques.size()-1)
					return false;
				else
					return  igualPrimerElem;   
			}
		}
	}
	@Override
	public int getValor() {
		int valorSig= movSig==null?0: movSig.getValor();
		return valorSig + super.getValor();
	}
	
	
	
	@Override
	public Escaque getEsqDest() {
	
			return super.getEsqDest();
	}
	

	public Escaque getLastEsqDest() {
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
	
	
	public int numMovs()
	{
		if(movSig==null) return 1;
		else return 1+ movSig.numMovs();
	}
	
	
	public List<Escaque> getListEscaques()
	{
		List<Escaque> escs= new ArrayList<>();
		
		return getListEscaques(escs);
	}

	private List<Escaque> getListEscaques(List<Escaque> escs) {
		escs.add(dest);
		if(movSig==null)
			return escs;
		else
			return movSig.getListEscaques(escs);
	}
	
	@Override
	public String toString() {
		return super.toString() + getListEscaques();
	}
}
