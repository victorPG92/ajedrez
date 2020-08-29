package entradaSalida;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class EntradaTeclado
{
	
	//Singleton
	
	private static EntradaTeclado instancia;
	private Scanner sc;
	
	private EntradaTeclado()
	{
		sc=new Scanner(System.in);
		
	}
	
	public static  EntradaTeclado getInstancia()
	{
		if(instancia==null) instancia= new EntradaTeclado();
		
		return instancia;
	}

	
	
	
	
	public Scanner dameSc()
	{
		return sc;
	}
	
	
	public  Integer dameFila()
	{
		System.out.println("Dame fila");	
		return sc.nextInt(); 
	}
	
	public  Integer dameColumna()
	{
		System.out.println("Dame columna");
		 return sc.nextInt(); 
	}
}
