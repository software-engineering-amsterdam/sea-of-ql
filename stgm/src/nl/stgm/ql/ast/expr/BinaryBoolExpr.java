package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.data.*;

public abstract class BinaryBoolExpr extends BinaryExpr
{
	public BinaryBoolExpr(ASTExpressionNode left, ASTExpressionNode right)
	{
		super(left, right);
	}

	public Type checkType(TypeCheckContext context)
	{
		if(!left.checkType(context).supportedAsBool() || !right.checkType(context).supportedAsBool())
			context.registerError(this, "Left or right is not of type bool.");

		return new BoolType();
	}
}
