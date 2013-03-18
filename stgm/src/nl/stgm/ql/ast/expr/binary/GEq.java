package nl.stgm.ql.ast.expr.binary;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.expr.literal.*;
import nl.stgm.ql.inspectors.interpreter.*;

public class GEq extends BinaryExpr
{
	public GEq(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}

	public String toString()
	{
		return ">=";
	}

	public LiteralExpr reduceValue(Interpreter context)
	{
		Int leftValue = (Int) this.left.reduceValue(context);
		Int rightValue = (Int) this.right.reduceValue(context);
		
		return new Bool(leftValue.getValue() >= rightValue.getValue());
	}
}
