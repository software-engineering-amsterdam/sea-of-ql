package nl.stgm.ql.ast.expr;

import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;
import nl.stgm.ql.inspectors.interpreter.*;

public abstract class UnaryExpr extends Expr
{
	protected Expr arg;

	public String pretty()
	{
		return this.toString() + arg.pretty();
	}

	public Type type(SemanticChecker context) throws IncompatibleTypesException
	{
		return arg.type(context);
	}

	public Value evaluate(Interpreter context)
	{
		return null;
	}
}
