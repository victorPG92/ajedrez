package tableros;

import java.util.ArrayList;
import java.util.List;

import Juego.Escaque;
import Juego.util.Posicion;
import constantes.Constantes;
import movimientos.Movimiento;
import movimientos.MovimientoEncadenado;
import movimientos.MovimientoEnroque;
import piezas.Pieza;
import piezas.TipoFicha;
import piezas.fact.FactPiezas;

public class TableroAjedrez extends TableroCuadrado
{

	public static final int NUM_FILAS=8;
	public static final int NUM_COL=8;
	
	
	
	public TableroAjedrez(/*boolean crears*/)
	{
		casillas = new Escaque[8][8];
		boolean enr=true;
		construyeTablero();
		/*
		if(crears)
		{
			
			cogerPiezas();
		}*/
	}
	
	private void construyeTablero()
	{
		for(int i=0;i<NUM_FILAS;i++)
		{
			for(int j=0;j<NUM_COL;j++)
			{
				 		
				boolean blanco=( (i+j) %2 == 0);
				casillas[i][j]=new Escaque(new Posicion(i,j),blanco);
		
			}
		}
	}
	
	/**
	 * Metodo para crear las piezas de forma que se creen todas
	 */
	/*private void creaPiezas()
	{
		boolean blanco=true;
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
			{
				 		
				blanco=( (i+j) %2 == 0);
				casillas[i][j]=new Escaque(new Posicion(i,j),blanco);
				Posicion pos = new Posicion(i,j);
				if(i==1)casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.PEON,true,pos,this),blanco);
				if(i==6)casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.PEON,false,pos,this),blanco);
				//if(i==6)casillas[i][j]=new Escaque(pos, new Peon(false,pos,this),blanco);
				
				if(i==0)
				{
					if(j==0  || j==7 )	casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.TORRE,true,pos,this),blanco);
					if(j==1  || j==6 )	casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.CABALLO,true,pos,this),blanco);
					if(j==2  || j==5 )	casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.ALFIL,true,pos,this),blanco);
					if(j==3  )			casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.REY,true,pos,this),blanco);
					if(j==4  )			casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.REINA,true,pos,this),blanco);
				}
					
				if(i==7)
				{
					if(j==0  || j==7 )	casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.TORRE,false,pos,this),blanco);
					if(j==1  || j==6 )	casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.CABALLO,false,pos,this),blanco);
					if(j==2  || j==5 )	casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.ALFIL,false,pos,this),blanco);
					if(j==4  )			casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.REINA,false,pos,this),blanco);
					if(j==3  )			casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.REY,false,pos,this),blanco);
				}
				
				
			}	
	}
	*/
	/**
	 * Metodo para crear las piezas de forma que se creen para favorecer el enroque y hacer pruebas
	 */
	/*private void crearEnroque()
	{
		boolean blanco=true;
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
			{
				 		
				blanco=( (i+j) %2 == 0);
				casillas[i][j]=new Escaque(new Posicion(i,j),blanco);
				Posicion pos = new Posicion(i,j);
				if(i==1)casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.PEON,true,pos,this),blanco);
				if(i==6)casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.PEON,false,pos,this),blanco);
				//if(i==6)casillas[i][j]=new Escaque(pos, new Peon(false,pos,this),blanco);
				
				if(i==0)
				{
					if(j==0  || j==7 )	casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.TORRE,true,pos,this),blanco);
					if(j==1  || j==6 )	casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.CABALLO,true,pos,this),blanco);
					if(j==2  || j==5 )	casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.ALFIL,true,pos,this),blanco);
					if(j==3  )			casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.REY,true,pos,this),blanco);
					if(j==4  )			casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.REINA,true,pos,this),blanco);
				}
					
				if(i==7)
				{
					if(j==0  || j==7 )	casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.TORRE,false,pos,this),blanco);
					if(j==1  || j==6 )	casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.CABALLO,false,pos,this),blanco);
					if(j==2  || j==5 )	casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.ALFIL,false,pos,this),blanco);
					if(j==4  )			casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.REINA,false,pos,this),blanco);
					if(j==3  )			casillas[i][j]=new Escaque(pos, FactPiezas.getInst().creaPieza(TipoFicha.REY,false,pos,this),blanco);
				}
				
				
			}	
	}
	
	
	*/
	
	
	public boolean sePuedeir(Posicion pos,boolean color)
	{
		//dame escaque no lanza excepcion y si se sale del tablero devuelve null.
		Escaque esc= dameEscaque(pos);
		return sePuedeir(esc,color);
	}
	
