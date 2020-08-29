package Excepciones;


import constantes.Mensajes;

public class ExcepcionMovimientoNoPermitidoPorDejarEnJaque extends Exception 
{

	

	public ExcepcionMovimientoNoPermitidoPorDejarEnJaque(String message)
	{
		super(message);
	}
	
	public ExcepcionMovimientoNoPermitidoPorDejarEnJaque()
	{
		super(Mensajes.ERROR_MOVIMIENTO_NO_PERMITIDO);
	}
}
