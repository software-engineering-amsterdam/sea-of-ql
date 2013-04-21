package nl.stgm.ql.ast.expr.literal;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;

public class IntLit extends LiteralExpr
{
	private final Int value;

	public IntLit(int n)
	{
		this.value = new Int(n);
	}

	public String toString()
	{
		return value.toString();
	}

	public Type getType(ValueContext context)
	{
		return new IntType();
	}

	public Int getValue(ValueContext context)
	{
		return value;
	}
}
