package nl.stgm.ql.ast.expr;

import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public abstract class BinaryExpr extends Expr
{
	protected Expr left;
	protected Expr right;
	
	public BinaryExpr(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}

	public String renderExpression()
	{
		return left.renderExpression() + " " + this.toString() + " " + right.renderExpression();
	}
	
	public Type reduceType(TypeContext context) throws IncompatibleTypesException
	{
		if(left.reduceType(context) == right.reduceType(context))
			return left.reduceType(context);
		else
			throw new IncompatibleTypesException();
	}
	
	// reduceValue() is implemented in the concrete subclasses
}
