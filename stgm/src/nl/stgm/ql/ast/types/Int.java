package nl.stgm.ql.ast.types;

import nl.stgm.ql.ast.expr.Expr;

public class Int extends Expr
{
	private final int value;

	public Int(int n)
	{
		this.value = n;
	}

	public int getValue()
	{
		return value;
	}	
}
