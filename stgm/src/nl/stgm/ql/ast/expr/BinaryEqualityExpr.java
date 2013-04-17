package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public abstract class BinaryEqualityExpr extends BinaryExpr
{
	public BinaryEqualityExpr(ASTExpressionNode left, ASTExpressionNode right)
	{
		super(left, right);
	}

	public Type getType(TypeContext context)
	{
		return Type.BOOL;
	}
	
	public void checkType(TypeCheckContext context)
	{
		if(left.getType(context) != right.getType(context))
			context.registerTypeError(this, "Left and right are not of the same type.");
	}
}
