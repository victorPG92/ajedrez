package Juego.tableros.rellenador;

import Juego.Escaque;
import Juego.tableros.TableroAjedrez;
import Juego.util.Posicion;
import piezas.TipoFicha;
import piezas.fact.FactPiezas;

public class RellenadorAjedrezInicio implements RellenadorTablero<TableroAjedrez>
{
	

	/**
	 * Metodo para crear las piezas de forma que se creen todas
	 */
	public void creaPiezas(TableroAjedrez t)
	{
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
			{
				 		
				Posicion pos= new Posicion(i,j);
				
				if(i==1)t.dameEscaque(pos).setPieza(FactPiezas.getInst().creaPieza(TipoFicha.PEON,true,pos,t));
				if(i==6)t.dameEscaque(pos).setPieza(FactPiezas.getInst().creaPieza(TipoFicha.PEON,false,pos,t));
				
				if(i==0)
				{
					if(j==0  || j==7 )	t.dameEscaque(pos).setPieza( FactPiezas.getInst().creaPieza(TipoFicha.TORRE,true,pos,t));
					if(j==1  || j==6 )	t.dameEscaque(pos).setPieza( FactPiezas.getInst().creaPieza(TipoFicha.CABALLO,true,pos,t));
					if(j==2  || j==5 )	t.dameEscaque(pos).setPieza( FactPiezas.getInst().creaPieza(TipoFicha.ALFIL,true,pos,t));
					if(j==3  )			t.dameEscaque(pos).setPieza( FactPiezas.getInst().creaPieza(TipoFicha.REY,true,pos,t));
					if(j==4  )			t.dameEscaque(pos).setPieza( FactPiezas.getInst().creaPieza(TipoFicha.REINA,true,pos,t));
				}
					
				if(i==7)
				{
					if(j==0  || j==7 )	t.dameEscaque(pos).setPieza( FactPiezas.getInst().creaPieza(TipoFicha.TORRE,false,pos,t));
					if(j==1  || j==6 )	t.dameEscaque(pos).setPieza( FactPiezas.getInst().creaPieza(TipoFicha.CABALLO,false,pos,t));
					if(j==2  || j==5 )	t.dameEscaque(pos).setPieza( FactPiezas.getInst().creaPieza(TipoFicha.ALFIL,false,pos,t));
					if(j==4  )			t.dameEscaque(pos).setPieza( FactPiezas.getInst().creaPieza(TipoFicha.REINA,false,pos,t));
					if(j==3  )			t.dameEscaque(pos).setPieza( FactPiezas.getInst().creaPieza(TipoFicha.REY,false,pos,t));
				}
				
				
			}	
		
	
		t.cogerPiezas();
	}
	
	
	/*
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
	
	 * */

}
