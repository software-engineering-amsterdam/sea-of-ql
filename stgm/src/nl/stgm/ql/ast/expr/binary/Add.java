package nl.stgm.ql.ast.expr.binary;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;

public class Add extends BinaryIntExpr
{
	public Add(ASTExpressionNode left, ASTExpressionNode right)
	{
		super(left, right);
	}

	public String toString()
	{
		return "+";
	}

	public Value getValue(ValueContext context)
	{
		Int leftValue = (Int) this.left.getValue(context);
		Int rightValue = (Int) this.right.getValue(context);
		
		return new Int(leftValue.getValue() + rightValue.getValue());
	}
}
