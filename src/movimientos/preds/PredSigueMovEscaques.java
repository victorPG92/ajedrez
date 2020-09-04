package movimientos.preds;

import java.util.List;
import java.util.function.Predicate;

import Juego.Escaque;
import movimientos.Movimiento;
import movimientos.MovimientoEncadenado;

/**
 * Devuelve si el movimiento coincide con la secuencia de escaques
 * si es un movimiento simple, la secuencia tendra que ser de longitud 1
 * 	y coincidir la casilla destino con el unico elemento de la secuencia
 * 
 * si es encadenado, se deberia usar la funcion ya creada sgue camino
 * la cual no existe en movimiento simple
 * @author victor
 *
 */
public class PredSigueMovEscaques implements Predicate<Movimiento>{

	List<Escaque> esc;
	
	public PredSigueMovEscaques(List<Escaque> esc) {
		super();
		this.esc = esc;
	}

	@Override
	public boolean test(Movimiento m) 
	{
		if(m instanceof MovimientoEncadenado)
			return ((MovimientoEncadenado)m).sigueCaminoEnDestino(esc,esc.size(),false);
		
		return 
				esc.size()==1 && m.getEsqDest().equals(esc.get(0));
	}

	
}
