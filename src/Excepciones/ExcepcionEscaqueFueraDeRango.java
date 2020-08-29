package Excepciones;

import constantes.Mensajes;

public class ExcepcionEscaqueFueraDeRango extends Exception
{
	
	public ExcepcionEscaqueFueraDeRango(String message)
	{
		super(message);
	}
	
	public ExcepcionEscaqueFueraDeRango()
	{
		super(Mensajes.ERROR_POSICION_FUERA_TABLERO);
	}

}
