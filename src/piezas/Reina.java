package piezas;

import java.util.ArrayList;

import constantes.Constantes;
import vista.mapper.claves.ClaveEnumCompuesta;
import Juego.movimientos.Movimiento;
import Juego.tableros.TableroAjedrez;
import Juego.util.Posicion;

public class Reina extends Pieza {

	public Reina(boolean blanco,Posicion pos , TableroAjedrez t)// ,...
	{
		this.blanca=blanco;
		this.pos=pos;
		this.tableroAjedrez=t;
		
		this.tipo=TipoFicha.REINA;
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
			if(!vive()){	System.err.println(this + "esta muerta");		return a;}
			
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
		// TODO Auto-generated method stub
		return 'Q';//'R';
	}

	public Object clone(TableroAjedrez t)
	{
		Reina a = new Reina(blanca,pos,t);
		a.setJ(j);
		return a;
		
		
	}

	@Override
	public String nombre() {
		// TODO Auto-generated method stub
		return Constantes.REINA;
	}
	
	
	
	
	
	@Override
	public ClaveEnumCompuesta dameClave() 
	{
		if(blanca) 	return ClaveEnumCompuesta.REINA_BLANCO;
		else 		return ClaveEnumCompuesta.REINA_NEGRO;
	}
	
	@Override
	public int dameValor() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	
	
	
	
	
	
	
	
	/*mal movim
	 * //hacia ARRIBA Y DERECHA
			for(int i=0;i<7;i++)  // 7 u 8????
				//for(int j=x+1;j<7;j++)  // 7 u 8????
			{
				
				if(t.dameEscaque(x+i, y+i).estaOcupado())
				{
					a.add(new Movimiento(t.dameEscaque(j, i),true));
					break;
				}
				else a.add(new Movimiento(t.dameEscaque(j, i),false));
				
			}
			
			//hacia ABAJO Y DERECHA
			for(int i=y-1;i>=0;i--)
				//for(int j=x+1;j<7;j++)  // 7 u 8????
			{
				
				if(t.dameEscaque(j, i).estaOcupado())
				{
					a.add(new Movimiento(t.dameEscaque(j, i),true));break;
				}
				else a.add(new Movimiento(t.dameEscaque(j, i),false));
				
			}
			
			//hacia  ARRIBA E IZQUIERDA
			for(int i=x+1;i<8;i++) // 7 u 8??
				for(int j=x-1;j>=0;j--)  // 7 u 8????
				
			{
				
				if(t.dameEscaque(j, i).estaOcupado())
				{
					a.add(new Movimiento(t.dameEscaque(j, i),true));break;
				}
				else a.add(new Movimiento(t.dameEscaque(j, i),false));
				
			}
			
			//hacia ABAJO E IZQUIERDA
			for(int i=x-1;i>=0;i--)
				for(int j=x-1;j>=0;j--)  // 7 u 8????
			{
				
				if(t.dameEscaque(j, i).estaOcupado())
				{
					a.add(new Movimiento(t.dameEscaque(j, i),true));break;
				}
				else a.add(new Movimiento(t.dameEscaque(j, i),false));
				
			}
	 * 
	 */
	
	
	/*
	public String toString()
	{
		//return new String("R");
		String s= "Reina";
		s+= blanca;
		s+= pos.toString();
		return s;
	}
	*/
	
	/*
	public static void main(String args [])
	{
		
		Posicion p = new Posicion(1,1);
		TableroAjedrez t = new TableroAjedrez(true);
		Reina r = new Reina(true, p,t); 
		
		
		for(Movimiento m: r.movimientos())
		{
			System.out.println(m.toString());
		}
	}
*/
}
