package piezas;

import java.util.ArrayList;
import java.util.Vector;

import constantes.Constantes;
import movimientos.Movimiento;
import tableros.TableroAjedrez;
import vista.mapper.claves.ClaveEnumCompuesta;
import Juego.util.Posicion;

public class Alfil extends Pieza
{

	
	public Alfil(boolean blanco,Posicion pos , TableroAjedrez t)// ,...
	{
		this.blanca=blanco;
		this.pos=pos;
		this.tableroAjedrez=t;
		
		this.tipo=TipoFicha.ALFIL;
	}
	
	public Alfil(boolean blanco,Posicion pos , TableroAjedrez t,int id)// ,...
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
			
					
			//hacia ARRIBA Y DERECHA
			for(int i=1;i<8;i++)  // 7 u 8????
			{
				int m= x+i;
				int n= y+i;
				
				if(m >=0 && m < 8 && n >=0 && n<8)
				{
					if(crearMov(a,m,n))break;
				}
				else break;
				/*if(m >=0 && m < 8 && n >=0 && n<8)
				{
					if(t.dameEscaque(m, n).estaOcupado())
					{
						if(t.damePieza(m, n).blanca != blanca)
						a.add(new Movimiento(t.dameEscaque(m, n),true));
						break;
					}
					else a.add(new Movimiento(t.dameEscaque(m, n),false));
				}
				else break;*/
				
			}
			
			//hacia ABAJO Y DERECHA
			for(int i=1;i<8;i++)  
			{
				int m= x+i;
				int n= y-i;
				
				if(m >=0 && m < 8 && n >=0 && n<8)
				{
					if(crearMov(a,m,n))break;
				}
				else break;
				
			}
			
			//hacia  ARRIBA E IZQUIERDA
			for(int i=1;i<8;i++)  
			{
				
				int m= x-i;
				int n= y+i;
				
				if(m >=0 && m < 8 && n >=0 && n<8)
				{
					if(crearMov(a,m,n))break;
				}
				else break;
				
			}
			
			//hacia ABAJO E IZQUIERDA
			for(int i=1;i<8;i++)  
			{
				
				int m= x-i;
				int n= y-i;
				
				if(m >=0 && m < 8 && n >=0 && n<8)
				{
					if(crearMov(a,m,n))break;
				}
				else break;
				
			}
			
			
		}	
			
			
		
		
		return a;
	}


	@Override
	public char getSigla() {
	
		return 'A';
	}
	
	
	public Object clone(TableroAjedrez t)
	{
		Alfil a = new Alfil(blanca,pos,t,id);
		a.setJ(j);
		return a;
		
		
	}

	@Override
	public String nombre() {
		
		return Constantes.ALFIL;
	}

	@Override
	public ClaveEnumCompuesta dameClave() 
	{
		if(blanca) 	return ClaveEnumCompuesta.ALFIL_BLANCO;
		else 		return ClaveEnumCompuesta.ALFIL_NEGRO;
	}

	@Override
	public int dameValor() {
		// TODO Auto-generated method stub
		return 2;
	}

	
	/*
	public String toString()
	{
		//return new String("A");
		String s= "Alfil";
		s+= blanca;
		s+= pos.toString();
		return s;
	}
	*/
	
	/*public static void main(String args [])
	{
		
		Posicion p = new Posicion(1,1);
		TableroAjedrez t = new TableroAjedrez(true);
		Alfil r = new Alfil(true, p,t); 
		
		
		for(Movimiento m: r.movimientos())
		{
			System.out.println(m.toString());
		}
	}*/
	/*
	
	public Alfil(boolean blanco,int x,int y)
	{
		this.poscionActualY=y;
		this.posicionActualX=x;
		this.blanca=blanco;
		this.isViva=true;
	}
	
	
	
	@Override
	public  posiblesMov(Tablero t) {
		// TODO Auto-generated method stub
		if(t==null)
		{
			System.err.println("Error tablero");
			return null;
		}
		else
		{
		Vector<Casilla> mov= new Vector<Casilla>();
		for(int i=0;this.posicionActualX+i<8 && this.poscionActualY-i>0;i++)
		{
			mov.add(new Casilla(this.posicionActualX+i,this.getPoscionActualY()+i));//if(this.getPoscionActualY()<7)
			mov.add(new Casilla(this.posicionActualX+i,this.getPoscionActualY()-i));//if(this.getPoscionActualY()>=0)
			mov.add(new Casilla(this.posicionActualX-i,this.getPoscionActualY()+i));
			mov.add(new Casilla(this.posicionActualX-i,this.getPoscionActualY()-i));
		}	
			
		this.posiblesMovimientos=mov;
		
		
		
		return mov;
		}
	}
/*
	@Override
	public boolean isAlfil()
	{
		return true;
	}/////
*/
	/*
	@Override
	public TipoFicha getTipo() {
		// TODO Auto-generated method stub
		return null;
	}
	*/

	
	/*
	 * public ArrayList<Movimiento> movimientos() 
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
			
					
			//hacia ARRIBA Y DERECHA
			for(int i=1;i<8;i++)  // 7 u 8????
			{
				int m= x+i;
				int n= y+i;
				
				if(m >=0 && m < 8 && n >=0 && n<8)
				{
					if(t.dameEscaque(m, n).estaOcupado())
					{
						if(t.damePieza(m, n).blanca != blanca)
						a.add(new Movimiento(t.dameEscaque(m, n),true));break;
					}
					else a.add(new Movimiento(t.dameEscaque(m, n),false));
				}
				else break;
				
			}
			
			//hacia ABAJO Y DERECHA
			for(int i=1;i<8;i++)  
			{
				int m= x+i;
				int n= y-i;
				
				if(m >=0 && m < 8 && n >=0 && n<8)
				{
					if(t.dameEscaque(m, n).estaOcupado())
					{
						if(t.damePieza(m, n).blanca != blanca)
						a.add(new Movimiento(t.dameEscaque(m, n),true));break;
					}
					else a.add(new Movimiento(t.dameEscaque(m, n),false));
				}
				else break;
				
			}
			
			//hacia  ARRIBA E IZQUIERDA
			for(int i=1;i<8;i++)  
			{
				
				int m= x-i;
				int n= y+i;
				
				if(m >=0 && m < 8 && n >=0 && n<8)
				{
					if(t.dameEscaque(m, n).estaOcupado())
					{
						if(t.damePieza(m, n).blanca != blanca)
						a.add(new Movimiento(t.dameEscaque(m, n),true));break;
					}
					else a.add(new Movimiento(t.dameEscaque(m, n),false));
				}
				else break;
				
			}
			
			//hacia ABAJO E IZQUIERDA
			for(int i=1;i<8;i++)  
			{
				
				int m= x-i;
				int n= y-i;
				
				if(m >=0 && m < 8 && n >=0 && n<8)
				{
					if(t.dameEscaque(m, n).estaOcupado())
					{
						if(t.damePieza(m, n).blanca != blanca)
						a.add(new Movimiento(t.dameEscaque(m, n),true));break;
					}
					else a.add(new Movimiento(t.dameEscaque(m, n),false));
				}
				else break;
				
			}
			
			
		}	
			
			
		
		
		return a;
	}
	 */
}
