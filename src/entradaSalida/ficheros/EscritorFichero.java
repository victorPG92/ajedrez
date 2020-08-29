package entradaSalida.ficheros;

import java.io.FileWriter;
import java.io.PrintWriter;



/**
 * @author victor
 * Escribe en un fichero de salida
 */
public class EscritorFichero 
{
	 private String nombre;
	 private FileWriter fichero ;
	 private PrintWriter pw ;
	 
	 
	
	 
	 public  EscritorFichero(String nombre)
	 {
		 this.nombre= nombre;
		 open();
	 }
	 
	 public void escribeLinea(String linea)
	 {
		// open();
		 pw.println(linea);
		 //close();
	 }
	 
	 
	 public void open()
	 {
		 try
		 {
			fichero = new FileWriter(nombre);
			pw = new PrintWriter(fichero);
         
         } catch (Exception e) {
             e.printStackTrace();
         } 
	 }
	 
	 public void close()
	 { 
		 try 
		 {
			 fichero.close();
		 
		 } catch (Exception e) 
		 {
             e.printStackTrace();
         }
	 }
	 
    
}
