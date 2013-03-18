package nl.stgm.ql.ast.expr;

import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;
import nl.stgm.ql.inspectors.interpreter.*;

public abstract class BinaryExpr extends Expr
{
	protected Expr left;
	protected Expr right;
	
	public String renderExpression()
	{
		return left.renderExpression() + " " + this.toString() + " " + right.renderExpression();
	}
	
	public Type reduceType(SemanticChecker context) throws IncompatibleTypesException
	{
		if(left.reduceType(context) == right.reduceType(context))
			return left.reduceType(context);
		else
			throw new IncompatibleTypesException();
	}

	public LiteralExpr reduceValue(Interpreter context)
	{
		return null;
	}
}
