package damas;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import Juego.Escaque;
import Juego.util.Posicion;
import movimientos.Movimiento;
import movimientos.MovimientoEncadenado;
import piezas.Pieza;
import piezas.TipoFicha;
import tableros.Tablero;
import tableros.TableroAjedrez;
import tableros.TableroDamas;
import vista.mapper.claves.ClaveEnumCompuesta;

public class Dama extends Pieza{
	
	boolean esReina;//o pieza a parte , se puede reutilizar con un bucle for para recorrer diagonal
	
	private static int idInc=0;
	public Dama(boolean b, Posicion pos, TableroDamas t) 
	{
		this.blanca=b;
		this.pos=pos;
		this.tableroAjedrez=t;
		id= idInc++;
		tipo= TipoFicha.DAMA;
	}

	@Override
	public char getSigla() {
		if(esReina)
			return 'D';
		return 'd';
	}

	@Override
	public List<Movimiento> movimientos() 
	{
		System.out.println("consultando movs de dama");
		List<Movimiento> movs= new ArrayList<>();
		
		//movs.addAll(dameMovimientosDesde(tableroAjedrez.dameEscaque(pos)));
		
		Escaque esc= tableroAjedrez.dameEscaque(pos);
		
		if(esReina)
			movs= dameMovsReina(esc);
		
		else
			movs= dameMovimientosDesdeHaciaSimpleYEncadenados(esc);
		
		return movs;
		
	}
	
	private List<Movimiento> dameMovsReina(Escaque esc) 
	{

		List<Movimiento> movs = new ArrayList<>();
		
		movs.addAll(dameMovimientosDesdeHaciaSimpleYEncadenados(esc));
		
		System.out.println("movimientos derecha");
		movs.addAll(dameMovsCompuestosReina(esc, false));
		System.out.println("movimientos izqda");
		movs.addAll(dameMovsCompuestosReina(esc, true));

		return movs;

	}

	public List<Movimiento> dameMovimientosDesdeHaciaSimpleYEncadenados(Escaque esc)
	{
		
		List<Movimiento> movs = new ArrayList<>();
		
		System.out.println("movimientos derecha");
		movs.addAll(dameMovsCompuestos(esc, false));
		System.out.println("movimientos derecha");
		movs.addAll(dameMovsCompuestos(esc, true));

		return movs;
	
	}
	
	private List<? extends Movimiento> dameMovsCompuestos(Escaque esc, boolean izqda )
	{
		//return dameMovsCompuestos(esc, izqda, 1);
		return dameMovsCompuestos(esc, izqda, 1/*isBlanca()?1:-1*/);

	}
	
	private List<? extends Movimiento> dameMovsCompuestosReina(Escaque esc, boolean izqda )
	{
		List<Movimiento> movs= new ArrayList<>();
		for(int i=1; i<8;i++)
		{
			if(i==3)
				System.out.println("test");
			
			Escaque escAv1=dameEscaqueDiagonal(esc,izqda ,i );
			

			movs.addAll(dameMovsCompuestos(esc, izqda,i));
			
			if(escAv1!=null && escAv1.estaOcupado())
				break;
		}
		
		for(int i=1; i<8;i++)
		{
			Escaque escAv1=dameEscaqueDiagonal(esc,izqda ,-i );
			
			movs.addAll(dameMovsCompuestos(esc, izqda,-i));
			
			if(escAv1!=null && escAv1.estaOcupado())
				break;

		}
		
		return  movs;
	}
	
