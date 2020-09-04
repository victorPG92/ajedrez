package piezas;

import java.util.ArrayList;

import constantes.Constantes;
import movimientos.Movimiento;
import tableros.TableroAjedrez;
import vista.mapper.claves.ClaveEnumCompuesta;
import Juego.util.Posicion;

public class Torre extends PiezaEnrocable
{

	public Torre(boolean blanco,Posicion pos ,TableroAjedrez tr)// ,...
	{
		this.blanca=blanco;
		this.pos=pos;
		tableroAjedrez=tr;
		
		this.tipo=TipoFicha.TORRE;
	}
	
	public Torre(boolean blanco,Posicion pos , TableroAjedrez t,int id)// ,...
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
			
		
		
			//hacia ARRIBA
			for(int i=y+1;i<8;i++)  // 7 u 8????
			{
				
				if(crearMov(a,x,i))break;
				
			}
			
			//hacia ABAJO
			for(int i=y-1;i>=0;i--)
			{
				
				if(crearMov(a,x,i))break;
				
			}
			
			//hacia DERECHA
			for(int i=x+1;i<8;i++) // 7 u 8??
			{
				
				if(crearMov(a,i,y))break;
				
			}
			
			//hacia IZQUIERDA
			for(int i=x-1;i>=0;i--)
			{
				if(crearMov(a,i,y))break;
				/*
				if(t.dameEscaque(i, y).estaOcupado())
				{
					a.add(new Movimiento(t.dameEscaque(i,y),true));
					break;
				}
				else a.add(new Movimiento(t.dameEscaque(i,y),false));
				*/
			}
			
			
		}	
			
		enroque(a)	;
		
		
		return a;
	}

	
	
	//el rey hace enroque con la torre, no al reves.
		public void enroque(ArrayList<Movimiento> m)
		{
			if(!esMovida)
			{
				Posicion pos = damePosicion();
				int x= pos.getX();
				int y = pos.getY();
				
				Pieza rey= tableroAjedrez.damePieza(x, 0);   //0, y
				if(rey!=null && rey.dameTipo().equals(TipoFicha.TORRE ) && !rey.esMovida && noPiezasEntreMedias(rey))
				{
					
					//casillas entre medias
				}
					
				
			}
			
		}
		
		public boolean noPiezasEntreMedias(Pieza rey)
		{
			boolean enrocable= true;
			
			int j = this.damePosicion().getX();
			int y = this.damePosicion().getY();
			if(j==Constantes.TAM-1)
			{
				for(int  i = rey.damePosicion().getX()+1;  i<j && enrocable;  i++)
					if(tableroAjedrez.estaOcupada(i, y))enrocable =false;
			}
			else if(j==0)
			{
				for(int  i = rey.damePosicion().getX() -1;  i>=0 && enrocable;  i--)
					if(tableroAjedrez.estaOcupada(i, y))enrocable =false;
			}
			
			return enrocable;
		}
		
	/*
	
	public String toString()
	{
		//return new String("T");
		String s= "Torre";
		s+= blanca;
		s+= pos.toString();
		return s;
	}
*/
	

	@Override
	public char getSigla() {
		// TODO Auto-generated method stub
		return 'T';
	}

	@Override
	public Object clone(TableroAjedrez t)
	{
		Torre a = new Torre(blanca,pos,t,id);
		a.setJ(j);
		return a;
		
		
	}

	@Override
	public String nombre() {
		// TODO Auto-generated method stub
		return Constantes.TORRE;
	}
	
	
	
	
	
	@Override
	public ClaveEnumCompuesta dameClave() 
	{
		if(blanca) 	return ClaveEnumCompuesta.TORRE_BLANCO;
		else 		return ClaveEnumCompuesta.TORRE_NEGRO;
	}
	
	
	
	
	
	
	@Override
	public int dameValor() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	
	
	/*
	
	public static void main(String args [])
	{
		
		Posicion p = new Posicion(1,1);
		Tablero t = new Tablero();
		Torre r = new Torre(true, p,t); 
		
		
		for(Movimiento m: r.movimientos())
		{
			System.out.println(m.toString());
		}
	}
	*/
	
	
	
	
	/*
	 * @Override
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
			
		
		
			//hacia DERECHA			ARRIBA
			for(int i=y+1;i<Constantes.TAM;i++)  // 7 u 8????
			{
				
				if(t.dameEscaque(x, i)!=null && t.dameEscaque(x, i).estaOcupado())
				{
					if(t.damePieza(x, i).blanca != blanca)
					a.add(new Movimiento(t.dameEscaque(x, i),true));
					break;
				}
				else a.add(new Movimiento(t.dameEscaque(x, i),false));
				
			}
			
			//hacia IZQUIERDA			ABAJO
			for(int i=y-1;i>=0;i--)
			{
				
				if(t.dameEscaque(x, i)!=null && t.dameEscaque(x, i).estaOcupado())
				{
					if(t.damePieza(x, i).blanca != blanca)
					a.add(new Movimiento(t.dameEscaque(x, i),true));break;
				}
				else a.add(new Movimiento(t.dameEscaque(x, i),false));
				
			}
			
			//hacia AABAJO			 DERECHA
			for(int i=x+1;i<Constantes.TAM;i++) // 7 u 8??
				
			{
				
				if(t.dameEscaque(x, i)!=null && t.dameEscaque(x, i).estaOcupado())
				{
					if(t.damePieza(x, i).blanca != blanca)
					a.add(new Movimiento(t.dameEscaque(x, i),true));break;
				}
				else a.add(new Movimiento(t.dameEscaque(x, i),false));
				
			}
			
			//hacia ARRIBA			IZQUIERDA
			for(int i=x-1;i>=0;i--)
			{
				
				if(t.dameEscaque(x, i)!=null && t.dameEscaque(x, i).estaOcupado())
				{
					if(t.damePieza(x, i).blanca != blanca)
					a.add(new Movimiento(t.dameEscaque(x, i),true));break;
				}
				else a.add(new Movimiento(t.dameEscaque(x, i),false));
				
			}
			
			
		}	
			
			
		
		
		return a;
	}
	 */
}
