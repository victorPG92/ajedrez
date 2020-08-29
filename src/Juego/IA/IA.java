package Juego.IA;

import java.util.ArrayList;
import java.util.List;

import Juego.JuegoAjedrez;
import Juego.movimientos.Movimiento;
import Juego.tableros.TableroAjedrez;
import piezas.Pieza;

public class IA 
{
	
	private JuegoAjedrez j;
	private boolean esBlanca;
	private boolean turno;
	
	
	private double mejorValor;//valor del movimiento mejor guardado
	private Movimiento mejorMov;//Mejor movimiento
	
	private List<Movimiento> mejoresMovs;//Mejor movimiento
 	
	private boolean conseguidoJM;
	
	private TableroAjedrez t(){return j.getT();}
	public void juega()
	{
		int numRep=calcularNumRep();//calcular segun otros
		
		juega(j,numRep,turno,new ArrayList<>());
		
		
	}
	
	
	/**
	 * 
	*/
	public int calcularNumRep()
	{
		//numero de piezas
		
		
		
		return 3;
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param j
	 * @param i
	 * @param turno
	 * @param movs
	 */
	public void juega(JuegoAjedrez j, int i,boolean turno,List<Movimiento>movs)
	{
	
	//	boolean isJaque=true;
		TableroAjedrez tClon=(TableroAjedrez) t();//.clone();   no es necesario clonar
		List<Pieza> piezas = tClon.getPiezas(turno);
		System.out.println("piezas del jugador actual");
		for(Pieza p: piezas)
			System.out.println(p);
		
		
		//copio los movimientos:
		List<Movimiento>movsAux= new ArrayList<Movimiento>();
		//for (Movimiento movimiento : movs)
		movsAux.addAll(movs);
		
		for(Pieza p: piezas)
		{
			if(p.vive())
			for(Movimiento m: p.movimientos())
			{
				movsAux.add(m);
				tClon.realizarMovimiento(m);
				
				
				valorarMovs(movsAux,tClon,turno);
				//si es MATE VALORAR mas, pero claro, tener en cuenta, que un mate de varios movimientos puede ser evitado
				
				
				tClon.deshacerMovimiento(m);
				movsAux.remove(m);//se ahorra en eficacia poner (size()-1)??
				
				
			}
			
			
		}
		
	//	return movsAux;
		
		
		
	//	j.retrocederTIempo();
	}
	
	
	private void valorarMovs(List<Movimiento>movs,TableroAjedrez t, boolean turno)
	{
		boolean isJaque= JuegoAjedrez.comprobarJaque(t,turno);
		if(isJaque)
		{
			boolean isJaqueMate = JuegoAjedrez.comprobarJaqueMate(t,turno);
			if(isJaqueMate) 
			{
				if(conseguidoJM )
				{
					//contar en cuantos movimientos se consigue el JM
					if(movs.size()<mejoresMovs.size())
					{
						
					}
					//contar cuantas fichas se comen y cuantas son comidas por el otro 
				}
			}
			
		}
	}

}