	private List<? extends Movimiento> dameMovsCompuestos(Escaque esc, boolean izqda ,int ind)
	{
		
		List<Movimiento> movs= new ArrayList<>();
		
		Escaque escAv1=dameEscaqueDiagonal(esc,izqda ,ind );
		
		
		if(escAv1!=null)//si no se sale del tablero
		{
			//la casilla esta libre y no come, movimiento simple y se para ahi
			if(!escAv1.estaOcupado())
			{
				System.out.println("el escaque "+escAv1 +" esta libre y lo podemos usar");
				movs.add(new Movimiento(this, escAv1, false));
			}
			else if(piezaEsContraria(escAv1))
			{
				System.out.println("el escaque "+escAv1 +" esta ocupado por pieza de otro color y debemos ver si lo podemos saltar");

				int sig= ind>0? ind+1:ind-1;
				Escaque escIzqda2=dameEscaqueDiagonal(esc, izqda, sig);
				//Escaque escDcha2=dameEscaqueDiagonal(esc, false, 2);
				
				System.out.println("comprobar el escaque "+escIzqda2 );

				if(((TableroDamas)tableroAjedrez).sePuedeir(escIzqda2))//escIzqda2!==null && !escIzqda2.estaOcupado())
				{
					System.out.println("El escaque "+escIzqda2 +" esta libre");
					Pieza piezaComida= escAv1.damePieza();
					//movimient despues de saltar 2: 
					MovimientoEncadenado movEncIzqda= new MovimientoEncadenado(this,escIzqda2, piezaComida);
					
					
					movs.addAll(encadenaMov(movEncIzqda, getMovimientosComer(escIzqda2)));
					//movEncIzqda.concatenaMov(movEnc);
				}
				else
				{
					System.out.println("El escaque "+escIzqda2 +" esta ocupado");
				}
				
			}
			else
			{
				System.out.println("el escaque "+escAv1 +" esta ocupado por pieza del mismo color y no se puede  saltar");

			}
		}
		
		return movs;
	}

	
	private List<? extends Movimiento> dameMovsCompuestos2(Escaque esc, boolean izqda )
	{
		
		List<Movimiento> movs= new ArrayList<>();
		
		Escaque escAv1=dameEscaqueDiagonal(esc,izqda ,1 );
		
		
		if(escAv1!=null)//si no se sale del tablero
		{
			//la casilla esta libre y no come, movimiento simple y se para ahi
			if(!escAv1.estaOcupado())
			{
				System.out.println("el escaque "+escAv1 +" esta libre y lo podemos usar");
				movs.add(new Movimiento(this, escAv1, false));
			}
			else if(piezaEsContraria(escAv1))
			{
				System.out.println("el escaque "+escAv1 +" esta ocupado por pieza de otro color y debemos ver si lo podemos saltar");

				Escaque escIzqda2=dameEscaqueDiagonal(esc, izqda, 2);
				//Escaque escDcha2=dameEscaqueDiagonal(esc, false, 2);
				
				System.out.println("comprobar el escaque "+escIzqda2 );

				if(((TableroDamas)tableroAjedrez).sePuedeir(escIzqda2))//escIzqda2!==null && !escIzqda2.estaOcupado())
				{
					System.out.println("El escaque "+escIzqda2 +" esta libre");
					Pieza piezaComida= escAv1.damePieza();
					//movimient despues de saltar 2: 
					MovimientoEncadenado movEncIzqda= new MovimientoEncadenado(this,escIzqda2, piezaComida);
					
					
					movs.addAll(encadenaMov(movEncIzqda, getMovimientosComer(escIzqda2)));
					//movEncIzqda.concatenaMov(movEnc);
				}
				else
				{
					System.out.println("El escaque "+escIzqda2 +" esta pcupado");
				}
				
			}
			else
			{
				System.out.println("el escaque "+escAv1 +" esta ocupado por pieza del mismo color y no se puede  saltar");

			}
		}
		
		return movs;
	}

	
	
	private boolean piezaEsContraria(Escaque esc) {
		return esc.damePieza().isBlanca()!=this.blanca;
	}

	public Escaque dameEscaqueDiagonal(Escaque esc, boolean izqda, int numAvance)
	{
		int avance= isBlanca()?1:-1;
		avance*= numAvance;
		int orientacion= izqda?-1:1;
		orientacion*=numAvance;
		
		//Posicion posDiagon1= esc.getPos().addAnotherVector(orientacion, avance);

		Posicion posDiagon1= esc.getPos().addAnotherVector( avance, orientacion);
		
		return tableroAjedrez.dameEscaque(posDiagon1);
	}
	
	
	
