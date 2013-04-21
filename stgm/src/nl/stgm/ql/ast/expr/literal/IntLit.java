package nl.stgm.ql.ast.expr.literal;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;

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

	public Type checkType(TypeCheckContext context)
	{
		return new IntType();
	}

	public Int getValue(ValueContext context)
	{
		return value;
	}
}
