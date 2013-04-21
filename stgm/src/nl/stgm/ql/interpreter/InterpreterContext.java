package nl.stgm.ql.interpreter;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.data.*;

import java.util.Map;
import java.util.HashMap;

public class InterpreterContext implements ValueContext
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
		Value ret = values.get(id);
		if(ret == null) ret = new Unknown();
		return ret;
	}

	public void removeValue(String id)
	{
		values.remove(id);
	}
}
