package piezas.fact;

import piezas.Alfil;
import piezas.Caballo;
import piezas.Peon;
import piezas.Pieza;
import piezas.Reina;
import piezas.Rey;
import piezas.TipoFicha;
import piezas.Torre;
import Juego.tableros.TableroAjedrez;
import Juego.util.Posicion;

public class FactPiezasImp  extends FactPiezas
{
	
	private int numPeonesBlancos;
	private int numPeonesNegros;
	
	private int numCaballosBlancos;
	private int numCaballosNegros;
	
	private int numAlfilesBlancos;
	private int numAlfilesNegros;
	
	private int numTorresBlancas;
	private int numTorresNegras;
	
	
	
	protected FactPiezasImp()
	{
	  numPeonesBlancos=0;
	  numPeonesNegros=0;
	  
	  numCaballosBlancos=0;
	  numCaballosNegros=0;
	  
	  numAlfilesBlancos=0;
	  numAlfilesNegros=0;
	  
	  numTorresBlancas=0;
	  numTorresNegras=0;
	
	}
	
	
	public Pieza creaPieza(TipoFicha tf,boolean isBlanca, Posicion pos, TableroAjedrez t,int id)
	{
		Pieza p=null;
		
		switch(tf.name())
		{
			case  "PEON": 	
				if(isBlanca)	numPeonesBlancos++;
				else 			numPeonesNegros++;
				p =  new Peon(isBlanca,pos,t,id);
				break; 
			case  "ALFIL": 	
				if(isBlanca)	numAlfilesBlancos++;
				else 			numAlfilesNegros++;
				p =  new Alfil(isBlanca,pos,t,id);
				break; 
			case  "CABALLO": 
				if(isBlanca)	numCaballosBlancos++;
				else 			numCaballosNegros++;
				p =  new Caballo(isBlanca,pos,t,id);
				break; 
			case  "REY": 	
				p =  new Rey(isBlanca,pos,t);
				break; 
			case  "REINA": 	
				p =  new Reina(isBlanca,pos,t);
				break; 
			case  "TORRE": 	
				if(isBlanca)	numTorresBlancas++;
				else 			numTorresNegras++;
				p =  new Torre(isBlanca,pos,t,id);
				break; 
		};
		
		return p;
		
		
	}
	
	public Pieza creaPieza(TipoFicha tf,boolean isBlanca, Posicion pos, TableroAjedrez t)
	{
		Pieza p=null;
		int id=-1;
		switch(tf.name())
		{
			case  "PEON": 	
				//System.out.println("Creando peon "+ isBlanca);
				if(isBlanca)	numPeonesBlancos++;
				else 			numPeonesNegros++;
				id=isBlanca?numPeonesBlancos:numPeonesNegros;
				p =  new Peon(isBlanca,pos,t,id);
				break; 
			case  "ALFIL": 	
				if(isBlanca)	numAlfilesBlancos++;
				else 			numAlfilesNegros++;
				id=isBlanca?numAlfilesBlancos:numAlfilesNegros;
				p =  new Alfil(isBlanca,pos,t,id);
				break; 
			case  "CABALLO": 
				if(isBlanca)	numCaballosBlancos++;
				else 			numCaballosNegros++;
				id=isBlanca?numCaballosBlancos:numCaballosNegros;
				p =  new Caballo(isBlanca,pos,t,id);
				break; 
			case  "REY": 	
				p =  new Rey(isBlanca,pos,t);
				break; 
			case  "REINA": 	
				p =  new Reina(isBlanca,pos,t);
				break; 
			case  "TORRE": 	
				
				if(isBlanca)	numTorresBlancas++;
				else 			numTorresNegras++;
				id=isBlanca?numTorresBlancas:numTorresNegras;
				p =  new Torre(isBlanca,pos,t,id);
				break; 
		};
		
		return p;
		
		
	}
	
	public Pieza clonarPieza(Pieza p,TableroAjedrez t)
	{
		if(p==null) return null;
		return (Pieza)p.clone(t);
	}
	
	
	
	
	
	
	
	public static void main(String args [])
	{
		System.out.println((FactPiezas.getInst().creaPieza(TipoFicha.ALFIL, true, new Posicion(0,0), new TableroAjedrez(true))));
		
		
		System.out.println((FactPiezas.getInst().creaPieza(TipoFicha.TORRE, true, new Posicion(0,0), new TableroAjedrez(true))));
		System.out.println((FactPiezas.getInst().creaPieza(TipoFicha.PEON, true, new Posicion(0,0), new TableroAjedrez(true))));
	}


	@Override
	public void reiniciarCont() 
	{
		 numPeonesBlancos=0;
		 numPeonesNegros=0;
		
		 numCaballosBlancos=0;
		 numCaballosNegros=0;
		
		 numAlfilesBlancos=0;
		 numAlfilesNegros=0;
		
		 numTorresBlancas=0;
		 numTorresNegras=0;
		
	}
	

}
