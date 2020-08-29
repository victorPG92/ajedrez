package Excepciones;

import constantes.Mensajes;

public class ExcepcionNoPieza extends Exception{
	
	
	public ExcepcionNoPieza(String message)
	{
		super(message);
	}
	
	public ExcepcionNoPieza()
	{
		super(Mensajes.ERROR_CASILLA_VACIA);
	}

}
