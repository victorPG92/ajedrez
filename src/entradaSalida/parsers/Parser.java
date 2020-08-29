package entradaSalida.parsers;

import java.util.StringTokenizer;

/**
 * 
 * @author Victor
 * Interfaz de un parser, para transformar una linea en un tipo
 *
 * @param <T>
 */
public abstract class Parser <T>
{
	protected String tokens[];
	protected String delimitador=":";
	
	public abstract T parse(String linea);
	
	public void divideTokens(String linea,String delimitador)
	{
		//separamos con ;
		StringTokenizer st = new  StringTokenizer(linea,delimitador); //';'
		tokens = new String[st.countTokens()];
		
		int nt=0;
		while(st.hasMoreTokens())
		{
			tokens[nt]= st.nextToken();//";"
			nt++;
		}
		
	}

        public String[] getTokens() 
        {
            return tokens;
        }

        public void setTokens(String[] tokens) 
        {
            this.tokens = tokens;
        }
        
        
	
}
