package tableros;

import java.util.List;
import java.util.List;


import piezas.Pieza;

public abstract class Tablero {


	protected List<Pieza> piezas;
	protected List<Pieza> piezasBlancas;
	protected List<Pieza> piezasNegras;
	
	
	public List<Pieza> getPiezas() {	return piezas;}

	public void setPiezas(List<Pieza> piezas) {	this.piezas = piezas;}

	public List<Pieza> getPiezas(boolean blanco)
	{
		if(blanco )	return getPiezasBlancas();
		else 		return	getPiezasNegras();	
	}
	
	public List<Pieza> getPiezasBlancas() {	return piezasBlancas;}
	public void setPiezasBlancas(List<Pieza> piezasBlancas) {	this.piezasBlancas = piezasBlancas;}

	public List<Pieza> getPiezasNegras() {	return piezasNegras;}
	public void setPiezasNegras(List<Pieza> piezasNegras) {	this.piezasNegras = piezasNegras;	}

	/**
	 * Crea las listas de las piezas, todas, las negras y las blancas
	 * a partir de las peias colocadas en el tablero
	 */
	public abstract void cogerPiezas() ;

}
