package nl.stgm.ql.ast.expr;

import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;
import nl.stgm.ql.inspectors.interpreter.*;

public abstract class BinaryExpr extends Expr
{
	protected Expr left;
	protected Expr right;
	
	public String pretty()
	{
		return left.pretty() + " " + this.toString() + " " + right.pretty();
	}
	
	public Type type(SemanticChecker context) throws IncompatibleTypesException
	{
		if(left.type(context) == right.type(context))
			return left.type(context);
		else
			throw new IncompatibleTypesException();
	}

	public Value evaluate(Interpreter context)
	{
		return null;
	}
}
