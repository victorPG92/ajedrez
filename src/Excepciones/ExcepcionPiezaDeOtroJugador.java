package Excepciones;

import constantes.Mensajes;

public class ExcepcionPiezaDeOtroJugador extends Exception{
	
	
	public ExcepcionPiezaDeOtroJugador(String message)
	{
		super(message);
	}
	
	public ExcepcionPiezaDeOtroJugador()
	{
		super(Mensajes.ERROR_PIEZA_CONTRARIA);
	}
	

}
