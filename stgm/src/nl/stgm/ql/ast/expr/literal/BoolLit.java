package nl.stgm.ql.ast.expr.literal;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;

public class BoolLit extends LiteralExpr
{
	private final Bool value;

	public BoolLit(boolean b)
	{
		this.value = new Bool(b);
	}

	public String toString()
	{
		return value.toString();
	}

	public Type checkType(TypeCheckContext context)
	{
		return new BoolType();
	}

	public Bool getValue(ValueContext context)
	{
		return value;
	}
}
