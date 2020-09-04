package piezas;

import java.util.ArrayList;









import constantes.Constantes;
import movimientos.Movimiento;
import tableros.TableroAjedrez;
import vista.mapper.claves.ClaveEnumCompuesta;
import Juego.Escaque;
import Juego.util.Posicion;

public class Caballo extends Pieza {

	
	public Caballo(boolean blanco,Posicion pos , TableroAjedrez t)// ,...
	{
		this.blanca=blanco;
		this.pos=pos;
		this.tableroAjedrez=t;
		
		this.tipo=TipoFicha.CABALLO;
	}
	
	public Caballo(boolean blanco,Posicion pos , TableroAjedrez t,int id)// ,...
	{
		this(blanco,pos,t);
		this.id=id;
	}
	
	
	
	@Override
	public ArrayList<Movimiento> movimientos()
	{
		ArrayList<Movimiento> a= new ArrayList<Movimiento>();
		if(tableroAjedrez==null)
		{
			System.err.println("Error tablero");
			return null;
		}
		else
		{
			
			int x= this.damePosicion().getX();
			int y= this.damePosicion().getY();
			
			//System.out.println("POsicion " + x +"," +y);
			int i, j;
			
			 
			i=x+1;	j=y+2;		crearMov( a, i,  j);
			i=x+1;	j=y-2;		crearMov( a, i,  j);			
			
			i=x+2;	j=y+1;		crearMov( a, i,  j);
			i=x+2; 	j=y-1;		crearMov( a, i,  j);
			
			i=x-1; 	j=y+2;		crearMov( a, i,  j);
			i=x-1; 	j=y-2;		crearMov( a, i,  j);
			
			i=x-2; 	j=y+1;		crearMov( a, i,  j);
			i=x-2; 	j=y-1;		crearMov( a, i,  j);
		}
			
			
			return a;
	}

	/*
	public String toString()
	{
		//return new String("C");
		String s= "Caballo";
		s+= blanca;
		s+= pos.toString();
		return s;
	}
	*/
	@Override
	public char getSigla() {
	
		return 'C';
	}

	public Object clone(TableroAjedrez t)
	{
		Caballo a = new Caballo(blanca,pos,t,id);
		a.setJ(j);
		return a;
	}

	@Override
	public String nombre() {
		// TODO Auto-generated method stub
		return Constantes.CABALLO;
	}

	
	@Override
	public ClaveEnumCompuesta dameClave() 
	{
		if(blanca) 	return ClaveEnumCompuesta.CABALLO_BLANCO;
		else 		return ClaveEnumCompuesta.CABALLO_NEGRO;
	}
	
	
	
	
	@Override
	public int dameValor() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	public static void main(String args [])
	{
		
		Posicion p = new Posicion(2,2);
		Tablero t = new Tablero();
		Caballo r = new Caballo(true, p,t); 
		
		
		for(Movimiento m: r.movimientos())
		{
			System.out.println(m.toString());
		}
		
		//r.mover();
	}*/
	
	
	
