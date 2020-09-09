package tableros.rellenadores.ajedrez;

import tableros.TableroAjedrez;
import tableros.rellenadores.RellenadorTablero;

public class RellenadorAjedrezOpt implements RellenadorTablero<TableroAjedrez> 
{

	private boolean enr=true;
	
	RellenadorAjedrezInicio rInicio= new RellenadorAjedrezInicio();
	RellenadorAjedrezEnroque rEnroque= new RellenadorAjedrezEnroque();
	
	@Override
	public void creaPiezas(TableroAjedrez t)
	{
		if(enr)
			crearEnroque(t);
		else 
			creaPiezasInicio(t);
				
	}
	
	
	private void creaPiezasInicio(TableroAjedrez t) 
	{

		rInicio.creaPiezas(t);		
	}
	
	private void crearEnroque(TableroAjedrez t) {
		rEnroque.creaPiezas(t);		
	}

}
