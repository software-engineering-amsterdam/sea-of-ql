package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.data.*;

public abstract class BinaryIntExpr extends BinaryExpr
{
	public BinaryIntExpr(ASTExpressionNode left, ASTExpressionNode right)
	{
		super(left, right);
	}

	public Type getType(ValueContext context)
	{
		return new IntType();
	}
	
	public void checkType(TypeCheckContext context)
	{
		if(!left.getType(context).supportedAsInt() || !right.getType(context).supportedAsInt())
			context.registerTypeError(this, "Left or right is not of type int.");
	}
}
