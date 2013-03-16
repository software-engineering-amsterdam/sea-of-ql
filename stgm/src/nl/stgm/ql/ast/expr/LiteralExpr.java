package nl.stgm.ql.ast.expr;

import nl.stgm.ql.inspectors.checker.*;

public abstract class LiteralExpr extends Expr
{
	public String pretty()
	{
		return this.toString();
	}

	public Type getType(SemanticChecker context)
	{
		return context.translateType(this);
	}
}
