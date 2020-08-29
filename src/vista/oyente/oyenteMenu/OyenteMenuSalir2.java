package vista.oyente.oyenteMenu;

import javax.swing.event.MenuDragMouseEvent;
import javax.swing.event.MenuDragMouseListener;

import vista.ventana.VentanaAjedrez;

public class OyenteMenuSalir2 implements MenuDragMouseListener  
{

	
	private VentanaAjedrez v;
	
	
	public OyenteMenuSalir2(VentanaAjedrez v)
	{
		this.v=v;
	}
	
	
	
	@Override
	public void menuDragMouseDragged(MenuDragMouseEvent arg0) {
		
		//v.enable();
		System.exit(0);	
	}

	@Override
	public void menuDragMouseEntered(MenuDragMouseEvent arg0) {
		System.exit(0);	
		
	}

	@Override
	public void menuDragMouseExited(MenuDragMouseEvent arg0) {
		System.exit(0);	
		
	}

	@Override
	public void menuDragMouseReleased(MenuDragMouseEvent arg0) {
		System.exit(0);	
		
	}

}
