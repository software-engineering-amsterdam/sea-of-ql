package nl.stgm.ql.ast.expr.literal;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

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

	public Type inferType(TypeContext context)
	{
		return Type.BOOL;
	}

	public Bool reduceValue(ValueContext context)
	{
		return value;
	}
}
