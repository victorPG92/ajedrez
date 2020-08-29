package entradaSalida;

import javax.swing.JOptionPane;

public class SalidaDatosVentana
{

	
	public static void pedirCasilla()
	{

		
		JOptionPane.showMessageDialog(null, "Debes escoger casilla con pieza ","Elige" , 0); 
	}
	
	public static void mostrarError(String msg)
	{
		JOptionPane.showMessageDialog(null, msg , "Error" ,0);
	}
	
	
	
	/*
	public static void casillaNoValida()
	{

		
		JOptionPane.showMessageDialog(null, "Debes escoger casilla tuya con pieza ","Error" , 0); 
	}
	
	public static void casillaVacia()
	{

		
		JOptionPane.showMessageDialog(null, "La casilla esta vacia ","Error" , 0); 
	}
	
	public static void noCasilla()
	{

		
		JOptionPane.showMessageDialog(null, "La casilla esta fuera de rango ","Error" , 0); 
	}
	
	public static void noCasillaMia()
	{

		
		JOptionPane.showMessageDialog(null, "La casilla esta contiene una pieza que no es  tuya ","Error" , 0); 
	}
	
	*/
	/*
	public static void casillaNoValida()
	{

		
		JOptionPane.showMessageDialog(null, "Debes escoger casilla tuya con pieza ","Error" , 0); 
	}*/
	
}
