package vista.oyente.oyenteMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Juego.JuegoAjedrez;
import Juego.util.Posicion;
import constantes.Constantes;
import entradaSalida.ficheros.LectorFichero;
import piezas.Pieza;
import piezas.parsers.ParserPieza;
import vista.ventana.VentanaAjedrez;

public class OyenteCargar implements ActionListener 
{
	
	JuegoAjedrez j;
	VentanaAjedrez v;
	
	ParserPieza pp= new ParserPieza();

	
	
	public OyenteCargar(JuegoAjedrez j) {
		super();
		this.j = j;
		v= VentanaAjedrez.getInstancia();
	}
	
	





	public OyenteCargar(JuegoAjedrez j, VentanaAjedrez v) {
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





	public JuegoAjedrez getJ() {return j;	}
	public void setJ(JuegoAjedrez j) {	this.j = j;	}

	public VentanaAjedrez getV() {		return v;	}
	public void setV(VentanaAjedrez v) {	this.v = v;	}
	
	

}
