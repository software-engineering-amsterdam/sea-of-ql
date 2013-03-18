package nl.stgm.ql.ast.expr.unary;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.expr.literal.*;
import nl.stgm.ql.inspectors.*;

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

	public LiteralExpr reduceValue(ValueContext context)
	{
		Bool value = (Bool) this.arg.reduceValue(context);
		
		return new Bool(!value.getValue());
	}
}
