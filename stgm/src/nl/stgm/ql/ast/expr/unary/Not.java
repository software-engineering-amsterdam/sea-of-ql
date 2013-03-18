package nl.stgm.ql.ast.expr.unary;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.expr.literal.*;
import nl.stgm.ql.inspectors.interpreter.*;

public class Not extends UnaryExpr
{
	public Not(Expr arg)
	{
		this.arg = arg;
	}

	public String toString()
	{
		return "!";
	}

	public LiteralExpr reduceValue(Interpreter context)
	{
		Bool value = (Bool) this.arg.reduceValue(context);
		
		return new Bool(!value.getValue());
	}
}
