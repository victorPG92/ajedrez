package test.damas;

import java.util.Arrays;
import java.util.List;

import damas.Dama;
import movimientos.Movimiento;
import movimientos.MovimientoEncadenado;
import tableros.TableroDamas;
import tableros.rellenadores.RellenadorPruebaPieza;
import test.damas.rell.RellenadorDamasPruebaComer;
import test.damas.rell.RellenadorDamasSalto;
import test.damas.rell.RellenadorDamasSaltoNegra;

public class PruebaComerDobleNegra
{
	
	static boolean blanca=false;
	
	public static void main(String[] args) {
		TableroDamas t= new TableroDamas();
		RellenadorPruebaPieza<TableroDamas> r;
		
		if(blanca)
			r= new RellenadorDamasSalto();
		else
			r=new RellenadorDamasSaltoNegra();
		
		r.rellena(t);
		
		System.out.println(t);
		
		Dama d= (Dama) r.getPiezaObservada();
		
		List<Movimiento> movs = d.movimientos();
		
		System.out.println(t);
		System.out.println("MOVS DE "+ d + " en "+ d.getPos());
		movs.forEach(m->System.out.println(m));
		
		MovimientoEncadenado mov = d.getMovimiento(r.getMovimientoElegido());
	
		if(mov!=null)
		t.realizarMovimiento(mov);
		else System.err.println("movimiento null : "+Arrays.toString(r.getMovimientoElegido()));
		System.out.println(t);
	}

}
