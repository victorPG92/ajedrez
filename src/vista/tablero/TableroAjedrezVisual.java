package vista.tablero;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import Juego.Escaque;
import Juego.movimientos.Movimiento;
import Juego.tableros.TableroAjedrez;
import Juego.util.Posicion;
import constantes.Constantes;
import piezas.Pieza;
import vista.mapper.fact.FactMapper;
import vista.oyente.oyenteRaton.OyenteRaton2;
import vista.ventana.VentanaAjedrez;

	
	

public class TableroAjedrezVisual extends TableroCreado 
{

	
		
		protected static final long serialVersionUID = 1L;
		protected Integer fila;
		protected Integer columna;
				
		protected TableroAjedrez tablero;
		protected final VentanaAjedrez vp;
			
		protected boolean escuchado;
		
		protected List<Movimiento> movimientos; // <Posicion>
		
		
		
		
		/**
		 * 
		 * @param vp ventana
		 */
		public TableroAjedrezVisual( final VentanaAjedrez vp)
		{
			
			init();
			
			this.vp=vp;
			
			tablero= vp.getJ().getT();
			escuchado=false;
			// this.addMouseListener(new OyenteRaton(this,vp));
		}
		
		
		public void actualiza()
		{
			
		}
		
		@Override
		public void paint(Graphics g)
		{
			
			
			
			init();
			if(!escuchado)
			{
				this.addMouseListener(new OyenteRaton2(vp));
				escuchado=true;
			}
			int x0 =0;
			int y0 =0;
			
			//if(t==null) System.out.println("tablero logico nulo en tablero visual");
			
			for(int i=0;i<Constantes.TAM;i++)
			{
				for(int j=0;j<Constantes.TAM;j++)
				{
					Escaque e =tablero.dameEscaque(i, j); 
					if(!e.isBlanca())	g.setColor(Color.BLACK);
					else 				g.setColor(Color.white);
					
					Pieza p= e.damePieza();
					
					
					g.fillRect(x0,y0, casX, casY); 
					
					
					if(p!=null)
					{
						dibujarPieza(g,p,x0,y0);
					}
					
					
					x0+=casX;
					
				}
				y0+=casY;
				x0= 0;
			}	
			
			if(fila !=null && columna !=null)
			{
				g.setColor(Color.green);
				
				for(int prec=0;prec < 10;prec++)
					g.drawRect(columna*casX +prec,fila*casY+prec,casY-prec/2,casX-prec/2);
			}
			
			colorearMovimientos(g);
			g.setColor(Color.MAGENTA);
			g.drawRect(0, 0,8*casX,8*casY ); //g.drawRect(0, 0,ancho,largo );
			
			
			
		}
			
			
			
		public void colorearMovimientos(Graphics g)
		{
			g.setColor(Color.blue);
			if(movimientos!=null)
			{
				for(Movimiento m: movimientos)
				{
					Escaque e =m.getEsqDest();
					Posicion pos = e.getPos();
					
					int x0=calculaX0(pos.getY());
					int y0=calculaY0(pos.getX());
					g.fillRect(x0,y0, casX, casY);  ////invertir x e y??
					
					Pieza p=e.damePieza();
					if(p!=null) dibujarPieza(g,p,x0,y0);
				}
			}
		}

		
		public int calculaX0(int c)
		{
			return c*casX;
		}
		public int calculaY0(int f)
		{
			return f*casY;
		}
		
		public void dibujarPieza(Graphics g, Pieza p, int x0, int y0)
		{
			//Image img = MapperPiezas.getInstancia().dameImagen(new Clave(p.nombre(),p.isBlanca(),e.isBlanca()));
			//Image img = FactMapper.getInst().creaMapper().dameImagen(p.dameTipo());
			
			Image img = FactMapper.getInst().creaMapper().dameImagen(p.dameClave());
			
			
			if(img==null)
			{
				//System.out.println(p.dameTipo() +" Imagen nula");
				//g.fillRect(x0,y0, casX, casY); 
			}
			else
			{
				int prec = 15;
				//g.setColor(Color.red);g.fillRect(x0,y0, casX, casY);
				g.drawImage(img, x0+prec/2, y0+prec/2,casX-prec,casY-prec, this);
				
				
			}
		}
		
		public Integer getFila() {			return fila;		}

		public void setFila(Integer fila) {			this.fila = fila;		}

		public Integer getColumna() {			return columna;		}

		public void setColumna(Integer columna) {			this.columna = columna;		}

		public List<Movimiento> getMovimientos() {			return movimientos;		}
		public void setMovimientos(List<Movimiento> movimientos) {			this.movimientos = movimientos;		}

		public TableroAjedrez getT() {			return tablero;		}
		public void setT(TableroAjedrez t) {			this.tablero = t;		}
		
		
		public void vaciar()
		{
			movimientos=new ArrayList<>();
			fila=null;
			columna=null;
		}
	
		
		@Override
		public String toString() {		return tablero.toString();		}
		

}
