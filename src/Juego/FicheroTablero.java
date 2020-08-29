package Juego;

import entradaSalida.ficheros.EscritorFichero;
import entradaSalida.ficheros.LectorFichero;

public class FicheroTablero
{
	JuegoAjedrez j;
	
	
	public FicheroTablero(JuegoAjedrez j) 
	{
		super();
		this.j = j;
	}


	public void guardaJuego(String nombre)
	{
		
		
		EscritorFichero esc= new EscritorFichero(nombre);
		//esc.escribeLinea(j.getD().toString());
		esc.escribeLinea(Boolean.toString(j.isTurno()));
		esc.escribeLinea(j.getT().toString());
		esc.escribeLinea(j.getMovimientosJugados().toString());
		
		esc.close();
	}
	
	/**
	 * ERROR , MEJOR QUE EL JUEGO SE CAMBIE , QUE CAMBIAR LAS REFERENCIAS
	 * @param nombre
	 * @return
	 * @deprecated
	 */
	public JuegoAjedrez cargaJuego(String nombre)
	{
		
		
		LectorFichero esc= new LectorFichero(nombre);
		//esc.escribeLinea(j.getD().toString());
		Boolean turno= Boolean.parseBoolean(esc.leeLinea());
		String linea;
		do
		{
			linea= esc.leeLinea();
			if(!linea.isEmpty())
			{
				
			}
		}while(!linea.isEmpty());
		
		//esc.escribeLinea(j.getMovimientosJugados().toString());
		
		esc.close();
		
		
		return null;
		
	}

}
