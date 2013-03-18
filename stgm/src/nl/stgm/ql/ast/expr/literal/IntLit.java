package nl.stgm.ql.ast.expr.literal;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

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

	public Type inferType(TypeContext context)
	{
		return Type.INT;
	}

	public Int reduceValue(ValueContext context)
	{
		return value;
	}
}
