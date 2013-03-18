package nl.stgm.ql.ast.expr;

import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public abstract class LiteralExpr extends Expr
{
	public String renderExpression()
	{
		return this.toString();
	}

	public Type reduceType(TypeContext context)
	{
		return Type.translate(this);
	}

	public LiteralExpr reduceValue(ValueContext context)
	{
		return this;
	}
}
