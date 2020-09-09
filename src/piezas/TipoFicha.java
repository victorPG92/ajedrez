package piezas;

public enum TipoFicha 
{
	ALFIL('a'),TORRE('t'), CABALLO('c'), REY('k'), REINA('q'),PEON('p'),
	
	DAMA('d');
	
	TipoFicha(char c1){c=c1;}
	
	
	char c;
	
	public static TipoFicha parse(String s)
	{
		if(s.length()>1)
		{
			for(TipoFicha t:TipoFicha.values())
				if(t.name().equalsIgnoreCase(s))
					return t;
			
			return null;
			
		}
		
		return parse(s.charAt(0));
		
	}
	
	public static TipoFicha parse(char c1)
	{
		
		for(TipoFicha t:TipoFicha.values())
			if(t.c==Character.toLowerCase(c1))
				return t;
		return null;
		
	}

}
