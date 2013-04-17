package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public abstract class BinaryBoolExpr extends BinaryExpr
{
	public BinaryBoolExpr(ASTExpressionNode left, ASTExpressionNode right)
	{
		super(left, right);
	}

	public Type getType(TypeContext context)
	{
		return Type.BOOL;
	}
	
	public void checkType(TypeCheckContext context)
	{
		if(left.getType(context) != Type.BOOL || right.getType(context) != Type.BOOL)
			context.registerTypeError(this, "Left or right is not of type bool.");
	}
}
