package Juego.extractor;

import Juego.Jugador;
import piezas.Pieza;
import tableros.TableroAjedrez;

/**
 * Revisa todos los escaques y coge las piezas de cada color
 *  @author victor
 *
 */
public class ExtractorPiezasTotal implements ExtractorPiezas
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
					Jugador jug=p.isBlanca()?j1:j2;					
					asociaPieza(jug, p);
				}
				
			}

		}	
		
	}
	

}
