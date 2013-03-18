package nl.stgm.ql.ast.expr;

import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public abstract class UnaryExpr extends Expr
{
	protected Expr arg;

	public UnaryExpr(Expr arg)
	{
		this.arg = arg;
	}

	public String renderExpressionString()
	{
		return this.toString() + arg.renderExpressionString();
	}
}
