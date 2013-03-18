package nl.stgm.ql.ast.expr.unary;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.expr.literal.*;
import nl.stgm.ql.inspectors.interpreter.*;

public class Pos extends UnaryExpr
{
	public Pos(Expr arg)
	{
		this.arg = arg;
	}

	public String toString()
	{
		return "+";
	}

	public LiteralExpr reduceValue(Interpreter context)
	{
		Int value = (Int) this.arg.reduceValue(context);
		
		return value;
	}
}
