package entradaSalida;

import javax.swing.JOptionPane;

public class EntradaDatosVentana 
{
	//JInputDialog
	
	public EntradaDatosVentana()
	{
	
		
	
	}
	
	
	public static Integer dameFila()
	{

		return Integer.getInteger(JOptionPane.showInputDialog("Elige fila"));
	}
	
	public static Integer dameColumna()
	{

		return Integer.getInteger(JOptionPane.showInputDialog("Elige columna"));
	}
	
	
}
