package nl.stgm.ql.interpreter;

import java.util.Map;
import java.util.HashMap;

import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.data.*;

public class InterpreterContext implements TypeContext, ValueContext
{
	private Map<String,Value> values = new HashMap<String,Value>();

	public void putValue(String id, Value s)
	{
		values.put(id, s);
	}
	
	public boolean hasValue(String id)
	{
		return values.containsKey(id);
	}
	
	public Value getValue(String id)
	{
		assert values.containsKey(id);
		Value ret = values.get(id);
		if(ret == null) ret = new UnknownValue();
		return ret;
	}

	public void removeValue(String id)
	{
		assert values.containsKey(id);
		values.remove(id);
	}
	
	public Type getType(String id)
	{
		assert values.containsKey(id);
		return values.get(id).getType();
	}
}
