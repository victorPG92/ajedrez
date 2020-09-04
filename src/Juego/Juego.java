package Juego;

import java.util.List;
import java.util.Stack;

import Excepciones.ExcepcionEscaqueFueraDeRango;
import Excepciones.ExcepcionNoPieza;
import Excepciones.ExcepcionPiezaDeOtroJugador;
import Excepciones.ExcepcionPiezaSinMovimientos;
import Juego.util.Dificultad;
import movimientos.Movimiento;
import piezas.Pieza;
import tableros.TableroAjedrez;

public abstract class Juego {

	
	protected Jugador j1; //posee las piezas blancas
	protected Jugador j2;
	
	protected TableroAjedrez tablero;


	protected Dificultad d;
	
	protected boolean turno; //true si es j1, y false si es de j2
	
	protected boolean existeGanador; 
	protected boolean ganadorJ1; 
	protected boolean ganadorJ2; 
	
	protected boolean movido;
		
	//auxiliares
	protected Movimiento movimientoEnConstruccion;
	
	protected Stack<Movimiento> movimientosJugados;
	
	protected List<Movimiento> movsPosibles;

	protected boolean turnoFinalizado;
	
	public Juego() 
	{
		j1=new Jugador(1);
		j2=new Jugador(2);
		
		turno=true;
		j1.setTurno(true);
		j2.setTurno(false);
		
		construyeTablero();
		
		
		
		 colocaTurnos();
		//v= new VentanaAjedrez(t);
		
		//this.guardarMemento();
		
		movimientosJugados= new Stack<Movimiento> ();//(new  LinkedList<>());
	}
	
	
	protected abstract void construyeTablero();


	protected void colocaTurnos()
	{
		try{ colocaTurnosNormal();}catch(Exception e )
		{	colocaTurnosPiezas();	}
		
	}
	protected void colocaTurnosNormal()
	{
		//for(int i=0;i<8;i++)
		//for(int j=0;j<8;j++)
		
		int j=0;
		for(int i=0;i<8;i++)
			tablero.damePieza(j,i).setJ(j1);
		
		j=1;
		for(int i=0;i<8;i++)
			tablero.damePieza(j,i).setJ(j1);
		
		
		j=6;
		for(int i=0;i<8;i++)
			tablero.damePieza(j,i).setJ(j2);
		
		j=7;
		for(int i=0;i<8;i++)
			tablero.damePieza(j,i).setJ(j2);
	}
	
	protected void colocaTurnosPiezas()
	{
		List<Pieza> piezas = tablero.getPiezas();
		for (Pieza pieza : piezas)
		{
			if(pieza.isBlanca())
				pieza.setJ(j1);
			else 
				pieza.setJ(j2);
		}
	}
	
	public void cambiarTurno()
	{
		
		
		//if(turno)turno=false;else turno=true;
		turno = !turno;
		
		gestionarTurno();
		
		
	}
	
	public void gestionarTurno()
	{
		if(turno)
		{
			j1.setTurno(true);
			j2.setTurno(false);
		}
		else
		{
			//System.out.println("Se ha cambiado el turno correctamente");
	         j1.setTurno(false);
	         j2.setTurno(true);
		}
		
		
	}

	public Jugador getJugadorActual()
	{
		if(turno)
			return j1;
		else return j2;
	}
	
	public Jugador getOtroJugador()
	{
		if(!turno)
			return j1;
		else return j2;
	}

	/**
	 * Elige casilla inicial
	 * @param i
	 * @param j
	 * @return
	 * @throws Exception
	 */
	public Pieza jugarCasillaInicial(int i, int j) throws Exception
	{		
		Pieza piezaUsada=null;
		
		movimientoEnConstruccion=null;
			
		Escaque e= tablero.dameEscaque(i, j);
		movimientoEnConstruccion = new Movimiento();
		if(e!=null)
		{
		
			piezaUsada = e.damePieza();
				
			if(piezaUsada==null)
			{
				System.out.println("Casilla vacia");
				throw new ExcepcionNoPieza(); //"Casilla vacia"
			}
			else if(!piezaUsada.getJ().isTurno()) 
			{
				
				System.out.println("Pieza de jugador contrario: " + piezaUsada.getJ());
				piezaUsada=null;
				
				throw new ExcepcionPiezaDeOtroJugador(); //"Pieza de otro jugador "
				
			}
			else 
			{
				List<Movimiento> movs = piezaUsada.movimientos();
				if(movs.isEmpty()) 
				{
					piezaUsada=null;
					throw new ExcepcionPiezaSinMovimientos();//"Pieza sin movimientos"
				}
				else
				{
					movimientoEnConstruccion.setPieza(piezaUsada);
					movsPosibles= movs;
				}
				
			}
		}
		else
		{
			///System.out.println("Posicion fuera del tablero");
			throw new ExcepcionEscaqueFueraDeRango();//"Posicion fuera del tablero"
		}
	
		
	
		return piezaUsada;
		
	}
	
	public void setGanador()
	{
		if(turno)
			setGanadorJ1(true);
		else
			setGanadorJ2(false);
	}
	
	public void mostrarJugada()
	{
		System.out.println(tablero.toString());
	}
	
	

	/**
	 * Deshace el ultimo movimiento jugado y cambia el turno como debe ser
	 */
	public boolean retrocederTIempo()
	{
		if(!movimientosJugados.isEmpty())
		{
			Movimiento mov= movimientosJugados.pop();
			tablero.deshacerMovimiento(mov);
			cambiarTurno();
			movimientoEnConstruccion=null;
			
			return true;
		}
		else
		{
			System.err.println("No hay movs ");
			return false;
		}
			
	}
	
	

	public Jugador getJ1() {		return j1;	}
	public void setJ1(Jugador j1) {		this.j1 = j1;	}

	public Jugador getJ2() {		return j2;	}
	public void setJ2(Jugador j2) {		this.j2 = j2;	}

	public TableroAjedrez getT() {		return tablero;	}
	public void setT(TableroAjedrez t) {		this.tablero = t;	}


	public Dificultad getD() {		return d;	}
	public void setD(Dificultad d) {		this.d = d;	}

	public boolean isTurno() {		return turno;	}
	public void setTurno(boolean turno) {		this.turno = turno;	}

	public boolean isExisteGanador() {		return existeGanador;	}
	public void setExisteGanador(boolean existeGanador) {		this.existeGanador = existeGanador;	}

	public boolean isGanadorJ1() {		return ganadorJ1;	}
	public void setGanadorJ1(boolean ganadorJ1) {		this.ganadorJ1 = ganadorJ1;	}

	public boolean isGanadorJ2() {		return ganadorJ2;	}
	public void setGanadorJ2(boolean ganadorJ2) {		this.ganadorJ2 = ganadorJ2;	}

	
	public boolean isMovido() {		return movido;	}
	public void setMovido(boolean movido) {		this.movido = movido;	}


	public Stack<Movimiento> getMovimientosJugados() {
		return movimientosJugados;
	}


	/**
	 * Elige casilla final, usando la casilla inicial
	 * @param i ,j: coordenadas de casilla destino
	 * @param p, que movemos a dicha casilla
	 * @param movs, lista movimientos permitidos por la pieza p 
	 * @throws Exception 
	 */
	public abstract void jugarCasillaDestino(int i, int j) throws Exception;


	public final boolean isTurnoFinalizado() {
		return turnoFinalizado;
	}


	public final void setTurnoFinalizado(boolean turnoFinalizado) {
		this.turnoFinalizado = turnoFinalizado;
	}


	

	
}
