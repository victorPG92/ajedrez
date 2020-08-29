package vista.mapper.mappers;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

import constantes.Constantes;
import vista.mapper.claves.Clave;
import vista.mapper.claves.ClaveEnumCompuesta;

public class Mapper4 implements Mapper
{

	
private HashMap<ClaveEnumCompuesta,Image>  m ;
	
	//private static MapperPiezas instancia;
	
	public Mapper4()
	{
		m = new  HashMap<ClaveEnumCompuesta,Image> ();
		
		Toolkit t= Toolkit.getDefaultToolkit();
		
		 //CON CLAVE	
		m.put(ClaveEnumCompuesta.TORRE_BLANCO,		t.getImage("TorreBlanca.jpg"));
		m.put(ClaveEnumCompuesta.CABALLO_BLANCO,	t.getImage("caballoBlanco.jpg"));
		m.put(ClaveEnumCompuesta.ALFIL_BLANCO,		t.getImage("alfilBlanco.png"));
		m.put(ClaveEnumCompuesta.REINA_BLANCO,		t.getImage("reinaBlanca.jpg"));
		m.put(ClaveEnumCompuesta.REY_BLANCO,		t.getImage("reyBlanco.jpg"));
		m.put(ClaveEnumCompuesta.PEON_BLANCO,		t.getImage("peonBlanco.jpg"));
		
		m.put(ClaveEnumCompuesta.TORRE_NEGRO,		t.getImage("TorreNegra.jpg"));
		m.put(ClaveEnumCompuesta.CABALLO_NEGRO,		t.getImage("caballoNegro.jpg"));
		m.put(ClaveEnumCompuesta.ALFIL_NEGRO,		t.getImage("alfilNegro.png"));
		m.put(ClaveEnumCompuesta.REINA_NEGRO,		t.getImage("reinaNegra.jpg"));
		m.put(ClaveEnumCompuesta.REY_NEGRO,			t.getImage("reyNegro.jpg"));
		m.put(ClaveEnumCompuesta.PEON_NEGRO,		t.getImage("peonNegro.jpg"));
		
		//m.put(ClaveEnumCompuesta.ICONO,		t.getImage("peonNegro.jpg"));
		
		
		
		
		
		
	}

	@Override
	public Image dameImagen(Object o)
	{
		ClaveEnumCompuesta c= (ClaveEnumCompuesta)o;
		if(c!=null)
			if(m.containsKey(c))
				return m.get(c);
			else  System.out.println("Pieza no encontrada " + c);	//.tf);
		return null;
	}
	
}