	/**
	 * En el ajedrez a un escaque se puede ir si :
	 * si entra en el rango del tablero
	 * y si no esta ocupado o lo esta pero por una pieza de otro color comiendola
	 * @param esc
	 * @return
	 */
	public boolean sePuedeir(Escaque esc, boolean color)
	{
		//no se puede ir porque no existe
		if(esc==null)
			return false;
		
		return
			!esc.estaOcupado() || esc.damePieza().isBlanca()!=color;
	}

	
	
	
	
	
	/**
	 * Realiza el movimiento 
	 * comprueba si se puede
	 * @param movimientoEnConstruccion
	 * @return
	 */
	public boolean realizarMovimiento(Movimiento m) 
	{
		System.out.println("Realizando mov en tablero "+ m );
		if(m instanceof MovimientoEnroque || m.isEnroque())
			return realizarMovimientoEnr((MovimientoEnroque) m);
		
		
		//System.out.println("Haciendo mov "+ m);
		Pieza p= m.getPieza();
		if(!p.fueMovida())
		{
			p.setMovida(true);
			m.setFueMovida(false);
		}
		Escaque origen= dameEscaque(p.damePosicion());
		origen.extraePieza();
				
		moverComerPiezas(m);
				
		return true;
	}

	
	protected void moverComerPiezas(Movimiento m)
	{
		System.out.println("comer piezas ajedrez");
		Escaque dest= m.getEsqDest();

		Pieza piezaComida=dest.extraePieza();
		if(piezaComida!=null)
			piezaComida.morir();
		m.setPiezaComida(piezaComida);
		
		Pieza p= m.getPieza();

		dest.recibirPieza(p, m.isComer());		
	}

	public boolean deshacerMovimiento(Movimiento m) 
	{
		if(m==null) return false;
		
		if(m instanceof MovimientoEnroque || m.isEnroque())
			return deshacerMovimientoEnr((MovimientoEnroque) m);
		
		if(m instanceof MovimientoEncadenado)
			return deshacerMovimientoEncadenado((MovimientoEncadenado) m);
		
		return deshacerMovSimple(m);
		//System.out.println("DesHaciendo mov "+ m);
			
	}
	
	private boolean deshacerMovSimple(Movimiento m) {
		Pieza p= m.getPieza();
	
		
		Escaque origen= dameEscaque(m.damePosOrigen());
		
		origen.recibirPieza(p, false);
		Escaque dest= m.getEsqDest();
		
		Pieza pcom=m.getPiezaComida();
		if(pcom!=null)
			pcom.revivir();
		dest.recibirPieza(pcom, false);
		
		//System.out.println("la pieza fue movida antes del mov? " + m.habiaSidoMovidaAntesdeEsteMov());
		p.setMovida(m.habiaSidoMovidaAntesdeEsteMov());
		//System.out.println("la pieza ha sido movida? "+p.fueMovida());
		
		return true;
	
	}

	private boolean deshacerMovimientoEncadenado(MovimientoEncadenado m) {
		if(m.getMovSig()!=null)
			deshacerMovimientoEncadenado(m.getMovSig());
		
		deshacerMovSimple(m);
		if(m.isPromociona())
		{
			
		}
			
		return false;
	}

