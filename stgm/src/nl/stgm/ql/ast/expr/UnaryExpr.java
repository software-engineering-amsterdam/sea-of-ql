package nl.stgm.ql.ast.expr;

import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;
import nl.stgm.ql.inspectors.interpreter.*;

public abstract class UnaryExpr extends Expr
{
	protected Expr arg;

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
