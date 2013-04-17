package nl.stgm.ql.ast.expr.binary;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public class Or extends BinaryBoolExpr
{
	public Or(ASTExpressionNode left, ASTExpressionNode right)
	{
		super(left, right);
	}

	public String toString()
	{
		return "||";
	}

	public Value getValue(ValueContext context)
	{
		Bool leftValue = (Bool) this.left.getValue(context);
		Bool rightValue = (Bool) this.right.getValue(context);
		
		return new Bool(leftValue.getValue() || rightValue.getValue());
	}
}
