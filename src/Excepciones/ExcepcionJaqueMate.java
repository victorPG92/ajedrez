package Excepciones;

import constantes.Mensajes;

public class ExcepcionJaqueMate extends Exception
{
	
	public ExcepcionJaqueMate(String message)
	{
		super(message);
	}
	
	public ExcepcionJaqueMate()
	{
		super(Mensajes.JAQUE_MATE);
	}

}
