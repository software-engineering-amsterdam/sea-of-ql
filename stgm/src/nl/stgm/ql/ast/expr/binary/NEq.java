package nl.stgm.ql.ast.expr.binary;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;

public class NEq extends BinaryEqualityExpr
{
	public NEq(ASTExpressionNode left, ASTExpressionNode right)
	{
		super(left, right);
	}

	public String toString()
	{
		return "!=";
	}

	public Value getValue(ValueContext context)
	{
		Value leftValue = (Value) this.left.getValue(context);
		Value rightValue = (Value) this.right.getValue(context);
		
		return new Bool(!leftValue.equals(rightValue));
	}
}
