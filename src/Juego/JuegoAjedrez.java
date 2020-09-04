package Juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Excepciones.ExcepcionEscaqueFueraDeRango;
import Excepciones.ExcepcionJaqueMate;
import Excepciones.ExcepcionMovimientoNoPermitido;
import Excepciones.ExcepcionMovimientoNoPermitidoPorDejarEnJaque;
import Excepciones.ExcepcionNoPieza;
import Excepciones.ExcepcionPiezaDeOtroJugador;
import Excepciones.ExcepcionPiezaSinMovimientos;
import Juego.util.Dificultad;
import movimientos.Movimiento;
import piezas.Pieza;
import tableros.TableroAjedrez;
import tableros.rellenadores.RellenadorAjedrezInicio;

public class JuegoAjedrez extends Juego
{
	RellenadorAjedrezInicio rell= new RellenadorAjedrezInicio();

	@Override
	protected void construyeTablero() {
		tablero= new TableroAjedrez();

		rell.creaPiezas(tablero);
		
	}

	
	
	
	/**
	 * Elige casilla final, usando la casilla inicial
	 * @param i ,j: coordenadas de casilla destino
	 * @param p, que movemos a dicha casilla
	 * @param movs, lista movimientos permitidos por la pieza p 
	 * @throws Exception 
	 */
	@Override
	public void jugarCasillaDestino(int i, int j) throws Exception
	{
			
		Escaque e= tablero.dameEscaque(i, j);
	
		//if(e!=null &&(movs.contains(new Movimiento(e,true)) || movs.contains(new Movimiento(e,false))))
		if(e!=null )
		{
			Pieza piezaAmover = movimientoEnConstruccion.getPieza();
			Movimiento pos1= new Movimiento(piezaAmover,e,true);
			Movimiento pos2= new Movimiento(piezaAmover,e,false);//aqui es icongruente un mov sin piza que comer , pero da igual
			if(piezaAmover.movimientos().contains(pos1) || piezaAmover.movimientos().contains(pos2))
			{
				
				//System.out.println("moviendo dest"+t);
				movimientoEnConstruccion.setEsqDest(e);
				movimientoEnConstruccion.setComer(!e.estaOcupado());
				
				if(movimientoEnConstruccion.getPieza().nombre().equalsIgnoreCase("rey"))
				{
					Integer pos= piezaAmover.movimientos().indexOf(pos1);
					if(pos==-1) 
							pos= piezaAmover.movimientos().indexOf(pos2);
					
					movimientoEnConstruccion=piezaAmover.movimientos().get(pos); 
				}
				tablero.realizarMovimiento(movimientoEnConstruccion);
				//System.out.println("Despues de mover "+t);
				
				
				boolean enJaque=comprobarJaque();
				if(enJaque)
				{
					
					
						//.forEach(system);;
					System.err.println("No se puede hacer ese movimiento porque se queda en jaque" + movimientoEnConstruccion);
					System.out.println("Movimientos en jaque :");
					System.out.println("..-----------------------------");
					for(Movimiento m:comprobarJaqueMovs())
						System.out.println(m);
					tablero.deshacerMovimiento(movimientoEnConstruccion);
					movimientoEnConstruccion.setEsqDest(null);
					
					throw new ExcepcionMovimientoNoPermitidoPorDejarEnJaque();
				}
				movimientosJugados.add(movimientoEnConstruccion);
				movimientoEnConstruccion=null;
			
				cambiarTurno();
			}
			else
			{
				// movimientoEnConstruccion=null;
				throw new ExcepcionMovimientoNoPermitido();
			}
			
		
			
			
		}
		else if(e!=null && e.estaOcupado() && e.damePieza().isBlanca()==turno)
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
	

	
	/**
	 * Comprueba el jaque  
	 * recorre las puezas del jugador contrario y comprueba si alguna ataca al rey del turno actual 
	 * 
	 * @return
	 */
	public boolean comprobarJaque()
	{
		boolean isJaque=false;
		List<Pieza> piezas = tablero.getPiezas(!turno);
		
		for(Pieza p: piezas)
		{
			if(p.vive())
			for(Movimiento m: p.movimientos())
			{
				Pieza pp=m.getEsqDest().damePieza(); 
				if(pp!=null && pp.dameTipo().name().equals("REY") && pp.isBlanca()==turno) isJaque=true;
				if(isJaque) return isJaque;
			}
		}
		
		
		return isJaque;
	}
	
	/**
	 * Comprueba el jaque  
	 * recorre las puezas del jugador contrario y comprueba si alguna ataca al rey del turno actual 
	 * 
	 * @return
	 */
	public List<Movimiento> comprobarJaqueMovs()
	{
		ArrayList<Movimiento> movEnJAque=new ArrayList<>();
		List<Pieza> piezas = tablero.getPiezas(!turno);
		
		
		for(Pieza p: piezas)
		{
			if(p.vive())
			for(Movimiento m: p.movimientos())
			{
				Pieza pp=m.getEsqDest().damePieza(); 
				if(pp!=null && pp.dameTipo().name().equals("REY") && pp.isBlanca()==turno) 
					movEnJAque.add(m);
			}
		}
		
		
		return movEnJAque;
	}
	
	/**
	 * Comprueba el jaque  
	 * recorre las puezas del jugador contrario y comprueba si alguna ataca al rey del turno actual 
	 * 
	 * @return
	 */
	public static boolean comprobarJaque(TableroAjedrez tt,boolean turno)
	{
		System.out.println("Comprobando jaque en tablero movido");
		System.out.println(tt);
		boolean isJaque=false;
		List<Pieza> piezas = tt.getPiezas(!turno);
		
		//System.out.println("Piezas del contrario");	for(Pieza p: piezas)		System.out.println(p +""+p.movimientos());
		
		for(Pieza p: piezas)
		{
			if(p.vive())
			for(Movimiento m: p.movimientos())
			{
				Pieza pp=m.getEsqDest().damePieza(); 
				if(pp!=null && pp.dameTipo().name().equals("REY") && pp.isBlanca()==turno) isJaque=true;
				if(isJaque) return isJaque;
			}
		}
		
		
		return isJaque;
	}
	
	/**
	 * Comprueba el jaque mate en el actual jugador
	 * reocrre las piezas del jugador del turno
	 * y para cada una
	 * reocrre sus movimientos posibles
	 * y con ello, 
	 * @return
	 */
	public static  boolean comprobarJaqueMate(TableroAjedrez tt,boolean turno)
	{
		
		System.out.println("Comprobando JAque Mate");
		System.out.println("----------------------------------------------------------");
		
		boolean isJaque=true;
		TableroAjedrez tClon=(TableroAjedrez) tt.clone();
		List<Pieza> piezas = tClon.getPiezas(turno);
		System.out.println("piezas del jugador actual");
		for(Pieza p: piezas)
			System.out.println(p);
		
		
		for(Pieza p: piezas)
		{
			if(p.vive())
			for(Movimiento m: p.movimientos())
			{
				//System.out.println("Antes de realizar el movimiento "+ m);				System.out.println("clon \n" + tClon);
				tClon.realizarMovimiento(m);
				//System.out.println("Despues de realizar el movimiento "+ m);				System.out.println("clon \n" + tClon);
				isJaque= comprobarJaque(tClon,turno);
				if(!isJaque)System.out.println("Se logra evitara asi:\n "+tClon);
				tClon.deshacerMovimiento(m);
				//System.out.println("Despues de deshacer el movimiento "+ m);				System.out.println("clon \n" + tClon);
				
				if(!isJaque)
				{
					System.out.println("con el movimiento "+ m + "  se consigue evitar el jm");
					break;
				}
				System.out.println("con el movimiento "+ m + " no se consigue evitar el j");
			}
			//System.out.println("Moviendo "+p+" no se consigue evitar el J" );
			if(!isJaque)break;
		}
		
		if(isJaque)System.out.println("No se ha conseguido evitar el jaque, asi que JM");
		
		System.out.println("Fin Comprobacion JAque Mate");
		System.out.println("----------------------------------------------------------");
		return isJaque;
	}
	
	/**
	 * Comprueba el jaque mate en el actual jugador
	 * reocrre las piezas del jugador del turno
	 * y para cada una
	 * reocrre sus movimientos posibles
	 * y con ello, 
	 * @return
	 */
	public ArrayList<Movimiento>  comprobarJaqueMateMovs()
	{
		ArrayList<Movimiento> movEnJAque=new ArrayList<>();
		TableroAjedrez tClon=(TableroAjedrez) tablero.clone();
		List<Pieza> piezas = tClon.getPiezas(turno);
		
		for(Pieza p: piezas)
		{
			if(p.vive())
			for(Movimiento m: p.movimientos())
			{
				tClon.realizarMovimiento(m);
				if(!comprobarJaque(tClon,turno));
					movEnJAque.add(m);
				tClon.deshacerMovimiento(m);
				
								
				
			}
		
		}
		
		
		
		return movEnJAque;
	}
	
		
	
	
	

	
	
	public Object clone()
	{
		JuegoAjedrez j= new JuegoAjedrez();
		j.setD(d);
		//j.setE(e);
		j.setExisteGanador(existeGanador);
		j.setGanadorJ2(ganadorJ1);
		j.setGanadorJ2(ganadorJ2);
		j.setJ1((Jugador)j1.clone());///
		j.setJ2((Jugador)j2.clone());////
		j.setMovido(movido);
		
		j.setT((TableroAjedrez)tablero.clone());
		j.setTurno(turno);
		;
		
		gestionarTurno();
		
		for(Pieza p: tablero.getPiezas())
		{
			if(p.isBlanca()) 	p.setJ(j.getJ1());
			else  				p.setJ(j.getJ2());
		}
			
		
		return j;
	}
	
	
	
	
	
	////////////////////////////////////////////////////////
	
	
	
	
	

	
	//////////////////////////////////////////////////////////////
	
	public void copiarDe(JuegoAjedrez j) //es como hacer this= j;
	{
		setD(j.d);
		
		setExisteGanador(j.existeGanador);
		setGanadorJ2(j.ganadorJ2);
		setJ1(j.j1);
		setJ2(j.j2);
		setMovido(j.movido);
		
		setT(j.tablero);
		setTurno(j.turno);
		
			
			
		
	}
	
	
	
	
	
	public ArrayList<Movimiento> dameCasillasPeligrosas()
	{
		TableroAjedrez tclon = (TableroAjedrez) tablero.clone();
		ArrayList<Movimiento> movs = new ArrayList<Movimiento>();
		
		this.cambiarTurno();//esto no deberia
		
		for(Pieza p :  tablero.getPiezas(turno))
		{
			for(Movimiento m:p.movimientos())
			{
				
				tablero.dameEscaque(p.damePosicion()).extraePieza();
				tablero.dameEscaque(m.getEsqDest().getPos()).recibirPieza(p, m.isComer());
				
				if(!comprobarJaque()) movs.add(m);
				tablero=(TableroAjedrez) tclon.clone();
			}
			
			
		}
		this.cambiarTurno();//esto no deberia
		return movs;
		
	}
	
		


	
	
	
	
}
