package vista.mapper.fact;

import vista.mapper.mappers.Mapper;

public abstract class FactMapper
{
	private static FactMapper inst;
	
	public static FactMapper getInst()
	{
		if(inst==null) inst = new FactMapperImp();
		
		return inst;
	}
	
	
	
	public abstract Mapper creaMapper();
	
	
}
