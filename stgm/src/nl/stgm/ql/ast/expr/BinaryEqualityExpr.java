package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.data.*;

public abstract class BinaryEqualityExpr extends BinaryExpr
{
	public BinaryEqualityExpr(ASTExpressionNode left, ASTExpressionNode right)
	{
		super(left, right);
	}

	public Type getType(ValueContext context)
	{
		return new BoolType();
	}
	
	public Type checkType(TypeCheckContext context)
	{
		if(!left.checkType(context).equals(right.checkType(context)))
		{
			context.registerError(this, "Left and right are not of the same type.");
		}

		return new BoolType();
	}
}
