package nl.stgm.ql.interpreter;

import java.util.HashMap;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.data.*;

import nl.stgm.ql.inspectors.*;

public class Context implements TypeContext, ValueContext
{
	private HashMap<String,Symbol> symbols = new HashMap<String,Symbol>();
	private HashMap<String,Value> values = new HashMap<String,Value>();

	public void putSymbol(String id, Symbol s)
	{
		symbols.put(id, s);
	}
	
	public Symbol getSymbol(String id)
	{
		return symbols.get(id);
	}
	
	public void putValue(String id, Value s)
	{
		values.put(id, s);
	}
	
	public Type getSymbolType(String name)
	{
		Symbol s = this.getSymbol(name);
		
		if(s == null)
		{
			throw new Error(name + " is not defined at this point");
		}
		else
		{
			return s.getType();
		}
	}
	
	public Value getValue(String id)
	{
		return values.get(id);
	}
}
