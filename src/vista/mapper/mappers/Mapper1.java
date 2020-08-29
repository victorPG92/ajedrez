package vista.mapper.mappers;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

import vista.mapper.claves.ClaveEnum;

public class Mapper1 implements Mapper
{

	
	private HashMap<ClaveEnum,Image>  m ;
	
	//private static MapperPiezas instancia;
	
	public Mapper1()
	{
		m = new  HashMap<ClaveEnum,Image> ();
		
		Toolkit t= Toolkit.getDefaultToolkit();
		
		
		//CON ENUM CLAVE
		
		m.put(ClaveEnum.CABALLO_BLANCO_BLANCO,	t.getImage("caballoBlanco.jpg"));
		m.put(ClaveEnum.REINA_BLANCO_BLANCO,	t.getImage("reinaBlanca.jpg"));
		m.put(ClaveEnum.REY_BLANCO_BLANCO,		t.getImage("reyBlanco.jpg"));
		m.put(ClaveEnum.TORRE_BLANCO_BLANCO,	t.getImage("TorreBlanca.jpg"));
		m.put(ClaveEnum.PEON_BLANCO_BLANCO,		t.getImage("peonBlanco.jpg"));
		m.put(ClaveEnum.ALFIL_BLANCO_BLANCO,	t.getImage("alfilBlanco.png"));
		
		m.put(ClaveEnum.CABALLO_NEGRO_BLANCO,	t.getImage("caballoNegro.jpg"));
		m.put(ClaveEnum.REINA_NEGRO_BLANCO,		t.getImage("reinaBlanca.jpg"));
		m.put(ClaveEnum.REY_NEGRO_BLANCO,		t.getImage("reyNegro.jpg"));
		m.put(ClaveEnum.TORRE_NEGRO_BLANCO,		t.getImage("TorreBlanca.jpg"));
		m.put(ClaveEnum.PEON_NEGRO_BLANCO,		t.getImage("peonNegro.jpg"));
		m.put(ClaveEnum.ALFIL_NEGRO_BLANCO,		t.getImage("alfilNegro.png"));
		
		m.put(ClaveEnum.CABALLO_BLANCO_NEGRO,	t.getImage("caballoBlanco.jpg"));
		m.put(ClaveEnum.REINA_BLANCO_NEGRO,		t.getImage("reinaBlanca.jpg"));
		m.put(ClaveEnum.REY_BLANCO_NEGRO,		t.getImage("reyBlanco.jpg"));
		m.put(ClaveEnum.TORRE_BLANCO_NEGRO,		t.getImage("TorreBlanca.jpg"));
		m.put(ClaveEnum.PEON_BLANCO_NEGRO,		t.getImage("peonBlanco.jpg"));
		m.put(ClaveEnum.ALFIL_BLANCO_NEGRO,		t.getImage("alfilBlanco.png"));
		
		m.put(ClaveEnum.CABALLO_NEGRO_NEGRO,	t.getImage("caballoBlanco.jpg"));
		m.put(ClaveEnum.REINA_NEGRO_NEGRO,		t.getImage("reinaBlanca.jpg"));
		m.put(ClaveEnum.REY_NEGRO_NEGRO,		t.getImage("reyBlanco.jpg"));
		m.put(ClaveEnum.TORRE_NEGRO_NEGRO,		t.getImage("TorreBlanca.jpg"));
		m.put(ClaveEnum.PEON_NEGRO_NEGRO,		t.getImage("peonBlanco.jpg"));
		m.put(ClaveEnum.ALFIL_NEGRO_NEGRO,		t.getImage("alfilBlanco.png"));
		
		
		
		
		
		//m.put( TipoFicha.CABALLO, t.getImage("caballoBlanco.jpg"));
		
		
		/*
		m.put( TipoFicha.PEON, Toolkit.getDefaultToolkit().getImage(carpeta+"caballoBlanco"));
		
		*/
		//insertar solo la ficha, o ficha sobre fondo?
		
	}
	
	
	
	
	
	public Image dameImagen(ClaveEnum c)
	{
		//System.out.println(c);
		
		if(c!=null)
			if(m.containsKey(c))
				return m.get(c);
			else  System.out.println("Pieza no encontrada " + c);	//.tf);
		return null;
	}





	@Override
	public Image dameImagen(Object o)
	{
		ClaveEnum c= (ClaveEnum)o;
		if(c!=null)
			if(m.containsKey(c))
				return m.get(c);
			else  System.out.println("Pieza no encontrada " + c);	//.tf);
		return null;
	}
	
	
	/*
	 * public static  MapperPiezas  getInstancia()
	{
		if(instancia ==null) instancia = new MapperPiezas();
		
		return instancia;
		
	}
	 * *
	 */
	
	
}
