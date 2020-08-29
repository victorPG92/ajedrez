package Juego.tableros;

import Juego.Escaque;
import Juego.util.Posicion;

public class TableroDamas extends TableroAjedrez
{
	public TableroDamas(boolean crears) {
		super(crears);
		// TODO Auto-generated constructor stub
	}

	/**
	 * En las damas a un escaque se puede ir si :
	 * no esta ocupado
	 * y si entra en el rango del tablero
	 * @param esc
	 * @return
	 */
	public boolean sePuedeir(Posicion pos)
	{
		//dame escaque no lanza excepcion y si se sale del tablero devuelve null.
		Escaque esc= dameEscaque(pos);
		return sePuedeir(esc);
	}
	
	public boolean sePuedeir(Escaque esc)
	{
		//no se puede ir porque no existe
		if(esc==null)
			return false;
		
		return
			esc.estaOcupado();
	}

}
