package nl.stgm.ql.ast.expr;

import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public abstract class LiteralExpr extends Expr
{
	public String renderExpressionString()
	{
		return this.toString();
	}
}
