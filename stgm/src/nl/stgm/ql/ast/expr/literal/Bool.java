package nl.stgm.ql.ast.expr.literal;

import nl.stgm.ql.ast.expr.*;

public class Bool extends LiteralExpr
{
	private final boolean value;

	public Bool(boolean b)
	{
		this.value = b;
	}

	public boolean getValue()
	{
		return value;
	}
	
	public String toString()
	{
		return String.valueOf(value);
	}
}
