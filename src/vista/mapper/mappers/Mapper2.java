package vista.mapper.mappers;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

import piezas.TipoFicha;
import vista.mapper.claves.ClaveEnum;

public class Mapper2 implements Mapper
{
	
	private HashMap<TipoFicha,Image>  m ;
	
	//private static MapperPiezas instancia;
	
	public Mapper2()
	{
		m = new  HashMap<TipoFicha,Image> ();
		
		Toolkit t= Toolkit.getDefaultToolkit();
		
	
		// CON ENUM TIPO
		m.put(TipoFicha.CABALLO,	t.getImage("caballoBlanco.jpg"));
		m.put(TipoFicha.REINA,		t.getImage("reinaBlanca.jpg"));
		m.put(TipoFicha.REY,		t.getImage("reyBlanco.jpg"));
		m.put(TipoFicha.TORRE,		t.getImage("TorreBlanca.jpg"));
		m.put(TipoFicha.PEON,		t.getImage("peonBlanco.jpg"));
		m.put(TipoFicha.ALFIL,		t.getImage("alfilBlanco.png"));
	
	
	}

	@Override
	public Image dameImagen(Object o)
	{
		TipoFicha c= (TipoFicha)o;
		if(c!=null)
			if(m.containsKey(c))
				return m.get(c);
			else  System.out.println("Pieza no encontrada " + c);	//.tf);
		return null;
	}
	

}
