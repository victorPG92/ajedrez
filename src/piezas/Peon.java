package piezas;

import java.util.ArrayList;

import constantes.Constantes;
import vista.mapper.claves.ClaveEnumCompuesta;
import Juego.Escaque;
import Juego.movimientos.Movimiento;
import Juego.tableros.TableroAjedrez;
import Juego.util.Posicion;

public class Peon extends Pieza
{
	
	public Peon(boolean blanco,Posicion pos ,TableroAjedrez tr )// ,...
	{
		this.blanca=blanco;
		this.pos=pos;
		tableroAjedrez=tr;
		
		this.tipo=TipoFicha.PEON;
	}
	
	public Peon(boolean blanco,Posicion pos , TableroAjedrez t,int id)// ,...
	{
		this(blanco,pos,t);
		this.id=id;
	}

	@Override
	public ArrayList<Movimiento> movimientos()
	{
		ArrayList<Movimiento> a= new ArrayList<Movimiento>();
		if(!vive()) return a;
		
		System.out.println(this.damePosicion());
		int x= this.damePosicion().getX();
		int y= this.damePosicion().getY();
		
		Escaque e=null;//inicialziada para el pointer exception
		
		if(!this.esMovida) //el peon se puede mover 2 si no ha sido movido previamente y si no hay pieza 
		{
			int posss=0;
			try{
				
			/* *******************salta excepcion ***********************************/
			if(this.blanca) 
			{
				posss=x+2;
				e = tableroAjedrez.dameEscaque(x+2,y);
				if(!e.estaOcupado())
					a.add(new Movimiento(this,e,false)); //x, y+2     y+2,x
			}
			else
			{
				posss=x-2;
				e = tableroAjedrez.dameEscaque(x-2,y);
				if(!e.estaOcupado())////////////////////////////////////
					a.add(new Movimiento(this,e,false)); //x, y-2	y-2,x
			}
			}
			catch(Exception exc)
			{
				throw new NullPointerException("casilla vacia error  en : "+posss+" "+ y+" escqaue "+e);
			}
		}
		
		//el peon se puede mover 1 hacia delante si no hay pieza 
		if(this.blanca)
		{
			e =this.tableroAjedrez.dameEscaque(x+1,y);
			if(!e.estaOcupado()) a.add(new Movimiento(this,e,false)); //x, y+1 	y+1,x
		}
		else
		{
			e = this.tableroAjedrez.dameEscaque(x-1,y);
			if(!e.estaOcupado()) a.add(new Movimiento(this,e,false)); //x, y-1	y-1,x
		}
			
		
		//el peon se puede mover 1 en diagonal  si hay pieza del otro jugador para comer
		Escaque e1, e2;
		if(this.blanca)
		{
			 e1 = this.tableroAjedrez.dameEscaque(x+1, y+1);  //y+1, x+1
			 e2 = this.tableroAjedrez.dameEscaque(x+1, y-1);   //y+1, x-1
		}
		else 
		{
			 e1 = this.tableroAjedrez.dameEscaque(x-1, y+1);  //y-1, x+1
			 e2 = this.tableroAjedrez.dameEscaque(x-1, y-1);  //y-1, x-1
		}
			
		if(e1 != null && e1.estaOcupado() && e1.damePieza().isBlanca()!=this.isBlanca())
			a.add(new Movimiento(this,e1, true));
		
		if(e2 != null && e2.estaOcupado() && e2.damePieza().isBlanca()!=this.isBlanca())
			a.add(new Movimiento(this,e2, true));
		
		return a;
	}
	
	/*
	public String toString()
	{
		//return new String("P");
		String s= "Peon ";
		s+= blanca +" ";
		s+= pos.toString();
		return s;
	}
*/
	
	@Override
	public char getSigla() {
	
		return 'P';
	}
	
	
	/*
	public static void main(String args [])
	{
		
		Posicion p = new Posicion(1,1);
		Tablero t = new Tablero();
		Peon r = new Peon(true, p,t); 
		
		
		for(Movimiento m: r.movimientos())
		{
			System.out.println(m.toString());
		}
	}*/

	public Object clone(TableroAjedrez t)
	{
		Peon a = new Peon(blanca,pos,t,id);
		a.setJ(j);
		return a;
	}

	@Override
	public String nombre() {
		// TODO Auto-generated method stub
		return Constantes.PEON;
	}
	
	

	@Override
	public ClaveEnumCompuesta dameClave() 
	{
		if(blanca) 	return ClaveEnumCompuesta.PEON_BLANCO;
		else 		return ClaveEnumCompuesta.PEON_NEGRO;
	}
	
	
	
	
	
	
	@Override
	public int dameValor() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * ArrayList<Movimiento> a= new ArrayList<Movimiento>();
		int x= this.damePosicion().getX();
		int y= this.damePosicion().getY();
		
		
		if(!this.esMovida) //el peon se puede mover 2 si no ha sido movido previamente y si no hay pieza 
			if(this.blanca) a.add(new Movimiento(this.t.dameEscaque(x+2,y),false)); //x, y+2     y+2,x
			else 			a.add(new Movimiento(this.t.dameEscaque(x-2,y),false)); //x, y-2	y-2,x
		
		//el peon se puede mover 1 hacia delante si no hay pieza 
		if(this.blanca) a.add(new Movimiento(this.t.dameEscaque(x+1,y),false)); //x, y+1 	y+1,x
		else 			a.add(new Movimiento(this.t.dameEscaque(x-1,y),false)); //x, y-1	y-1,x
			
		
		Escaque e1, e2;
		if(this.blanca)
		{
			 e1 = this.t.dameEscaque(x+1, y+1);  //y+1, x+1
			 e2 = this.t.dameEscaque(x+1, y-1);   //y+1, x-1
		}
		else 
		{
			 e1 = this.t.dameEscaque(x-1, y+1);  //y-1, x+1
			 e2 = this.t.dameEscaque(x-1, y-1);  //y-1, x-1
		}
			
		if(e1 != null && e1.estaOcupado() && e1.damePieza().isBlanca()!=this.isBlanca())
			a.add(new Movimiento(e1, true));
		
		if(e2 != null && e2.estaOcupado() && e2.damePieza().isBlanca()!=this.isBlanca())
			a.add(new Movimiento(e2, true));
		
		return a;
	 */
	
}
