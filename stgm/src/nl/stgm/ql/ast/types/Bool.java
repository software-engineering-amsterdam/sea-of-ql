package nl.stgm.ql.ast.types;

import nl.stgm.ql.ast.expr.Expr;

public class Bool extends Expr
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
}
