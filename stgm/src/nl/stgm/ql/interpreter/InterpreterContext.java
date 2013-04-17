package nl.stgm.ql.interpreter;

import java.util.Map;
import java.util.HashMap;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.data.*;

import nl.stgm.ql.inspectors.*;

public class InterpreterContext implements TypeContext, ValueContext
{
	private Map<String,Symbol> symbols = new HashMap<String,Symbol>();
	private Map<String,Value> values = new HashMap<String,Value>();

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
	
	public void removeValue(String id)
	{
		values.remove(id);
	}
	
	public Type getType(String name)
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
	
	public boolean hasValue(String id)
	{
		return values.containsKey(id);
	}
	
	public Value getValue(String id)
	{
		Value ret = values.get(id);
		if(ret == null) ret = new UnknownValue();
		return ret;
	}
}
