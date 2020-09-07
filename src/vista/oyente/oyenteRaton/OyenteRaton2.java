package vista.oyente.oyenteRaton;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Excepciones.ExcepcionJaqueMate;
import Juego.Escaque;
import Juego.Juego;
import Juego.JuegoAjedrez;
import Juego.JuegosDamas;
import constantes.Estado;
import constantes.Mensajes;
import entradaSalida.SalidaDatosVentana;
import piezas.Pieza;
import vista.tablero.TableroAjedrezVisual;
import vista.ventana.VentanaAjedrez;

public class OyenteRaton2 implements MouseListener
{
	//private JuegoSinMemento2 j;
	//private TableroAjedrezVisual t;
	private VentanaAjedrez v;
	private Integer fila;
	private Integer columna;
	private int casX;
	private int casY;
	
	private int estado;
	
	
	public OyenteRaton2(VentanaAjedrez v) //TableroCreado t, VentanaAjedrez v
	{
		//this.j=v.getJ(); //j;            ghdfghdfgh
		TableroAjedrezVisual t=v.getCanvas();   //j.getT();
		this.v=v;
		
		fila= t.getColumna();
		columna=t.getFila();
		casX= t.getCasX();
		casY=t.getCasY();
		
		this.estado = v.getEstado();
		
	}
	
	 public void comportamiento(MouseEvent m)
	 {
		Point p = m.getPoint();
		fila=		p.y/casY; //fila=(p.x+getX())/8
		columna=	p.x/casX;
		
		//System.out.println(p.x +","+p.y+" -> " +fila + " " +columna +"tamCas"+ casX + " ," +casY);
		Graphics g=v.getCanvas().getGraphics();
		//g.drawLine(p.x, p.y, p.x+1, p.y+1);
			
		
		if(estado==Estado.ELEGIR_CASILLA_INICIAL)
		{
			//v.setPieza(elegirCasillaInicial());
			//v.getJ().setP(elegirCasillaInicial());
			elegirCasillaInicial();
			System.out.println("fin casilla inicial");
			
		}
		else if(estado==Estado.ELEGIR_CASILLA_DESTINO)
		{
			elegirCasillaDestino();
			
		}
		else if(estado==Estado.ELEGIR_CASILLA_INICIAL_JAQUE)
		{
			elegirCasillaInicial();
			//elegirCasillaInicialJaque();
			
		}
		else if(estado==Estado.ELEGIR_CASILLA_DESTINO_JAQUE)
		{
			//elegirCasillaDestinoJaque();
			elegirCasillaDestino();
		}
		else if(estado==Estado.JAQUE_MATE)
		{
			SalidaDatosVentana.mostrarError("JAQUE_MATE");
			//elegirCasillaDestinoJaque();
			//elegirCasillaDestino();
		}
		
		
		
	 }
	 
	 
	public Pieza elegirCasillaInicial()
	{
		
		//System.out.println("eligiendo casilla inicial");
		Pieza pieza;
		try
		{
			Juego j= v.getJ();
			/*
			if(j.comprobarJaque())
			{
				
				SalidaDatosVentana.mostrarError(  "Estas en jaque");
				j.comprobarJaqueMateMovs();
			}
			*/
			pieza = v.getJ().jugarCasillaInicial(fila, columna);
			 
			System.out.println("fin de casilla inicial en funcion");
				/*		
			v.getTxtFila().setText(Integer.toString(fila));
			v.getTxtColumna().setText(Integer.toString(columna));
			*/
			
			TableroAjedrezVisual t=v.getCanvas();
			
			t.setFila(fila);
			t.setColumna(columna);
						
			t.setMovimientos(j.getMovsPosibles());//pieza.movimientos());
			
			v.setEstado(Estado.ELEGIR_CASILLA_DESTINO);
			estado=Estado.ELEGIR_CASILLA_DESTINO;
			
			//se cambia tambien en ventana al ser integer?
					
			v.repaint();
			t.repaint();
			
			return pieza;
		}
		/*
		catch(ExcepcionNoPieza e)
		{
			SalidaDatosVentana.casillaNoValida(e.getMessage());
			//SalidaDatosVentana.casillaVacia();
			//e.printStackTrace();
		}
		catch(ExcepcionEscaqueFueraDeRango e)
		{
			SalidaDatosVentana.casillaNoValida(e.getMessage());
			//SalidaDatosVentana.noCasilla();
			//e.printStackTrace();
		}
		catch(ExcepcionPiezaDeOtroJugador e)
		{
			SalidaDatosVentana.casillaNoValida(e.getMessage());
			//SalidaDatosVentana.noCasillaMia();
			//e.printStackTrace();
		}
		catch(ExcepcionPiezaSinMovimientos e)
		{
			//pieza=null;
			SalidaDatosVentana.noCasillaMia();
			//e.printStackTrace();
		}*/
		catch(NullPointerException e)
		{
			comportamientoNUllPointerException(e);
			return null;
		}
		catch(Exception e)
		{
			SalidaDatosVentana.mostrarError(e.getMessage());
			return null;
			
			//System.err.println("Juego "+ j);
			//System.err.println("Fila "+ fila +" Columna "+ columna);
			//SalidaDatosVentana.casillaNoValida();
			
			//e.printStackTrace();
		}
		//return null;
	}

