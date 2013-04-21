package nl.stgm.ql.ast.expr.binary;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;

public class And extends BinaryBoolExpr
{
	public And(ASTExpressionNode left, ASTExpressionNode right)
	{
		super(left, right);
	}

	public String toString()
	{
		return "&&";
	}

	public Value getValue(ValueContext context)
	{
		Value leftValue = this.left.getValue(context);
		Value rightValue = this.right.getValue(context);

		if(leftValue.getType().supportedAsBool() && rightValue.getType().supportedAsBool())
		{
			return new Bool(((Bool)leftValue).getValue() && ((Bool)rightValue).getValue());
		}
		else
		{
			return new Unknown();
		}
	}
}
