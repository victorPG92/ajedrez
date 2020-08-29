package Juego.tableros;

import java.util.ArrayList;

import Juego.Escaque;
import Juego.util.Posicion;
import constantes.Constantes;
import piezas.Pieza;

public class TableroCuadrado extends Tablero {

	protected Escaque[][] casillas;
	
	

	/**
	 * Crea las listas de las piezas, todas, las negras y las blancas
	 * a partir de las peias colocadas en el tablero
	 */
	public  void cogerPiezas()
	{
		piezas = new ArrayList<Pieza>();
		piezasBlancas= new ArrayList<Pieza>();
		piezasNegras= new ArrayList<Pieza>();
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
			{
				Pieza p= damePieza(i, j);
				if(p != null)
				{
					piezas.add(p);
					if(p.isBlanca())piezasBlancas.add(p);
					else 			piezasNegras.add(p);
					
				}
			}
	}
	
	

	public Escaque dameEscaque(int i, int j)
	{
		if(i>=0 && i< Constantes.TAM && j>=0 && j< Constantes.TAM)
			return casillas[i][j]; //dado la vuelta
		else return null;
	}
	
	public boolean estaOcupada(int i, int j)
	{
		if(dameEscaque(i,j)==null) return true;
		return dameEscaque(i,j).estaOcupado();
	}
	
	public Pieza damePieza(int i, int j)
	{
		if(dameEscaque(i,j)==null) return null;
		return dameEscaque(i,j).damePieza();
	}
	
	public Escaque dameEscaque(Posicion p)
	{
		return dameEscaque(p.getX(),p.getY());
	}
	
	public boolean estaOcupada(Posicion p)
	{
		return estaOcupada(p.getX(),p.getY());
	}
	
	public Pieza damePieza(Posicion p)
	{
		return damePieza(p.getX(),p.getY());
	}
	
	
	public void quitarPieza(int i, int j)
	{
		if(dameEscaque(i,j)!=null)
			dameEscaque(i,j).quitaPieza();
	}
	public void quitarPieza(Posicion p)
	{
		quitarPieza(p.getX(),p.getY());
	}
	
	public Pieza extraePieza(int i, int j)
	{
		if(dameEscaque(i,j)==null)  return null;
		else 						return dameEscaque(i,j).extraePieza();
	}
	public Pieza extraePieza(Posicion p)
	{
		return extraePieza(p.getX(),p.getY());
	}
	
	
	/**
	 * Usado para la carga de un fichero
	 * se vaica el tablero y luego se meten las peizas
	 * CUIDADO,  porque borra
	 * la funcion cogerPiezas() vacia las listas
	 * aqiu solo vaciamos el tablero en si, sus escaques
	 */
	public void vaciarTablero()
	{
		for(int i=0;i<Constantes.TAM;i++)
			for(int j=0;j<Constantes.TAM;j++)
				casillas[i][j].quitaPieza();
		
	}
}
