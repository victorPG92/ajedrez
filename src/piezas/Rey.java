package piezas;

import java.util.ArrayList;

import constantes.Constantes;
import movimientos.Movimiento;
import movimientos.MovimientoEnroque;
import tableros.TableroAjedrez;
import vista.mapper.claves.ClaveEnumCompuesta;
import Juego.Escaque;
import Juego.util.Posicion;

public class Rey extends PiezaEnrocable
{

	
	public Rey(boolean blanco,Posicion pos,TableroAjedrez tr)//...
	{
		this.blanca=blanco;
		this.pos=pos;
		tableroAjedrez=tr;
		this.tipo=TipoFicha.REY;
	}
	
	
	
	@Override
	public ArrayList<Movimiento> movimientos() 
	{
		
		ArrayList<Movimiento> a= new ArrayList<Movimiento>();
		int x= this.damePosicion().getX();
		int y= this.damePosicion().getY();
		
		
		
		
		int i,j;
		
		i=x-1;	j=y-1;	meterMov(a,i,j);
		i=x-1;	j=y;	meterMov(a,i,j);
		i=x-1;	j=y+1;	meterMov(a,i,j);
				
		i=x;	j=y-1;	meterMov(a,i,j);
		i=x;	j=y+1;	meterMov(a,i,j);
				
		i=x+1;	j=y-1;	meterMov(a,i,j);
		i=x+1;	j=y;	meterMov(a,i,j);
		i=x+1;	j=y+1;	meterMov(a,i,j);
		
		
		enroque(a);
		
		return a;
		
	}

	public void meterMov(	ArrayList<Movimiento> a,int i, int j )
	{
		Escaque e=tableroAjedrez.dameEscaque(i , j);	
		if(e!=null && !e.esPeligrosa(blanca))
		{
			if(!e.estaOcupado())a.add(new Movimiento(this,e,false));
			else if(e.damePieza().blanca!=blanca)a.add(new Movimiento(this, e,true));
		}
	}
	
	//el rey hace enroque con la torre, no al reves.
	public void enroque(ArrayList<Movimiento> m)
	{
		if(!esMovida)
		{
			Posicion pos = damePosicion();
			System.out.println("posicion del rey "+ pos);
			int x= pos.getX();
			System.out.println("x del rey "+ x);
			//int y = pos.getY();
			
			
			Pieza torre= tableroAjedrez.damePieza(x, 0);
			if(torre!=null && torre.dameTipo().equals(TipoFicha.TORRE ) && !torre.esMovida && noPiezasEntreMedias(torre))
				m.add(new MovimientoEnroque(this,(Torre)torre, tableroAjedrez.dameEscaque(x,2),tableroAjedrez.dameEscaque(x,1)));
				
			
			
			Pieza torre2= tableroAjedrez.damePieza(x,7 );
			if(torre2!=null && torre2.dameTipo().equals(TipoFicha.TORRE ) && !torre2.esMovida && noPiezasEntreMedias(torre2))
				m.add(new MovimientoEnroque(this,(Torre)torre2, tableroAjedrez.dameEscaque(x,5),tableroAjedrez.dameEscaque(x,6)));
			else
			{
				System.out.println(torre2);
				if(torre2!=null)
				{
				System.out.println(torre2.dameTipo().equals(TipoFicha.TORRE ));
				System.out.println(noPiezasEntreMedias(torre2));
				}
			}
			
			
			/*
			insertarEnroque( m, x, 0);
			insertarEnroque( m, x, 6);
			*/
			
		}
		
	}
	