	/**
	 * Realiza el movimiento 
	 * comprueba si se puede
	 * @param movimientoEnConstruccion
	 * @return
	 */
	public boolean realizarMovimientoEnr(MovimientoEnroque m) 
	{
		
		System.out.println("realizar enroque");
		
		System.out.println("Cogiendo rey "+ m.getRey());
		
		Escaque nuevaRey= m.getPosFuturaRey();
		if(nuevaRey!=null)
		nuevaRey.recibirPieza(m.getRey(), false);
		extraePieza(m.getPosRey());
		System.out.println("Moviendo a "+nuevaRey);
		
		
		System.out.println("Cogiendo torre "+ m.getTorre());
		Escaque nuevaTorre= m.getPosFuturaTorre();
		nuevaTorre.recibirPieza(m.getTorre(), false);
		//if()
		extraePieza(m.getPosTorre());
		System.out.println("Moviendo a "+nuevaTorre);
		
		
		return true;
	}

	
	public boolean deshacerMovimientoEnr(MovimientoEnroque m) 
	{
		
		Escaque nuevaRey= m.getPosFuturaRey();
		Escaque nuevaTorre= m.getPosFuturaTorre();
		
		Escaque antRey=  dameEscaque(m.getPosRey());
		Escaque antTorre=dameEscaque(m.getPosTorre());
		if(nuevaRey!=null && nuevaTorre!=null )
		{
			
			antRey.recibirPieza(m.getRey(), false);
			extraePieza(nuevaRey.getPos());
			
			antTorre.recibirPieza(m.getTorre(), false);
			extraePieza(nuevaTorre.getPos());
			
			m.getRey().setMovida(false);
			m.getTorre().setMovida(false);
			
			return true;
			
		}
		
		return false;
		
		
		
		
	}
	
	
	public String toString()
	{
		return toStringConId();
	}
	
	public String toStringConIdmOV()
	{
		StringBuffer sb= new StringBuffer();
		
		for(int i=0;i<Constantes.TAM;i++)
		{	for(int j=0;j<Constantes.TAM;j++)
			{
				Pieza p=damePieza(i,j);
				if(p==null) sb.append("----");
				else
				{
					if(p.vive())
					{
					char c=p.getSigla();
					if(p.isBlanca())
						sb.append(c);  //damePieza(i,j).toString()
					else
						sb.append(Character.toLowerCase(c));  //damePieza(i,j).toString()
					int id=p.getId();
					if(id<10)
						sb.append('0');
					sb.append(id);
					if(p.fueMovida())sb.append("M");
					else sb.append(".");
					}
					else 
						sb.append("XXXx");
				}
			}
		sb.append('\n');
		}
		
		return sb.toString();
	}
	
	public String toStringConId()
	{
		StringBuffer sb= new StringBuffer();
		
		for(int i=0;i<Constantes.TAM;i++)
		{	for(int j=0;j<Constantes.TAM;j++)
			{
				Pieza p=damePieza(i,j);
				if(p==null) sb.append("---");
				else
				{
					if(p.vive())
					{
					char c=p.getSigla();
					if(p.isBlanca())
						sb.append(c);  //damePieza(i,j).toString()
					else
						sb.append(Character.toLowerCase(c));  //damePieza(i,j).toString()
					int id=p.getId();
					if(id<10)
						sb.append('0');
					sb.append(id);
					}
					else 
						sb.append("XXX");
				}
			}
		sb.append('\n');
		}
		
		return sb.toString();
	}
	public String toStringSinid()
	{
		StringBuffer sb= new StringBuffer();
		
		for(int i=0;i<Constantes.TAM;i++)
		{	for(int j=0;j<Constantes.TAM;j++)
			{
				Pieza p=damePieza(i,j);
				if(p==null) sb.append("-");
				else
				{
				
					char c=p.getSigla();
					if(p.isBlanca())
						sb.append(c);  //damePieza(i,j).toString()
					else
						sb.append(Character.toLowerCase(c));  //damePieza(i,j).toString()
				
				}
			}
		sb.append('\n');
		}
		
		return sb.toString();
	}
	
	
	
	
	public boolean equals(Object o)
	{
		TableroAjedrez t = (TableroAjedrez)o;
	
		boolean b=true;
		
		for(int i=0;i<Constantes.TAM && b;i++)
		{	for(int j=0;j<Constantes.TAM && b;j++)
			{
			
				if(!t.estaOcupada(i, j) && !this.estaOcupada(i, j))
				{}
				else if(t.estaOcupada(i, j) && this.estaOcupada(i, j))
				{
					if(!t.damePieza(i,j).dameTipo().equals(this.damePieza(i, j).dameTipo())) 
						{b=false;break;}
				}
				else {b=false;break;}
			}
		}
		return b;
	}
	
