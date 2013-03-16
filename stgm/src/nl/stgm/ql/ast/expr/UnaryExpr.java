package nl.stgm.ql.ast.expr;

import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;

public abstract class UnaryExpr extends Expr
{
	protected Expr arg;

	public String pretty()
	{
		return this.toString() + arg.pretty();
	}

	public Type getType(SemanticChecker context) throws IncompatibleTypesException
	{
		return arg.getType(context);
	}
}
