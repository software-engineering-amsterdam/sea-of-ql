package nl.stgm.ql.inspectors;

import nl.stgm.ql.data.*;

public class Symbol
{
	String name;
	Type type;
	boolean computed;

	public Symbol(String name, Type type, boolean computed)
	{
		this.name = name;
		this.type = type;
		this.computed = computed;
	}

	public Type getType(ValueContext context)
	{
		return this.type;
	}

	public boolean isOfType(Type type)
	{
		return this.type == type;
	}

	public boolean isComputed()
	{
		return this.computed;
	}
}
