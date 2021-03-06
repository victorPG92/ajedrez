package test.damas;

import java.util.List;

import damas.Dama;
import movimientos.Movimiento;
import tableros.TableroDamas;
import tableros.rellenadores.RellenadorTablero;
import tableros.rellenadores.damas.RellenadorDamasInicio;
import test.damas.rell.RellenadorDamasPruebaComer;

public class TestDamas
{
	public static void prueba(String[] args) {
		
		TableroDamas t= new TableroDamas();
		RellenadorTablero<TableroDamas> r= new RellenadorDamasInicio(); 
		
		r.rellena(t);
		
		System.out.println(t);

		
		Dama dama= (Dama) t.damePieza(1, 3);
		List<Movimiento> movs = dama.movimientos();
		
		movs.forEach(m-> System.out.println(m));
		
		
		t.realizarMovimiento(movs.get(1));
		System.out.println(t);
	
		
	}
	
	public static void prueba2(String[] args) {
		
		TableroDamas t= new TableroDamas();
		RellenadorTablero<TableroDamas> r= new RellenadorDamasPruebaComer();//new RellenadorDamasInicio()
		
		r.rellena(t);
		
		System.out.println(t);

		
		Dama dama= (Dama) t.damePieza(2, 2);
		List<Movimiento> movs = dama.movimientos();
		
		System.out.println("movs posibles:" + movs.size());
		movs.forEach(m-> System.out.println(m));
		System.out.println();
		
		
		t.realizarMovimiento(movs.get(1));
		System.out.println(t);
	
		
	}
	
	public static void main(String[] args) {
		prueba2(args);
	}

}
