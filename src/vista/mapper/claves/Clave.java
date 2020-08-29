package vista.mapper.claves;

import piezas.TipoFicha;

public class Clave  implements Comparable   //implements
{ 
	String tf; //private TipoFicha tf;
	private boolean blanco;
	private boolean fondo;
	
	
	public Clave(String tf,boolean blanco,boolean fondo)
	{
		
		 this.tf=tf;
		 this.blanco=blanco;
		 this.fondo=fondo;
	
		
	}
	
	@Override
	public boolean equals(Object o)
	{
		Clave c=(Clave)o;
		
		//if(c.tf.equalsIgnoreCase(this.tf)) System.out.println("Pieza " + c.tf);
		//if( c.blanco==this.blanco )
		//if( c.fondo==this.fondo)
		
		//return c.tf.equals(this.tf) && c.blanco==this.blanco && c.fondo==this.fondo;
		return (c.tf.equals(this.tf) || c.blanco==this.blanco || c.fondo==this.fondo);
	}
	
	@Override
	public int compareTo(Object o)
	{
		if(equals(o))return 0;
		else return -1;
	}
	
	public String toString()
	{
		return tf +" "+ blanco +" "+fondo; 
		
	}
	
	
}
