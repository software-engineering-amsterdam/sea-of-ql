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

	public String renderExpression()
	{
		return this.toString() + arg.renderExpression();
	}

	public Type reduceType(TypeContext context) throws IncompatibleTypesException
	{
		return arg.reduceType(context);
	}

	// reduceValue() is implemented in the concrete subclasses
}
