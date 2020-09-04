package main;

import java.awt.EventQueue;

import vista.ventana.TipoJuego;
import vista.ventana.VentanaAjedrez;

public class Main 
{
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TipoJuego tipo= TipoJuego.damas;
					VentanaAjedrez.tipoAjedrezEstatico= tipo;
					VentanaAjedrez frame =  VentanaAjedrez.getInstancia();//new Tablero());
					frame.ponerListeners();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

}
