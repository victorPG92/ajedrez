package vista.mapper.mappers;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

import constantes.Constantes;
import piezas.Pieza;
import piezas.TipoFicha;
import vista.mapper.claves.ClaveEnum;

public class MapperPiezas
{
	
	private HashMap<ClaveEnum,Image>  m ;
	
	private static MapperPiezas instancia;
	
	private MapperPiezas()
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
		
		
		/*
		// CON ENUM TIPO
		m.put(TipoFicha.CABALLO,	t.getImage("caballoBlanco.jpg"));
		m.put(TipoFicha.REINA,		t.getImage("reinaBlanca.jpg"));
		m.put(TipoFicha.REY,		t.getImage("reyBlanco.jpg"));
		m.put(TipoFicha.TORRE,		t.getImage("TorreBlanca.jpg"));
		m.put(TipoFicha.PEON,		t.getImage("peonBlanco.jpg"));
		m.put(TipoFicha.ALFIL,		t.getImage("alfilBlanco.png"));
		*/
		
		/*	
		
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
		*/
		//m.put( TipoFicha.CABALLO, t.getImage("caballoBlanco.jpg"));
		
		
		/*
		m.put( TipoFicha.PEON, Toolkit.getDefaultToolkit().getImage(carpeta+"caballoBlanco"));
		
		*/
		//insertar solo la ficha, o ficha sobre fondo?
		
	}
	
	public static  MapperPiezas  getInstancia()
	{
		if(instancia ==null) instancia = new MapperPiezas();
		
		return instancia;
		
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
	
	

}
