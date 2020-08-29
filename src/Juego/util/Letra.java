package Juego.util;

public enum Letra {

	A,B,C,D,E,F,G,H;
	
	public static Letra get(int i)
	{
		return  Letra.values()[i];
		
		//Letra.valueOf(arg0)
		
	}
	
	/*
	//@override
	public final boolean equals(Object o)
	{
		//((Letra)o).ordinal()
		return true;
		
	}*/
	
	
	public static void main(String args [])
	{
		System.out.println(Letra.get(0));
		
		System.out.println(Letra.get(6));
		
		
		//System.out.println(Letra.get(7));
		
		
	}
}
