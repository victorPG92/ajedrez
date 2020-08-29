package Juego;

import Juego.util.Posicion;
import piezas.Pieza;

/**
 * Clase que representa la casilla de un talbero de ajedrez
 * @author v
 *
 */
public class Escaque
{

	private Pieza pieza;
	private Posicion pos; // servira de identificador
	
	
	private boolean peligraBlanca;
	private boolean peligraNegra;
	
	
	//antes no estaba
	private boolean isBlanca;
	
	//private int fila;
	//private int columna;
	
	
	public Object clone()
	{
		Escaque e= new Escaque(pos,isBlanca); //(Pieza)pieza.clone()
		e.peligraBlanca=this.peligraBlanca;
		e.peligraNegra=this.peligraNegra;
		
		return e;
	}
	
	
	public Escaque(Posicion po , boolean blanca )
	{
		pos=po;
		
		isBlanca=blanca;
	}
	
	public Escaque(Posicion po, Pieza p , boolean blanca)
	{
		pos=po;
		this.pieza=p;
		isBlanca=blanca;
	}
	
	
	public boolean estaOcupado()
	{
		return pieza!=null;
	}
	
	public Pieza damePieza()
	{
		return pieza;
	}
	
	public void quitaPieza()
	{
		pieza = null;
	}
	
	public Pieza extraePieza()
	{
		Pieza p= damePieza();
		quitaPieza();
		return p;
	}
	
	/**
	 * 
	 * @param p
	 * @param comer: existen piezas que al llegar a la casilla, no comen, y si hay otra, no pueden moverse ahi :->peon
	 */
	public void recibirPieza(Pieza p, boolean comer)
	{
		
		//System.out.println("En esta casilla " + this +" hay " + pieza +" y meto " + p);
	
		/*
		if(pieza!=null)
			pieza.morir();
		*/
		
		pieza=p;
		if(pieza!=null)
		{
			pieza.setPos(pos);
			pieza.setMovida(true);
		}
		/*
		if(this.pieza==null)  pieza=p;    //mover  
		
		else  //comer y eliminr la otra ficha; 
		{
			
			Pieza paux= this.pieza;
			pieza=p; //la ficha que actualmente está es la que viene
			
			paux.morir();
			
			
			//si fiera peon, las relgas cambian
		*/
		
	}
	
	/**
	 * Usado al cargar la pieza, unciamente se debe usar ene se caso
	 */
	public void setPieza(Pieza p)
	{
		pieza=p;
	}
		
		
		
		
		
	
	
	public boolean isBlanca() {		return isBlanca;	}

	public void setBlanca(boolean isBlanca) {		this.isBlanca = isBlanca;	}

	//indica si la casilla es peligrosa para el jgador con piezas blancas(o negras)
	public boolean esPeligrosa(boolean blanca)
	{
		if(blanca ) return peligraBlanca;
		else 		return peligraNegra;
	}
	
	//indica si la casilla es peligrosa para el jgador con piezas blancas(o negras)
		public void marcarPeligrosa(boolean blanca)
		{
			if(blanca )  peligraBlanca =true;
			else 		 peligraNegra=true;
			
		}
	
	//una pieza avisa a esta casilla de que en el siguiente turno, si pone aqui, la ficha sera comida
		public void avisarDePeligro()
		{
			
			
		}
	
	
	
	public void vaciarPeligros()
	{
		
	}
	
	
	
	
	public String toString()
	{
		return pos.toString();
		
		
		
	}
	
	public int  compareTo(Object o)
	{
		  Escaque e= (Escaque)o;
		  if(pos.getX() < e.pos.getX()) return -1;	
		  else if(pos.getX() > e.pos.getX()) return 1;	
		  else
		  {
			  if(pos.getY() < e.pos.getY()) return -1;	
			  else if(pos.getY() > e.pos.getY()) return 1;
			  
		  }
		  return 0;
		  
	}
	
	public boolean equals(Object o)
	{
		return this.compareTo(o)==0;
	}

	public Posicion getPos() {		return pos;	}

	public void setPos(Posicion pos) {		this.pos = pos;	}
	
	
	
}