	public void elegirCasillaDestino()
	{

		
		try
		{
			Juego j= v.getJ();
			//Juego j =Caretaker.getInst().dameEstado().dameEstado();
			
			
			//Pieza pieza = j.getP();
			//ArrayList<Movimiento> movs = pieza.movimientos();
			
			//j.jugarCasillaDestino(fila, columna,pieza,movs);
			
			//System.out.println("Eligiendo casilla destino \n"+ j.getT());
			Escaque destino=j.getT().dameEscaque(fila, columna);
			if(destino.estaOcupado() && destino.damePieza().isBlanca()==j.isTurno())
			{
				elegirCasillaInicial();
				
				return;
			}
			
			
			//System.out.println("jugando casilla destino \n"+ j.getT());
			//puedo comprobar antes, si se puede mover
			boolean turnoAnt= j.isTurno();
			//while(turnoAnt== j.isTurno()) no se pude porque hay que volver a pulsar
			//{
				System.out.println("Jugando "+ j.isTurno());
				System.out.println();
				j.jugarCasillaDestino(fila, columna);//,pieza,movs);
				v.repaint();

			//}
			/*
			v.getTxtFila().setText(Integer.toString(fila));
			v.getTxtColumna().setText(Integer.toString(columna));
			*/
				
			TableroAjedrezVisual t=v.getCanvas();
			
			t.setFila(fila);
			t.setColumna(columna);
			
			if(j.isTurnoFinalizado())
			{
			
			//t.setMovimientos(null);
			//j.cambiarTurno();
			//System.out.println("Cambio de turno:Le toca a " +j.isTurno());
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
				v.repaint();
				
				System.out.println(t);
				//System.out.println("comprobar jaque");
				
				if(j instanceof JuegoAjedrez)
				{
					JuegoAjedrez jAjedrez= (JuegoAjedrez) j;
					boolean enJaque=jAjedrez.comprobarJaque();
					//System.out.println(t);
					if(!enJaque)
					{
						v.setEstado(Estado.ELEGIR_CASILLA_INICIAL);
						estado=Estado.ELEGIR_CASILLA_INICIAL;
					}
					else
					{
						System.out.println("en jaque .");
						
						//boolean jaqueMate=j.comprobarJaqueMate();
						boolean jaqueMate=JuegoAjedrez.comprobarJaqueMate(j.getT(),j.isTurno());
						System.out.println("comprobado en mate");
						System.out.println(t);
						if(!jaqueMate)
						{
							System.out.println("No es mate");
							v.setEstado(Estado.ELEGIR_CASILLA_INICIAL_JAQUE);
							estado=Estado.ELEGIR_CASILLA_INICIAL_JAQUE;
							
							String jug;
							if(j.isTurno()) jug = "Blancas";
							else	jug = "Negras";
							SalidaDatosVentana.mostrarError(jug+ " estan en jaque");
						}
						else
						{
							System.out.println(" es MATE");
							System.err.println(" es MATE");
							v.setEstado(Estado.JAQUE_MATE);
							estado=Estado.JAQUE_MATE;
							throw new ExcepcionJaqueMate("JAQUE MATE:"+ j.getGanadores());
						}
					}
				}
				else if(j instanceof JuegosDamas)
				{
					System.err.println("es damas");
					if(((JuegosDamas)j).comprobarFin())
					{
						System.err.println("fin damas");
						v.setEstado(Estado.JAQUE_MATE);
						estado=Estado.JAQUE_MATE;
						throw new ExcepcionJaqueMate("JAQUE MATE: Ganador "+ j.getGanadores());
					}
					else
					{
						System.err.println("sigue damas");
						v.setEstado(Estado.ELEGIR_CASILLA_INICIAL);
						estado=Estado.ELEGIR_CASILLA_INICIAL;
					}
				}
			}
				
			
			//se cambia tambien en ventana al ser integer?
			System.out.println("Cambio de turno:Le toca a " +j.isTurno());
			System.out.println(".--------------------------------------------------------");
			v.repaint();
			t.repaint();
			
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			comportamientoNUllPointerException(e);
			
		}
		catch(Exception e)
		{
			System.err.println("excepction");
			e.printStackTrace();
			SalidaDatosVentana.mostrarError(e.getMessage());
			
			//e.printStackTrace();
		}
		
	}
	
	
	
	public void comportamientoNUllPointerException(NullPointerException e)
	{
		StringBuffer msg= new StringBuffer(Mensajes.NULL_POINTER_EXCEPTION + '\n'+ '\n');
		for(int i=0;i<e.getStackTrace().length;i++)
		{
			msg.append(e.getStackTrace()[i]);
			msg.append('\n');
		}
		SalidaDatosVentana.mostrarError(  msg.toString());
		
		
		e.printStackTrace();
	}
	
	
	@Override 	public void mouseClicked(MouseEvent m)	{		/*comportamiento(m);*/	}
	@Override 	public void mouseEntered(MouseEvent m) {			}
	@Override 	public void mouseExited(MouseEvent m) {			}
	@Override 	public void mousePressed(MouseEvent m) 	{		comportamiento(m);}
	@Override 	public void mouseReleased(MouseEvent m)	{		}
	
	

			 
 }