	/*
	private void insertarEnroque(ArrayList<Movimiento> m,int x, int y)
	{
		Pieza torre= t.damePieza(x, 0);
		if(torre!=null && torre.dameTipo().equals(TipoFicha.TORRE ) && !torre.esMovida && noPiezasEntreMedias(torre))
		{
			//m.add(new Movimiento(this,t.dameEscaque(0,1), isBlanca()));
			m.add(new MovimientoEnroque(this,t.dameEscaque(x,y), false,(Torre)torre,torre.pos, t.dameEscaque(x,2),t.dameEscaque(x,1)));
			//casillas entre medias
		}
		
	}
	*/
	public boolean noPiezasEntreMedias(Pieza torre)
	{
		boolean enrocable= true;
		
		int miCol=damePosicion().getY();
		int miFila= damePosicion().getX();
		
		System.out.println("comprobar enroque de "+ this + " "+ this.getPos());
		System.out.println("torre "+torre);
		
		int f = torre.damePosicion().getX();
		int c = torre.damePosicion().getY();
		
		System.out.println("pos torre "+torre.damePosicion()+" fila "+f+", col"+c);
		
		if(c==0)//es torre izquierda
		{
			for(int  i = 1;  i<miCol && enrocable;  i++)
			{
				System.out.println(tableroAjedrez.dameEscaque(f,i));

				if(tableroAjedrez.estaOcupada(f,i))
				{					
					System.out.println("esta ocupado " +f+ " "+ i );

					enrocable =false;
				}
			}
		}

		else if(c==Constantes.TAM-1)// si es torre derecha
		{
			for(int i = miCol+1;  i<c && enrocable;  i++)
			{
				System.out.println(tableroAjedrez.dameEscaque(f,i));
				if(tableroAjedrez.estaOcupada(f,i))
				{
					enrocable =false; // i y
					System.out.println("esta ocupado " +f+ " "+ i);
				}	
			}
		}
				
		System.out.println("fin enrocar");
		System.out.println();
		
		return enrocable;
	}
	/*
	public boolean noPiezasEntreMedias(Pieza torre)
	{
		boolean enrocable= true;
		
		int x = torre.damePosicion().getX();
		int y = torre.damePosicion().getY();
		
		if(x==Constantes.TAM-1)// si es torre derecha
		{
			for(int  i = damePosicion().getX()+1;  i<x && enrocable;  i++)
				if(tableroAjedrez.estaOcupada(y,i))enrocable =false; // i y
		}
		else if(x==0)//es torre izquierda
		{
			for(int  i = damePosicion().getX() -1;  i>=0 && enrocable;  i--)
				if(tableroAjedrez.estaOcupada(y,i))enrocable =false;
		}
		
		return enrocable;
	}*/
	
	/*
	public String toString()
	{
		//return new String("r");
		String s= "Rey";
		s+= blanca;
		s+= pos.toString();
		return s;
	}
	*/
	//al mover, no puede ser a casillas prohibidas
	
	/*
	public static void main(String args [])
	{
		
		Posicion p = new Posicion(1,1);
		TableroAjedrez t = new TableroAjedrez(true);
		Rey r = new Rey(true, p,t); 
		
		
		for(Movimiento m: r.movimientos())
		{
			System.out.println(m.toString());
		}
	}
*/


	@Override
	public char getSigla() {	return 'K';/*'r';*/}


	public Object clone(TableroAjedrez t)
	{
		Rey a = new Rey(blanca,pos,t);
		a.setJ(j);
		return a;
		
		
	}



	@Override
	public String nombre() {

		return Constantes.REY;
	}
	
	
	
	@Override
	public ClaveEnumCompuesta dameClave() 
	{
		if(blanca) 	return ClaveEnumCompuesta.REY_BLANCO;
		else 		return ClaveEnumCompuesta.REY_NEGRO;
	}
	
	
	
	
	@Override
	public int dameValor() {

		return Integer.MAX_VALUE;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	Escaque e;
		int i,j;
		
		i=x-1;	j=y-1;
		i=x-1;	j=y;
		i=x-1;	j=y+1;
		e=t.dameEscaque(i , j);		if(!e.esPeligrosa(blanca))a.add(new Movimiento(e,false));
		e=t.dameEscaque(x-1 , y-1);		if(!e.esPeligrosa(blanca))a.add(new Movimiento(e,false));
		e=t.dameEscaque(x-1, y) ;		if(!e.esPeligrosa(blanca))a.add(new Movimiento(e,false));
		e=t.dameEscaque(x-1, y+1);		if(!e.esPeligrosa(blanca))a.add(new Movimiento(e,false));
		
		i=x;	j=y-1;
		i=x;	j=y+1;
		e=	t.dameEscaque(x, y-1);		if(!e.esPeligrosa(blanca))a.add(new Movimiento(e,false));
		e=	t.dameEscaque(x, y+1);		if(!e.esPeligrosa(blanca))a.add(new Movimiento(e,false));
		
		i=x+1;	j=y-1;
		i=x+1;	j=y;
		i=x+1;	j=y+1;
		e=	t.dameEscaque(x+1, y-1);		if(!e.esPeligrosa(blanca))a.add(new Movimiento(e,false));
		e=	t.dameEscaque(x+1, y);		if(!e.esPeligrosa(blanca))a.add(new Movimiento(e,false));
		e=	t.dameEscaque(x+1, y+1);		if(!e.esPeligrosa(blanca))a.add(new Movimiento(e,false));
	*/
}
