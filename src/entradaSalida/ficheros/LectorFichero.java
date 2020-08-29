package entradaSalida.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * @author victor
 * Lee de un fichero de entrada
 */
public class LectorFichero 
{

	private BufferedReader bd;
	private FileReader fr;
	private String nombreFichero;
	
	
	private boolean cerrado;	
	//private boolean ficheroCorrecto;
	
	
	
	public LectorFichero(String nombre)
	{
		 try
		 {
			//ficheroCorrecto=true;
			cerrado=false;
			nombreFichero= nombre;			
			
			File f = new File(nombreFichero);
			fr = new FileReader(f);
			bd = new BufferedReader(fr);
			
					
			//fr.close();
			//bd.close();
		 }
		 catch (FileNotFoundException e)
		 {
			 cerrado=true;
			 System.err.println("Fichero no encontrado: " +nombreFichero);
			// e.printStackTrace();
		
		 }
		 catch (Exception e)
		 {
			 cerrado=true;
			e.printStackTrace();
		 }	
		
	
		 
		 
	}
	
    public void close()
    {
    	cerrado=true;
        try
        {
           fr.close();
           bd.close();
        }  catch(Exception e){}
    }

        
        
    public String leeLinea()
    {
        try
        {
        	String linea= bd.readLine();
        	if(linea==null)close();
        	return linea;
        }catch(Exception e)
        {
           return null;
        }
    }    
        
        
    /**
     * @deprecated
     * poco eficiente, solo para ficheros de poco tamaño.
     * fichero de poca longitud, renta guardar todo en un String y cerrar el fichero para dejarlo libre
     * 
     */
	public   ArrayList<String> leerTodo() //poco eficiente
	{
		
		ArrayList<String> lineas= new  ArrayList<String> ();
		try 
		{
			if(bd.ready())
			{
				String s="";
				while(s!=null)
				{
					s=bd.readLine();
					if(s!= null)
							lineas.add(s);
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return lineas;
	}
	
	
	
	
	
	
	
	
	
	public boolean estaCerrado()
	{
		return cerrado;
	}

	









	private static LectorFichero inst;
	public static LectorFichero getInst()
	{
		return inst;
	}

}
