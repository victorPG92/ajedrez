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
import Juego.movimientos.Movimiento;
import Juego.tableros.TableroAjedrez;
import Juego.util.Dificultad;
import piezas.Pieza;

public class JuegoAjedrez
{

	private Jugador j1; //posee las piezas blancas
	private Jugador j2;
	
	private TableroAjedrez t;


	private Dificultad d;
	
	private boolean turno; //true si es j1, y false si es de j2
	
	private boolean existeGanador; 
	private boolean ganadorJ1; 
	private boolean ganadorJ2; 
	
	private boolean movido;
		
	//auxiliares
	private Movimiento movimientoEnConstruccion;
	
	private Stack<Movimiento> movimientosJugados;
	

	
	public JuegoAjedrez() 
	{
		j1=new Jugador(1);
		j2=new Jugador(2);
		
		turno=true;
		j1.setTurno(true);
		j2.setTurno(false);
		
		t= new TableroAjedrez(true);
		
		
		
		 colocaTurnos();
		//v= new VentanaAjedrez(t);
		
		//this.guardarMemento();
		
		movimientosJugados= new Stack<Movimiento> ();//(new  LinkedList<>());
	}
	
	
	private void colocaTurnos()
	{
		try{ colocaTurnosNormal();}catch(Exception e )
		{	colocaTurnosPiezas();	}
		
	}
	private void colocaTurnosNormal()
	{
		//for(int i=0;i<8;i++)
		//for(int j=0;j<8;j++)
		
		int j=0;
		for(int i=0;i<8;i++)
			t.damePieza(j,i).setJ(j1);
		
		j=1;
		for(int i=0;i<8;i++)
			t.damePieza(j,i).setJ(j1);
		
		
		j=6;
		for(int i=0;i<8;i++)
			t.damePieza(j,i).setJ(j2);
		
		j=7;
		for(int i=0;i<8;i++)
			t.damePieza(j,i).setJ(j2);
	}
	
	private void colocaTurnosPiezas()
	{
		List<Pieza> piezas = t.getPiezas();
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
	
	
	
	
	public void mostrarJugada()
	{
		System.out.println(t.toString());
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
		
		
		Pieza p=null;
		
		movimientoEnConstruccion=null;
			
		
		Escaque e= t.dameEscaque(i, j);
		movimientoEnConstruccion = new Movimiento();
		if(e!=null)
		{
		
			p = e.damePieza();
			
			
			if(p==null)
			{
				System.out.println("Casilla vacia");
				throw new ExcepcionNoPieza(); //"Casilla vacia"
			}
			else if(!p.getJ().isTurno()) 
			{
				
				System.out.println("Pieza de jugador contrario: " + p.getJ());
				p=null;
				
				throw new ExcepcionPiezaDeOtroJugador(); //"Pieza de otro jugador "
				
			}
			else if(p.movimientos().isEmpty()) 
			{
				p=null;
				throw new ExcepcionPiezaSinMovimientos();//"Pieza sin movimientos"
			}
			else
			{
				movimientoEnConstruccion.setPieza(p);
			}
			
		}
		else
		{
			///System.out.println("Posicion fuera del tablero");
			throw new ExcepcionEscaqueFueraDeRango();//"Posicion fuera del tablero"
		}
	
		
	
		return p;
		
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
			
		Escaque e= t.dameEscaque(i, j);
	
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
				t.realizarMovimiento(movimientoEnConstruccion);
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
					t.deshacerMovimiento(movimientoEnConstruccion);
					movimientoEnConstruccion.setEsqDest(null);
					
					throw new ExcepcionMovimientoNoPermitidoPorDejarEnJaque();
				}
				movimientosJugados.add(movimientoEnConstruccion);
				movimientoEnConstruccion=null;
			
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
		List<Pieza> piezas = t.getPiezas(!turno);
		
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
	public ArrayList<Movimiento> comprobarJaqueMovs()
	{
		ArrayList<Movimiento> movEnJAque=new ArrayList<>();
		List<Pieza> piezas = t.getPiezas(!turno);
		
		
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
		TableroAjedrez tClon=(TableroAjedrez) t.clone();
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
	
		
	
	
	

	/**
	 * Deshace el ultimo movimiento jugado y cambia el turno como debe ser
	 */
	public boolean retrocederTIempo()
	{
		if(!movimientosJugados.isEmpty())
		{
			Movimiento mov= movimientosJugados.pop();
			t.deshacerMovimiento(mov);
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
		
		j.setT((TableroAjedrez)t.clone());
		j.setTurno(turno);
		;
		
		gestionarTurno();
		
		for(Pieza p: t.getPiezas())
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
		
		setT(j.t);
		setTurno(j.turno);
		
			
			
		
	}
	
	
	
	
	
	public ArrayList<Movimiento> dameCasillasPeligrosas()
	{
		TableroAjedrez tclon = (TableroAjedrez) t.clone();
		ArrayList<Movimiento> movs = new ArrayList<Movimiento>();
		
		this.cambiarTurno();//esto no deberia
		
		for(Pieza p :  t.getPiezas(turno))
		{
			for(Movimiento m:p.movimientos())
			{
				
				t.dameEscaque(p.damePosicion()).extraePieza();
				t.dameEscaque(m.getEsqDest().getPos()).recibirPieza(p, m.isComer());
				
				if(!comprobarJaque()) movs.add(m);
				t=(TableroAjedrez) tclon.clone();
			}
			
			
		}
		this.cambiarTurno();//esto no deberia
		return movs;
		
	}
	
	
	public Jugador getJ1() {		return j1;	}
	public void setJ1(Jugador j1) {		this.j1 = j1;	}

	public Jugador getJ2() {		return j2;	}
	public void setJ2(Jugador j2) {		this.j2 = j2;	}

	public TableroAjedrez getT() {		return t;	}
	public void setT(TableroAjedrez t) {		this.t = t;	}


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


	
	


	
	
	
	
}
