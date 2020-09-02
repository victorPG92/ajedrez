package Juego;

import java.util.List;
import java.util.Stack;

import Juego.movimientos.Movimiento;
import Juego.tableros.TableroAjedrez;
import Juego.util.Dificultad;
import piezas.Pieza;

public class Juego {

	
	protected Jugador j1; //posee las piezas blancas
	protected Jugador j2;
	
	protected TableroAjedrez t;


	protected Dificultad d;
	
	protected boolean turno; //true si es j1, y false si es de j2
	
	protected boolean existeGanador; 
	protected boolean ganadorJ1; 
	protected boolean ganadorJ2; 
	
	protected boolean movido;
		
	//auxiliares
	protected Movimiento movimientoEnConstruccion;
	
	protected Stack<Movimiento> movimientosJugados;
	

	
	public Juego() 
	{
		j1=new Jugador(1);
		j2=new Jugador(2);
		
		turno=true;
		j1.setTurno(true);
		j2.setTurno(false);
		
		t= new TableroAjedrez();
		
		
		
		 colocaTurnos();
		//v= new VentanaAjedrez(t);
		
		//this.guardarMemento();
		
		movimientosJugados= new Stack<Movimiento> ();//(new  LinkedList<>());
	}
	
	
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
	
	protected void colocaTurnosPiezas()
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
	
	

	
}
