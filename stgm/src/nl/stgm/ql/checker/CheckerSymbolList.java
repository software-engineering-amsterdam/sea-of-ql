package nl.stgm.ql.checker;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.data.*;

import java.util.Map;
import java.util.HashMap;

public class CheckerSymbolList
{
	private Map<String,CheckerSymbol> symbols = new HashMap<String,CheckerSymbol>();
	private CheckerErrorList errors;

	public CheckerSymbolList(CheckerErrorList errors)
	{
		this.errors = errors;
	}

	public void add(String name, CheckerSymbol s)
	{
		// check if symbol already exists
		CheckerSymbol i = symbols.get(name);
		
		if(i == null)
		{
			symbols.put(name, s);
		}
		else if(i.isComputed() != s.isComputed())
		{
			if(s.isComputed())
				errors.add(name + " is redefined as being calculated instead of input by user");
			else
				errors.add(name + " is redefined as being input by user instead of calculated");
		}
		else if(!i.getType().equals(s.getType()))
		{
			errors.add(name + " is redefined as being of a different datatype");
		}
		else
		{
			// symbol is equivalent, does not need to be added (though it could be seen as an error)
		}
	}
	
	public Type getType(String name)
	{
		CheckerSymbol s = symbols.get(name);
		
		if(s == null)
		{
			errors.add(name + " is not defined at this point");
			
			// we'll allow to continue in order to catch more errors
			return new UnknownType();
		}
		else
		{
			return s.getType();
		}
	}
}
