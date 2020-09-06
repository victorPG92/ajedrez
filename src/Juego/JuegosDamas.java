package Juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Excepciones.ExcepcionMovimientoNoPermitido;
import Excepciones.ExcepcionMovimientoNoPermitidoPorDejarEnJaque;
import movimientos.Movimiento;
import movimientos.MovimientoEncadenado;
import movimientos.preds.PredSigueMovEscaques;
import piezas.Pieza;
import tableros.TableroAjedrez;
import tableros.TableroDamas;
import tableros.rellenadores.RellenadorDamasInicio;
import tableros.rellenadores.RellenadorDamasSalto;
import tableros.rellenadores.RellenadorTablero;

public class JuegosDamas extends Juego 
{
	List<Escaque> escaquesDest= new ArrayList<>();

	RellenadorTablero<TableroDamas> rell= new RellenadorDamasInicio();
	
	@Override
	protected void construyeTablero()
	{
		tablero= new TableroDamas();		
		rell= new RellenadorDamasSalto();//RellenadorDamasInicio();
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
		System.out.println("jugar casillas destino");
		System.err.println("jugar destino " + i + " "+ j + " acum "+ escaquesDest);
		final Escaque escPulsado= tablero.dameEscaque(i, j);
		
		//movsPosibles= movimientoEnConstruccion.getPieza().movimientos();
		movsPosibles= piezaEnMov.movimientos();
		System.out.println("movs posibles");
		movsPosibles.stream().forEach(m-> System.out.println(m));
		System.out.println("fin mov posibles");
		
		System.out.println(movsPosibles.stream().anyMatch(m-> m.getEsqDest().equals(escPulsado)));
		//if(e!=null &&(movs.contains(new Movimiento(e,true)) || movs.contains(new Movimiento(e,false))))
		if(((TableroDamas)this.tablero).sePuedeir(escPulsado) )//en damas la siguiente es una a la que puedas ir
		//if((movsPosibles.stream().anyMatch(m-> m.getEsqDest().equals(escPulsado))) )//la siguiente es una a la que puedas ir de movi permitidos
		{
			//si repite el mismo
			if(!escaquesDest.isEmpty() && escPulsado.equals(escaquesDest.get(escaquesDest.size()-1)))
			{
				if(escaquesDest.size()==1) //es mov simple
				{
					movimientoEnConstruccion=movsPosibles.get(0);
				}
				else
				{
					System.out.println("escaques seguidos");
					System.out.println(escaquesDest);
					movsPosibles= piezaEnMov.movimientos();
					movimientoEnConstruccion=null;
					System.out.println("movs posibles");
					movsPosibles.forEach(m-> System.out.println(m));
					Optional<MovimientoEncadenado> optMov = movsPosibles.stream().filter(m-> m instanceof MovimientoEncadenado).
					map(m-> (MovimientoEncadenado)m).
					filter(m->m.sigueCaminoEnDestino(escaquesDest, true)).findFirst();//.get();
					
					if(optMov.isPresent()) movimientoEnConstruccion=optMov.get();
				}
				
				System.err.println("mov escogido "+ movimientoEnConstruccion);
				if(movimientoEnConstruccion==null)System.err.println();
				else
				tablero.realizarMovimiento(movimientoEnConstruccion);
				movimientosJugados.add(movimientoEnConstruccion);
				movimientoEnConstruccion=null;
				escaquesDest= new ArrayList<>();
				cambiarTurno();
				piezaEnMov=null;
				turnoFinalizado=true;
			}
			else
			{
				//Pieza piezaAmover = movimientoEnConstruccion.getPieza();
				
				System.out.println("insertando en camino "+ escPulsado);
				escaquesDest.add(escPulsado);
				
				List<Movimiento> movAux= new ArrayList<>();
				movsPosibles.stream().filter(new PredSigueMovEscaques(escaquesDest)).forEach(m->movAux.add(m));
				movsPosibles=movAux;
				
				System.out.println("nuevos movs");
				movsPosibles.forEach(m-> System.out.println(m));
				//escPulsado=null;
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
