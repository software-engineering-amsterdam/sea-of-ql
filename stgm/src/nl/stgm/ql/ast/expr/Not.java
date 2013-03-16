package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;

public class Not extends UnaryExpr
{
	public Not(Expr arg)
	{
		this.arg = arg;
	}

	public String prettyString()
	{
		return "!";
	}
}
