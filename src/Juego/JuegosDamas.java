package Juego;

import java.util.ArrayList;
import java.util.List;

import Excepciones.ExcepcionMovimientoNoPermitido;
import Excepciones.ExcepcionMovimientoNoPermitidoPorDejarEnJaque;
import movimientos.Movimiento;
import movimientos.MovimientoEncadenado;
import movimientos.preds.PredSigueMovEscaques;
import piezas.Pieza;
import tableros.TableroAjedrez;
import tableros.TableroDamas;
import tableros.rellenadores.RellenadorDamasInicio;

public class JuegosDamas extends Juego 
{
	List<Escaque> escaquesDest= new ArrayList<>();

	RellenadorDamasInicio rell= new RellenadorDamasInicio();
	
	@Override
	protected void construyeTablero()
	{
		tablero= new TableroDamas();		
		rell= new RellenadorDamasInicio();
		System.err.println(rell);
		rell.creaPiezas((TableroDamas)tablero);
	}
	
	
	@Override
	public Pieza jugarCasillaInicial(int i, int j) throws Exception {
			return super.jugarCasillaInicial(i, j);
	}
	
	/**
	 * Elige casilla final, usando la casilla inicial
	 * @param i ,j: coordenadas de casilla destino
	 * @param p, que movemos a dicha casilla
	 * @param movs, lista movimientos permitidos por la pieza p 
	 * @throws Exception 
	 */
	public void jugarCasillaDestino(int i, int j) throws Exception
	{			
		Escaque escPulsado= tablero.dameEscaque(i, j);
		
	
		//if(e!=null &&(movs.contains(new Movimiento(e,true)) || movs.contains(new Movimiento(e,false))))
		if(((TableroDamas)this.tablero).sePuedeir(escPulsado) )//en damas la siguiente es una a la que puedas ir
		{
			//si repite el mismo
			if(escPulsado.equals(escaquesDest.get(escaquesDest.size()-1)))
			{
				if(escaquesDest.size()==1) //es mov simple
				{
					movimientoEnConstruccion=movsPosibles.get(0);
				}
				else
				{
					movimientoEnConstruccion=
						movsPosibles.stream().filter(m-> m instanceof MovimientoEncadenado).
						map(m-> (MovimientoEncadenado)m).
						filter(m->m.sigueCaminoEnDestino(escaquesDest, escaquesDest.size(), true)).findFirst().get();
				}
				
				movimientosJugados.add(movimientoEnConstruccion);
				movimientoEnConstruccion=null;
				escaquesDest= new ArrayList<>();
				
			}
			else
			{
			//Pieza piezaAmover = movimientoEnConstruccion.getPieza();
			escaquesDest.add(escPulsado);
			
			List<Movimiento> movAux= new ArrayList<>();
			movsPosibles.stream().filter(new PredSigueMovEscaques(escaquesDest)).forEach(m->movAux.add(m));
			//tablero.realizarMovimiento(movimientoEnConstruccion);
			//System.out.println("Despues de mover "+t);
				
				
				
			
			/*
			else
			{
				// movimientoEnConstruccion=null;
				throw new ExcepcionMovimientoNoPermitido();
			}*/
			
		
			
			}
			
		}
	
		else if(ocupadoPorMismoColor(escPulsado,turno))
		{
			//metido ultimo, arreglar
			System.out.println("cambiando de pieza ");
			jugarCasillaInicial(i, j) ;
		}
		else
		{
			
			throw new ExcepcionMovimientoNoPermitido();
		}

		
	}


	public boolean ocupadoPorMismoColor(Escaque esc, boolean color)
	{
		return esc!=null && esc.estaOcupado() && esc.damePieza().isBlanca()==color;
	
	}
	
	protected boolean leQuedanPiezasAlOtro()
	{
		return getOtroJugador().tienePiezas();
	}
	
	
	
	public boolean comprobarFin()
	{
		if(!leQuedanPiezasAlOtro())
		{
			existeGanador=true;
			setGanador();
			
			
			return true;
		}
		
		return false;
	}

}
