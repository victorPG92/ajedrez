package vista.mapper.mappers;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

import constantes.Constantes;
import piezas.TipoFicha;
import vista.mapper.claves.Clave;

public class Mapper3 implements Mapper
{
		
	private HashMap<Clave,Image>  m ;
	
	//private static MapperPiezas instancia;
	
	public Mapper3()
	{
		m = new  HashMap<Clave,Image> ();
		
		Toolkit t= Toolkit.getDefaultToolkit();
		
		 //CON CLAVE	
		m.put(new Clave(Constantes.CABALLO,	true,true),		t.getImage("caballoBlanco.jpg"));
		m.put(new Clave(Constantes.REINA,	true,true),		t.getImage("reinaBlanca.jpg"));
		m.put(new Clave(Constantes.REY,		true,true),		t.getImage("reyBlanco.jpg"));
		
		
		m.put(new Clave(Constantes.CABALLO,	false,true), 	t.getImage("caballoNegro.jpg"));
		m.put(new Clave(Constantes.REINA,	false,true), 	t.getImage("reinaNegrca.jpg"));
		m.put(new Clave(Constantes.REY,		false,true),	t.getImage("reyNegro.jpg"));
		
		
		m.put(new Clave(Constantes.CABALLO,	true,false), 	t.getImage("caballoBlanco.jpg"));
		m.put(new Clave(Constantes.REINA,	true,false), 	t.getImage("reinaBlanca.jpg"));
		m.put(new Clave(Constantes.REY,		true,false), 	t.getImage("reyBlanco.jpg"));
		
		m.put(new Clave(Constantes.CABALLO,	false,false), 	t.getImage("caballoNegro.jpg"));
		m.put(new Clave(Constantes.REINA,	false,false), 	t.getImage("reinaNegrca.jpg"));
		m.put(new Clave(Constantes.REY,		false,false), 	t.getImage("reyNegro.jpg"));
		
		
		
	}

	@Override
	public Image dameImagen(Object o)
	{
		Clave c= (Clave)o;
		if(c!=null)
			if(m.containsKey(c))
				return m.get(c);
			else  System.out.println("Pieza no encontrada " + c);	//.tf);
		return null;
	}
	
	
	
	
	
	
	
}
