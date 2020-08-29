package vista.mapper.fact;


import vista.mapper.mappers.*;

public class FactMapperImp extends FactMapper
{

	private Mapper m;
	
	
	@Override
	public Mapper creaMapper() {
		
		if(m==null) m= new Mapper4();
			
		return m ;
	}
	

}