	public Object clone()
	{
		TableroAjedrez t= new TableroAjedrez();
		for(int i=0;i<Constantes.TAM;i++)
			for(int j=0;j<Constantes.TAM;j++)
			{
				t.casillas[i][j] = new Escaque(new Posicion(i,j),(Pieza)FactPiezas.getInst().clonarPieza(damePieza(i, j),t),casillas[i][j].isBlanca());
				//t.casillas[i][j]=(Escaque)casillas[i][j].clone();
				//if(t.estaOcupada(i, j))casillas[i][j].recibirPieza((Pieza)FactPiezas.getInst().clonarPieza(t.damePieza(i, j),t),false);
			}
		t.cogerPiezas();
		return t;
	}

	public List<Escaque> dameEscaques(Posicion[] movimientoElegido) 
	{
		List<Escaque> escaques= new ArrayList<>();
		for (Posicion posicion : movimientoElegido) {
			//if not null
			escaques.add(dameEscaque(posicion));
		}
		return escaques;
	}

	

	
	
	
	/*
	public static void main(String args [])
	{
		System.out.println((new Tablero()).toString());
	}*/
	
	

	/*
	public String toString()
	{
		StringBuffer sb= new StringBuffer();
		
		for(int i=0;i<8;i++)
		{	for(int j=0;j<8;j++)
			{
				sb.append(i);
				sb.append(',');
				sb.append(j);
				
				if(damePieza(i,j)==null) sb.append('-');
				else sb.append(damePieza(i,j).getC());  //damePieza(i,j).toString()
				
				sb.append('\n');
			}
		sb.append('\n');
		}
		
		return sb.toString();
	}
	
	
	
	*/
	
	/*
	 * if(i==1)casillas[i][j]=new Escaque(pos, new Peon(true,pos,this),blanco);
				if(i==6)casillas[i][j]=new Escaque(pos, new Peon(false,pos,this),blanco);
				
				if(i==0)
				{
					if(j==0  || j==7 )	casillas[i][j]=new Escaque(pos, new Torre(true,pos,this),blanco);
					if(j==1  || j==6 )	casillas[i][j]=new Escaque(pos, new Caballo(true,pos,this),blanco);
					if(j==2  || j==5 )	casillas[i][j]=new Escaque(pos, new Alfil(true,pos,this),blanco);
					if(j==3  )			casillas[i][j]=new Escaque(pos, new Rey(true,pos,this),blanco);
					if(j==4  )			casillas[i][j]=new Escaque(pos, new Reina(true,pos,this),blanco);
				}
					
				if(i==7)
				{
					if(j==0  || j==7 )	casillas[i][j]=new Escaque(pos, new Torre(false,pos,this),blanco);
					if(j==1  || j==6 )	casillas[i][j]=new Escaque(pos, new Caballo(false,pos,this),blanco);
					if(j==2  || j==5 )	casillas[i][j]=new Escaque(pos, new Alfil(false,pos,this),blanco);
					if(j==3  )			casillas[i][j]=new Escaque(pos, new Reina(false,pos,this),blanco);
					if(j==4  )			casillas[i][j]=new Escaque(pos, new Rey(false,pos,this),blanco);
				}
	 */
	
}
