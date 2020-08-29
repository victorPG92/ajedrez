package Excepciones;

import constantes.Mensajes;

public class ExcepcionPiezaSinMovimientos extends Exception {
	
	public ExcepcionPiezaSinMovimientos(String msg)
	{
		super(msg);
	}
	
	public ExcepcionPiezaSinMovimientos()
	{
		super(Mensajes.ERROR_PIEZA_SIN_MOVIMIENTOS);
	}

}
