package Excepciones;

import constantes.Mensajes;

public class ExcepcionMovimientoNoPermitido extends Exception 
{

	

	public ExcepcionMovimientoNoPermitido(String message)
	{
		super(message);
	}
	
	public ExcepcionMovimientoNoPermitido()
	{
		super(Mensajes.ERROR_MOVIMIENTO_NO_PERMITIDO);
	}
}
