package nl.stgm.ql.checker;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.data.*;

public class CheckerSymbol
{
	String name;
	Type type;
	boolean computed;

	public CheckerSymbol(String name, Type type, boolean computed)
	{
		this.name = name;
		this.type = type;
		this.computed = computed;
	}

	public Type getType()
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
