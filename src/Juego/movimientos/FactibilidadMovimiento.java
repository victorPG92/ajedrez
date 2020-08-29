package Juego.movimientos;

import Juego.util.Posicion;

/**
 * Indica si el movimiento es posible
 * si lo es, los flags estaran a false , y el movimiento inicializado
 * 
 * si no, algun flag estara a true y el movimiento sera null
 * @author victor
 *
 */
public class FactibilidadMovimiento
{
	
	private boolean fueraDeTablero;
	private boolean casillaOcupada;
	private Posicion posicionDest;
	
	private Movimiento movimiento;

	public FactibilidadMovimiento(boolean fueraDeTablero, boolean casillaOcupada, Posicion posicion,
			Movimiento movimiento) {
		super();
		this.fueraDeTablero = fueraDeTablero;
		this.casillaOcupada = casillaOcupada;
		this.posicionDest = posicion;
		this.movimiento = movimiento;
	}

	public FactibilidadMovimiento(Movimiento movimiento) {
		super();
		this.movimiento = movimiento;
	}

	
	
	
}
