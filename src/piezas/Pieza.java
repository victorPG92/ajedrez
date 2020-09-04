package piezas;

import java.util.ArrayList;
import java.util.List;

import vista.mapper.claves.ClaveEnumCompuesta;
import entradaSalida.EntradaTeclado;
import movimientos.Movimiento;
import tableros.TableroAjedrez;
import Juego.Escaque;
import Juego.Jugador;
import Juego.util.Posicion;

public abstract class Pieza
{
	protected int id;
	
	protected boolean blanca;
	protected TipoFicha tipo;
	protected Posicion pos;
	protected boolean esMovida = false;
	protected boolean estaViva = true;
	
	protected TableroAjedrez tableroAjedrez;
	protected Jugador j;//a que jugador pertenece
	
	
	
	
	//almacena los movimientos anteriores apra no recalcularlos::   o mejor recalcularlos???
	//protected ArrayList<Movimiento> moviientosAnt; 
	//protected boolean movidoant;
	
	public boolean isBlanca()	{		return blanca;	}
	
	public  TipoFicha dameTipo()	{		return tipo;	}
	
	public Posicion damePosicion()	{		return pos;	}
	
		

	public void setPos(Posicion pos) {		this.pos = pos;	}
	public boolean fueMovida()	{		return esMovida;	}
	
	public void setMovida(boolean b)	{		 esMovida= b;	}
	
	public abstract char getSigla();
	

	
	
	
	/*public void isBlanca()
	{
		return blanca;
	}
	
	public  void dameTipo()
	{
		return tipo;
	}
	
	public void damePosicion()
	{
		return pos;
	}
	
	public void fueMovida()
	{
		return esMovida;
	}
	*/
	
	public abstract List<Movimiento> movimientos();
	
	public boolean crearMov(List<Movimiento> a,int i, int j)
	{
		boolean comer=false;
		
		if(tableroAjedrez.dameEscaque(i, j)!=null) 
		{
			//System.out.println(i +"," +j); 
			
			Escaque e=tableroAjedrez.dameEscaque(i, j);
			if(!e.estaOcupado())
				a.add(new Movimiento(this,e,false));
			else 
			{	
				comer=true;
				if(tableroAjedrez.damePieza(i, j).blanca!=blanca)
					a.add(new Movimiento(this,e,true));
				
			}
		}
		return comer;
	}
	
	
	
	
	public boolean vive()	{		return estaViva;	}
	public void morir()
	{
		estaViva=false;
		pos=null;
	}

	public Jugador getJ() {		return j;	}
	public void setJ(Jugador j) {		this.j = j;	}
	
	
	
	public abstract String nombre();
		
	public abstract Object clone(TableroAjedrez t);
	
	
	public abstract ClaveEnumCompuesta dameClave();
	
	public abstract int dameValor();

	public int getId() {	return id;}
	public void setId(int id) {	this.id = id;}
	
	
	@Override
	public String toString() {
		String color=blanca?"BLANCA":"NEGRA";
		//String color=blanca?"BLANCA":"NEGRA";
		
		//////////////////PONER SI HA SIDO MOVIDA DE ALGUNA FORMA
		//return tipo+" "+color +" " +id;
		return tipo+" "+color +" " +id;
	}

	public void revivir()
	{
		estaViva=true;
		
	}

	public boolean isEsMovida() {
		return esMovida;
	}

	public void setEsMovida(boolean esMovida) {
		this.esMovida = esMovida;
	}

	public boolean isEstaViva() {
		return estaViva;
	}

	public void setEstaViva(boolean estaViva) {
		this.estaViva = estaViva;
	}

	public Posicion getPos() {
		return pos;
	}
	

}
