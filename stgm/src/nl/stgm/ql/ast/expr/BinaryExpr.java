package nl.stgm.ql.ast.expr;

import nl.stgm.ql.data.*;
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

	public String renderExpressionString()
	{
		return left.renderExpressionString() + " " + this.toString() + " " + right.renderExpressionString();
	}

	// this is only inherited to Eq and NEq
	public Type inferType(TypeContext context) throws IncompatibleTypesException
	{
		if(left.inferType(context) == right.inferType(context))
			return left.inferType(context);
		else
			throw new IncompatibleTypesException();
	}
}
