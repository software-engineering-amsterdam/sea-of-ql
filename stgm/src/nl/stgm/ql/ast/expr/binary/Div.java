package nl.stgm.ql.ast.expr.binary;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;

public class Div extends BinaryIntExpr
{
	public Div(ASTExpressionNode left, ASTExpressionNode right)
	{
		super(left, right);
	}

	public String toString()
	{
		return "/";
	}

	public Value getValue(ValueContext context)
	{
		Value leftValue = this.left.getValue(context);
		Value rightValue = this.right.getValue(context);

		if(leftValue.getType().supportedAsInt() && rightValue.getType().supportedAsInt())
		{
			return new Int(((Int)leftValue).getValue() / ((Int)rightValue).getValue());
		}
		else
		{
			return new Unknown();
		}
	}
}
