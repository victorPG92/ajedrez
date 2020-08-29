package vista.oyente.oyenteMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.MenuDragMouseEvent;
import javax.swing.event.MenuDragMouseListener;

import Juego.FicheroTablero;
import Juego.JuegoAjedrez;
import entradaSalida.SalidaDatosVentana;
import vista.ventana.VentanaAjedrez;

public class OyenteGuardarNombre implements ActionListener , MenuDragMouseListener
{
	
	JuegoAjedrez j;
	FicheroTablero ft;
	VentanaAjedrez v;
	
	
	public OyenteGuardarNombre(JuegoAjedrez j,	VentanaAjedrez v) {
		super();
		this.j = j;
		this.v=v;
		ft= new FicheroTablero(j);
	}
	

	public void guardar()
	{
		String nombre=v.dameNombreFichero();
		if(nombre!=null && !nombre.isEmpty())
		{
			ft.guardaJuego(nombre);
			SalidaDatosVentana.mostrarError("Guardando en "+nombre);
		}else 
			SalidaDatosVentana.mostrarError("No hay nombre de fichero escrito");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		System.out.println("guardando");
		guardar();
	
	}





	public JuegoAjedrez getJ() {return j;	}
	public void setJ(JuegoAjedrez j) {	this.j = j;	}


	
	
	
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
