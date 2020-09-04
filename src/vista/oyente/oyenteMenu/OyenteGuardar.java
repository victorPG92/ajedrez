package vista.oyente.oyenteMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.MenuDragMouseEvent;
import javax.swing.event.MenuDragMouseListener;

import Juego.FicheroTablero;
import Juego.Juego;
import entradaSalida.SalidaDatosVentana;
import vista.ventana.VentanaAjedrez;

public class OyenteGuardar implements ActionListener , MenuDragMouseListener
{
	
	Juego j;
	FicheroTablero ft;
	
	
	public OyenteGuardar(Juego j) {
		super();
		this.j = j;
		ft= new FicheroTablero(j);
	}
	

	public void guardar()
	{
		ft.guardaJuego("basico.txt");
		System.out.println("Guardar");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		System.out.println("guardando");
		ft.guardaJuego("basico.txt");
	
	}





	public Juego getJ() {return j;	}
	public void setJ(Juego j) {	this.j = j;	}


	
	
	
	@Override
	public void menuDragMouseDragged(MenuDragMouseEvent arg0) {
		guardar();
		
	}


	@Override
	public void menuDragMouseEntered(MenuDragMouseEvent arg0) {
		guardar();
		
	}


	@Override
	public void menuDragMouseExited(MenuDragMouseEvent arg0) {
		guardar();
		
	}


	@Override
	public void menuDragMouseReleased(MenuDragMouseEvent arg0) {
		guardar();
		
	}

	

}
