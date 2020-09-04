package movimientos;

import Juego.Escaque;
import piezas.Pieza;

public class FactMov 
{

	/**
	 * La pieza de el escaque actual se mueve hacia el escaque siguiente
	 * realizando un movimiento simple de desplazamiento
	 * no come
	 * por ello, el destino debe estar vacio, 
	 * 
	 * 
	 * @param escActual
	 * @param escSig
	 * @return
	 */
	public Movimiento creaMovAjedrezSimple(Escaque escActual, Escaque escSig)
	{
		//si estaocupado no puede realizar un movimietno simple de desplazamiento
		if(escSig.estaOcupado())
			return null;
		
		Movimiento mov= new Movimiento();//pieza, escDest, c);
		
		mov.setPieza(escActual.damePieza());
		
		//comer, no es necesario ya inicializado:
		mov.setComer(false);
		mov.setPiezaComida(null);
				
		return mov;
	}
	
	/**
	 * La pieza de el escaque actual se mueve hacia el escaque siguiente
	 * no comiendo, 
	 * por lo que el escaque destino debe tener una pieza
	 * 
	 * @param escActual
	 * @param escSig
	 * @return
	 */
	public Movimiento creaMovAjedrezComer(Escaque escActual, Escaque escSig)
	{
		if(!escSig.estaOcupado())
			return null;
		
		Movimiento mov= new Movimiento();//pieza, escDest, c);
		
		mov.setPieza(escActual.damePieza());
		
		//comer, no es necesario ya inicializado:
		mov.setComer(true);
		mov.setPiezaComida(escSig.damePieza());//exfrae la quita
				
		return mov;
	}
	
	/**
	 * En las damas, el escaque destino debe estar libre
	 * 
	 * @param escActual
	 * @param escSig
	 * @param piezaComida
	 * @return
	 */
	public Movimiento creaMovDamasComer(Escaque escActual, Escaque escSig, Pieza piezaComida)
	{
		if(escSig.estaOcupado())
			
			return null;
		
		Movimiento mov= new Movimiento();//pieza, escDest, c);
		
		mov.setPieza(escActual.damePieza());
		
		//comer, no es necesario ya inicializado:
		if(piezaComida!=null)
		{
			mov.setComer(true);
			mov.setPiezaComida(piezaComida);//exfrae la quita
		}	
		else //no comer, no es necesario ya inicializado:
		{
			mov.setComer(false);
			mov.setPiezaComida(null);
		}	
		return mov;
	}
}
