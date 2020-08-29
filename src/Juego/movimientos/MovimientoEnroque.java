package Juego.movimientos;

import Juego.Escaque;
import Juego.util.Posicion;
import piezas.Pieza;
import piezas.Rey;
import piezas.Torre;

public class MovimientoEnroque extends Movimiento
{
	 
	
	/*
	public MovimientoEnroque() 
	{
		super();
		enroque=true;
	}
	public MovimientoEnroque(Pieza pieza, Escaque e, boolean c)
	{
		super(pieza, e, c);
		rey=(Rey) pieza;
		enroque=true;
		
	}
	*/
	public MovimientoEnroque(Pieza r, Escaque posDestR, boolean c,Torre t,Posicion posT,Escaque posFuturaT,Escaque posFuturaR)
	{
		super(r, posDestR, c);
		rey=(Rey) r;
		torre=t;
		
		posTorre=posT;
		posFuturaTorre=posFuturaT;
		
		posRey=r.damePosicion();
		posFuturaRey=posFuturaR;
		
		setEnroque(true);
		
	}
	
	public MovimientoEnroque(Rey r, Torre t,Escaque posFuturaT,Escaque posFuturaR)
	{
		super();
		rey= r;
		torre=t;
		
		posTorre=t.damePosicion();
		posFuturaTorre=posFuturaT;
		
		posRey=r.damePosicion();
		posFuturaRey=posFuturaR;
		
		setEnroque(true);
		
		dest= posFuturaR;
		
	}
	
	
	private Rey rey;
	private Torre torre;
	
	private Posicion posTorre;
	private Escaque posFuturaTorre;
	
	private Posicion posRey;
	private Escaque posFuturaRey;
	
	public Rey getRey() {
		return rey;
	}
	public void setRey(Rey rey) {
		this.rey = rey;
	}
	public Torre getTorre() {
		return torre;
	}
	public void setTorre(Torre torre) {
		this.torre = torre;
	}
	public Posicion getPosTorre() {
		return posTorre;
	}
	public void setPosTorre(Posicion posTorre) {
		this.posTorre = posTorre;
	}
	public Escaque getPosFuturaTorre() {
		return posFuturaTorre;
	}
	public void setPosFuturaTorre(Escaque posFuturaTorre) {
		this.posFuturaTorre = posFuturaTorre;
	}
	public Posicion getPosRey() {
		return posRey;
	}
	public void setPosRey(Posicion posRey) {
		this.posRey = posRey;
	}
	public Escaque getPosFuturaRey() {
		return posFuturaRey;
	}
	public void setPosFuturaRey(Escaque posFuturaRey) {
		this.posFuturaRey = posFuturaRey;
	}
	
	public String toString()
	{	
		return "ENROQUE "+rey + " y  "+  torre ;
		
		
	}
	
	
	
	
	
}
