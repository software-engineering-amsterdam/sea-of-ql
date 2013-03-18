package nl.stgm.ql.ast.expr;

import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.inspectors.checker.*;
import nl.stgm.ql.inspectors.interpreter.*;

public abstract class LiteralExpr extends Expr
{
	public String renderExpression()
	{
		return this.toString();
	}

	public Type reduceType(SemanticChecker context)
	{
		return context.translateType(this);
	}

	public LiteralExpr reduceValue(Interpreter context)
	{
		return this;
	}
}
