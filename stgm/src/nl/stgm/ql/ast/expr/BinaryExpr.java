package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public abstract class BinaryExpr extends ASTExpressionNode
{
	protected ASTExpressionNode left;
	protected ASTExpressionNode right;
	
	public BinaryExpr(ASTExpressionNode left, ASTExpressionNode right)
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
