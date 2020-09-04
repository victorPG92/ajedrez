package vista.oyente.oyenteMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Juego.Juego;
import Juego.util.Posicion;
import constantes.Constantes;
import entradaSalida.ficheros.LectorFichero;
import piezas.Pieza;
import piezas.parsers.ParserPieza;
import vista.ventana.VentanaAjedrez;

public class OyenteCargar implements ActionListener 
{
	
	Juego j;
	VentanaAjedrez v;
	
	ParserPieza pp= new ParserPieza();

	
	
	public OyenteCargar(Juego j) {
		super();
		this.j = j;
		v= VentanaAjedrez.getInstancia();
	}
	
	





	public OyenteCargar(Juego j, VentanaAjedrez v) {
		super();
		this.j = j;
		this.v = v;
	}




	public void comportamiento()
	{
		String nombre= v.dameNombreFichero();
		System.out.println("Cargando fichero "+ nombre + " ... ");
		LectorFichero lf = new LectorFichero(nombre);
		j.getT().vaciarTablero();
		
		String sTurno=lf.leeLinea();
		boolean turno= Boolean.valueOf(sTurno);
		//System.out.println("turnooooooooooooooooo"+sTurno+": "+turno);
		j.setTurno(turno);
		j.gestionarTurno();
		
		
		for (int i = 0; i < Constantes.TAM; i++)
		{
			String linea=lf.leeLinea();
			int tam=4;
			for (int k = 0; k< Constantes.TAM; k++)
			{
				Posicion pos= new Posicion(i,k);
				String sPieza=linea.substring(tam*k,tam*(k+1)-1);
				Pieza p= pp.damePieza(sPieza, pos, j.getT(),j);
				j.getT().dameEscaque(pos).setPieza(p);
				
			}
		}
		
		
		
		
		
		j.getT().cogerPiezas();
		
		System.out.println("Carga aun  no implementada");
	}


	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		comportamiento();
		v.repaint();
		
	}





	public Juego getJ() {return j;	}
	public void setJ(Juego j) {	this.j = j;	}

	public VentanaAjedrez getV() {		return v;	}
	public void setV(VentanaAjedrez v) {	this.v = v;	}
	
	

}
