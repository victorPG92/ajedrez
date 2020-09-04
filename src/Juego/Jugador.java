package Juego;

import java.util.ArrayList;
import java.util.List;

import piezas.Pieza;

public class Jugador
{
	private int id;
	private List<Pieza> misPiezas;
	private boolean turno;
	
	private boolean enJaque;
	private List<Pieza> misPiezasComidas;
	
	
	public Jugador(int id)
	{
		misPiezas = new ArrayList<Pieza>();
		this.id=id;
		
		misPiezasComidas = new ArrayList<Pieza>();

		//if(id==1) blancas
		//else negras
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public List<Pieza> getMisPiezas() {
		return misPiezas;
	}
	public void setMisPiezas(List<Pieza> misPiezas) {
		this.misPiezas = misPiezas;
	}
	
	public boolean tienePiezas()
	{
		return !misPiezas.isEmpty();
	}

	public boolean isTurno() {
		return turno;
	}
	public void setTurno(boolean turno) {
		this.turno = turno;
	}



	public void llenarPiezas(ArrayList<Pieza> mp)
	{
		//misPiezas= 
	}
	
	
	
	
	
	public boolean isEnJaque() {
		return enJaque;
	}


	public void setEnJaque(boolean enJaque) {
		this.enJaque = enJaque;
	}


	public String toString()
	{
		return "Jugador "+id;
	}
	
	
	@Override
	public Object clone()
	{
		Jugador j = new Jugador(id);
		j.misPiezas.addAll(misPiezas);
		j.turno=turno;
		j.enJaque=enJaque;
		
		return j;
	}

}
