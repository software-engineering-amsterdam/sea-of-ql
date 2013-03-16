package nl.stgm.ql.ast.expr;

import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;

public abstract class BinaryExpr extends Expr
{
	protected Expr left;
	protected Expr right;
	
	public Expr getLeft()
	{
		return left;
	}

	public Expr getRight()
	{
		return right;
	}

	public String pretty()
	{
		return left.pretty() + " " + this.toString() + " " + right.pretty();
	}
	
	public Type getType(SemanticChecker context) throws IncompatibleTypesException
	{
		if(left.getType(context) == right.getType(context))
			return left.getType(context);
		else
			throw new IncompatibleTypesException();
	}
}