	/**
	 * crea un mov simple en diagonal, se mueve en 1
	 * @return
	 */
	public Movimiento crearMov(Posicion posAnt, Posicion posSig)
	{
		if(tableroAjedrez.estaOcupada(posSig))
		{
			return null;
		}
		else
		{
			return crearMovSimple(posAnt, posSig);
		}
			
		
		
	}
	
	public Movimiento crearMovSimple(Posicion posAnt, Posicion posSig)
	{
		return new Movimiento(this, tableroAjedrez.dameEscaque(posSig), false);
	}
	
	
	public List<MovimientoEncadenado> getMovimientosComer(Escaque esc) 
	{
	
		System.out.println("ver movs comer sobre "+ esc);
		List<MovimientoEncadenado> movs= new ArrayList<>();
		
		//excepto que sea reina
		
		//la siguiente debe estar ocupada:
		int avance=1;//int avance= isBlanca()?1:-1;
		
		//y las siguientes libres:
		int avance2= 2*avance; //asi en el bule for  el 2 sera i
		//isBlanca()?2:-2;
		
		System.out.println("es " +(isBlanca()?" blanca ":" negra ")+ " y avanza "+ avance );
		
		/*
		Posicion posDiagonIzqda= posActual.addAnotherVector(-1, avance);
		Posicion posDiagonDcha= posActual.addAnotherVector(1, avance);
		*/
		
		for(boolean izq: new boolean[]{false,true})
		{
			Escaque escIzqda= dameEscaqueDiagonal(esc, izq, avance);
			Escaque escIzqda2= dameEscaqueDiagonal(esc, izq, avance2);
			
			System.out.println("revisando "+ escIzqda + " y " + escIzqda2);
			if(escIzqda !=null && escIzqda.estaOcupado() && escIzqda.damePieza().isBlanca()!=blanca && escIzqda2!=null && !escIzqda2.estaOcupado())//   //!((TableroDamas)tableroAjedrez).sePuedeir(escIzqda)
			{
				Pieza piezaComida= escIzqda.damePieza();
				MovimientoEncadenado mov1= new MovimientoEncadenado(this, escIzqda2, piezaComida);
				
				List<MovimientoEncadenado> movsHijos = getMovimientosComer(escIzqda2);
				
				List<MovimientoEncadenado> movsEncs = encadenaMov(mov1, movsHijos);
				movs.addAll(movsEncs);
			}
		}
		
		
		return movs;
	}
	
	public List<MovimientoEncadenado> encadenaMov(MovimientoEncadenado movOrigen,
			List<MovimientoEncadenado> movHijos)
	{
	
		List<MovimientoEncadenado> movs= new ArrayList<>();
		movs.add(movOrigen);
		
		movHijos.forEach(m->
		{
			try {
				
				MovimientoEncadenado movHijo1 = (MovimientoEncadenado) movOrigen.clone();
				movHijo1.concatenaMov(m);
				movs.add(movHijo1);

			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			
		});
		
		return movs;
			
			
		//=new MovimientoEncadenado(movOrigen);
	}
	
	@Override
	public String nombre() {
		
		return "dama";
	}

	@Override
	public Object clone(TableroAjedrez t) {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ClaveEnumCompuesta dameClave() {
		//return ClaveEnumCompuesta.DAMA
		return null;
	}

	@Override
	/**
	 * Todas valen igual excepto si son reinas
	 */
	public int dameValor() {
		
		if(esReina)
			return 5;
		return 1;
	}

	public final boolean isEsReina() {
		return esReina;
	}

	public Dama setEsReina(boolean esReina) {
		this.esReina = esReina;
		return this;
	}

	public MovimientoEncadenado getMovimiento(Posicion[] movimientoElegido) {

		try {
			
		List<Escaque> escques= tableroAjedrez.dameEscaques(movimientoElegido);
		return 
		movimientos().
			stream().
			filter(m-> m instanceof MovimientoEncadenado).
			map(m-> (MovimientoEncadenado)m).
			filter(m-> m.sigueCaminoEnDestino(escques, true)).
			findFirst().
			get();
		} catch (NoSuchElementException e) {
			 return null;
		}
	}
	
	

	
}
