package Juego.extractor;

import Juego.Jugador;
import piezas.Pieza;
import tableros.TableroAjedrez;

/**
 * Supone que el juego esta en la configuracion inicial
 * las blancas en las filas 0 y 1
 * y las negras en las filas 6 y 7
 * @author victor
 *
 */
public class ExtractorPiezasParcialInicio implements ExtractorPiezas
{

	@Override
	public void extraerPiezas(TableroAjedrez t, Jugador j1, Jugador j2) {
		
		for (int f : new int[] {0,1,6,7})
		{

			for (int i = 0; i < t.NUM_COL; i++)
			{
				Pieza p=t.damePieza(f, i);
				if(p!=null)
				{
					if(f<2 )
						j1.getMisPiezas().add(p);
					else
						j2.getMisPiezas().add(p);
				}
			}

		}	
		
	}
	

}
