package nl.stgm.ql.ast.expr;

import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.inspectors.checker.*;
import nl.stgm.ql.inspectors.interpreter.*;

public abstract class LiteralExpr extends Expr
{
	public String pretty()
	{
		return this.toString();
	}

	public Type type(SemanticChecker context)
	{
		return context.translateType(this);
	}

	public LiteralExpr reduce(Interpreter context)
	{
		return this;
	}
}