	/* mover antes
	 * 
	 /*
			 i =x-1 ;
			 j= y+2;
			if(t.dameEscaque(i, j)!=null) a.add(new Movimiento(t.dameEscaque(i, j),true));
			
			i=x+1;
			if(t.dameEscaque(i, j)!=null)a.add(new Movimiento(t.dameEscaque(i, j),true));
			
			
			j=y+1;
			i=x-2;
			if(t.dameEscaque(i, j)!=null)a.add(new Movimiento(t.dameEscaque(i, j),true));
				
			i=x+2;
			if(t.dameEscaque(i, j)!=null)a.add(new Movimiento(t.dameEscaque(i, j),true));
			
				
				 i =x-1 ;
				 j= y-2;
				if(t.dameEscaque(i, j)!=null)a.add(new Movimiento(t.dameEscaque(i, j),true));
				
				i=x+1;
				if(t.dameEscaque(i, j)!=null)a.add(new Movimiento(t.dameEscaque(i, j),true));
				
				
				j=y-1;
				i=x-2;
				if(t.dameEscaque(i, j)!=null)a.add(new Movimiento(t.dameEscaque(i, j),true));
					
				i=x+2;
				if(t.dameEscaque(i, j)!=null)	a.add(new Movimiento(t.dameEscaque(i, j),true));
					
					
					
				///hacia los aldos
				
				*/
	
	
	/* mov largo:
	 public ArrayList<Movimiento> movimientos()
	{
		ArrayList<Movimiento> a= new ArrayList<Movimiento>();
		if(t==null)
		{
			System.err.println("Error tablero");
			return null;
		}
		else
		{
			
			int x= this.damePosicion().getX();
			int y= this.damePosicion().getY();
			
			System.out.println("POsicion " + x +"," +y);
			int i, j;
			
			i=x+1; j = y+2;
			if(t.dameEscaque(i, j)!=null) 
			{
				//System.out.println(i +"," +j); 
				if(!t.dameEscaque(i, j).estaOcupado())
					a.add(new Movimiento(t.dameEscaque(i, j),false));
				else if(t.damePieza(i, j).blanca!=blanca)
					a.add(new Movimiento(t.dameEscaque(i, j),true));
			}
			
			
			 x= this.damePosicion().getX();
			 y= this.damePosicion().getY();
			
			
			i=x+1; j = y-2;
			if(t.dameEscaque(i, j)!=null) 
			{
				//System.out.println(i +"," +j);
				if(!t.dameEscaque(i, j).estaOcupado())
					a.add(new Movimiento(t.dameEscaque(i, j),false));
				else if(t.damePieza(i, j).blanca!=blanca)
					a.add(new Movimiento(t.dameEscaque(i, j),true));
			}
			
			x= this.damePosicion().getX();
			 y= this.damePosicion().getY();
			
			i=x+2; j = y+1;
			if(t.dameEscaque(i, j)!=null) 
			{
				//System.out.println(i +"," +j);
				if(!t.dameEscaque(i, j).estaOcupado())
					a.add(new Movimiento(t.dameEscaque(i, j),false));
				else if(t.damePieza(i, j).blanca!=blanca)
					a.add(new Movimiento(t.dameEscaque(i, j),true));
			}
			
			x= this.damePosicion().getX();
			 y= this.damePosicion().getY();
			
			i=x+2; j = y-1;
			if(t.dameEscaque(i, j)!=null) 
			{
				//System.out.println(i +"," +j);
				if(!t.dameEscaque(i, j).estaOcupado())
					a.add(new Movimiento(t.dameEscaque(i, j),false));
				else if(t.damePieza(i, j).blanca!=blanca)
					a.add(new Movimiento(t.dameEscaque(i, j),true));
			}
			
			
			x= this.damePosicion().getX();
			 y= this.damePosicion().getY();
			
			i=x-1; j = y+2;
			if(t.dameEscaque(i, j)!=null) 
			{
				//System.out.println(i +"," +j);
				if(!t.dameEscaque(i, j).estaOcupado())
					a.add(new Movimiento(t.dameEscaque(i, j),false));
				else if(t.damePieza(i, j).blanca!=blanca)
					a.add(new Movimiento(t.dameEscaque(i, j),true));
			}
			
			
			x= this.damePosicion().getX();
			 y= this.damePosicion().getY();
			
			i=x-1; j = y-2;
			if(t.dameEscaque(i, j)!=null) 
			{
				//System.out.println(i +"," +j);
				if(!t.dameEscaque(i, j).estaOcupado())
					a.add(new Movimiento(t.dameEscaque(i, j),false));
				else if(t.damePieza(i, j).blanca!=blanca)
					a.add(new Movimiento(t.dameEscaque(i, j),true));
			}
			
			x= this.damePosicion().getX();
			 y= this.damePosicion().getY();
			
			i=x-2; j = y+1;
			if(t.dameEscaque(i, j)!=null) 
			{
				
				//System.out.println(i +"," +j);
				if(!t.dameEscaque(i, j).estaOcupado())
					a.add(new Movimiento(t.dameEscaque(i, j),false));
				else if(t.damePieza(i, j).blanca!=blanca)
					a.add(new Movimiento(t.dameEscaque(i, j),true));
			}
			
			x= this.damePosicion().getX();
			 y= this.damePosicion().getY();
			
			i=x-2; j = y-1;
				if(t.dameEscaque(i, j)!=null) 
				{
					//System.out.println(i +"," +j);
					if(!t.dameEscaque(i, j).estaOcupado())
						a.add(new Movimiento(t.dameEscaque(i, j),false));
					else if(t.damePieza(i, j).blanca!=blanca)
						a.add(new Movimiento(t.dameEscaque(i, j),true));
				}
			
			
								
				
			
		}
			
			
			return a;
	}
	 */
	
}
