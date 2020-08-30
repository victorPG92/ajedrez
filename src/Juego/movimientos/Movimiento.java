package Juego.movimientos;

import piezas.Pieza;
import Juego.Escaque;
import Juego.util.Posicion;
import entradaSalida.SalidaDatosVentana;

public class Movimiento 
{
	 
	//protected Tablero t;
	protected Posicion ori;
	protected Escaque dest;
	protected boolean comer;
	protected Pieza pieza; // pieza que movemos;
	
	protected Pieza piezaComida; // pieza que movemos;
	
	protected int valor;
	protected boolean quitaJaque;
	
	protected boolean movidaAntes;
	
	private boolean enroque=false;
	
	public Movimiento() {
		super();
	}


	public Movimiento(Pieza pieza,Escaque escDest, boolean c)
	{
		setPieza(pieza);
		this.dest=escDest;
		comer=c;
		
		
		
		//if(comer && e.damePieza()==null)	SalidaDatosVentana.mostrarError( e.toString() +" "+ c); 
		
		if(comer && escDest.estaOcupado()) //damePieza()!=null
			valor = escDest.damePieza().dameValor();
		
	}

	
	public Escaque getEsqDest() {		return dest;	}
	public void setEsqDest(Escaque e)
	{		
		this.dest = e;
		if(e==null)
			piezaComida=null;// asignacion inutil
		else
			piezaComida=e.damePieza();
	}

	public boolean isComer() {		return comer;	}
	public void setComer(boolean comer) {		this.comer = comer;	}

	
	
	public Pieza getPieza() {	return pieza;}
	public void setPieza(Pieza pieza)
	{	
		this.pieza = pieza;
		ori=pieza.damePosicion();
		movidaAntes=pieza.fueMovida();
	}


	
	
	public boolean equals(Object o)
	{
		Movimiento m = (Movimiento)o;
		
		return m.getEsqDest().equals(dest) && m.comer==comer;
		
	}


	public Posicion damePosOrigen() {	return ori;	}


	public Pieza getPiezaComida() {		return piezaComida;}


	public boolean habiaSidoMovidaAntesdeEsteMov() {	return movidaAntes;	}


	public void setFueMovida(boolean primeraVez) {		this.movidaAntes = primeraVez;	}
	
	
	public String toString()
	{	
		String s=pieza +" desde "+ ori+ " hasta " +dest.toString() +"movida  "+movidaAntes;
		if(comer)s+="comiendo a " + piezaComida;
		return s;
	}


	public void setPiezaComida(Pieza piezaComida) {
		this.piezaComida = piezaComida;
	}


	public boolean isEnroque() {
		return enroque;
	}


	public void setEnroque(boolean enroque) {
		this.enroque = enroque;
	}
	
	public int getValor()
	{
		return valor;
	}
	
}
