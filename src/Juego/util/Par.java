package Juego.util;

public class Par implements Comparable
{
	
	private int a;
	private int b;
	
	public Par(int a, int b)
	{
		this.a=a;
		this.b=b;
		
	}
	
	
	public int getA() {
		return a;
	}


	public void setA(int a) {
		this.a = a;
	}


	public int getB() {
		return b;
	}


	public void setB(int b) {
		this.b = b;
	}


	public String toString()
	{
		return new String("( " + a +" , " + b + " )  ");
	}


	@Override
	public int compareTo(Object o) 
	{
		Par p =(Par)o;
		if(a < p.a) return -1;
		else if(a > p.a)return 1;
		else
		{
			if(b < p.b) return -1;
			else if(b > p.b)return 1;
		}
		return 0;
	}
	
	
	

}
