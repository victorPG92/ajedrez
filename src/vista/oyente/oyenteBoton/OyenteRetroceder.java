package vista.oyente.oyenteBoton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Juego.JuegoAjedrez;
import entradaSalida.SalidaDatosVentana;
import vista.ventana.VentanaAjedrez;

public class OyenteRetroceder implements ActionListener 
{
	
	JuegoAjedrez j;
	VentanaAjedrez v;
	
	

	
	
	public OyenteRetroceder(JuegoAjedrez j) {
		super();
		this.j = j;
	}
	
	





	public OyenteRetroceder(JuegoAjedrez j, VentanaAjedrez v) {
		super();
		this.j = j;
		this.v = v;
	}







	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		
		boolean retr=j.retrocederTIempo();
		if(!retr)
			SalidaDatosVentana.mostrarError("No hay movimientos jugados, No se puede retroceder");
		v.repaint();
		v.getCanvas().vaciar();
	}





	public JuegoAjedrez getJ() {return j;	}
	public void setJ(JuegoAjedrez j) {	this.j = j;	}

	public VentanaAjedrez getV() {		return v;	}
	public void setV(VentanaAjedrez v) {	this.v = v;	}
	
	

}
