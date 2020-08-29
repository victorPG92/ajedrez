package Juego.util;

public class Posicion
{
	
	private int x;//Letra
	private int y;
	
	public Posicion(int i, int j)
	{
		x=i; y=j;
		
	}
	
	public Posicion(Posicion pos)
	{
		x= pos.x;
		y= pos.y;
	}
	
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Posicion(int i, char c)
	{
		x=i; 
		if(c=='a' || c=='A') y=1;
		else if(c=='b' || c=='B') y=2;
		else if(c=='c' || c=='C') y=3;
		else if(c=='d' || c=='D') y=4;
		else if(c=='e' || c=='E') y=5;
		else if(c=='f' || c=='F') y=6;
		else if(c=='g' || c=='G') y=7;
		
	}
	
	public String toString()
	{
		//return Letra.get(x).toString() +" "+ y ;
		return x +" "+ y ;
		
	}
	
	public boolean equals(Object o)
	{
		Posicion p = (Posicion)o;
		return(x== p.x && y == p.y);
	}
	
	public void addVector(int dx, int dy)
	{
		x+=dx;
		y+=dy;
		
	}
	
	public Posicion addAnotherVector(int dx, int dy)
	{
		Posicion pos= new Posicion(this);
		
		pos.addVector(dx, dy);
		
		return pos;
		
	}
	
	public Posicion clone()
	{
		return new Posicion(x, y);
	}

}

/*
 *  a b c d ...
 * 4
 * 3
 * 2
 * 1 blancas
 */