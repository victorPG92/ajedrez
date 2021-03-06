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
public class ExtractorPiezasInicial implements ExtractorPiezas
{

	@Override
	public void extraerPiezas(TableroAjedrez t, Jugador j1, Jugador j2) {
		
		for (int j = 0; j < t.NUM_FILAS; j++)
		{

			for (int i = 0; i < t.NUM_COL; i++)
			{
				Pieza p=t.damePieza(j, i);
				if(p!=null)
				{
					if(p.isBlanca())
						j1.getMisPiezas().add(p);
					
					else
						j2.getMisPiezas().add(p);
				}
				
			}

		}	
		
	}
	

}
