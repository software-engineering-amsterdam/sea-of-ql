package nl.stgm.ql.ast.expr.binary;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public class Add extends BinaryIntExpr
{
	public Add(Expr left, Expr right)
	{
		super(left, right);
	}

	public String toString()
	{
		return "+";
	}

	public Value reduceValue(ValueContext context)
	{
		Int leftValue = (Int) this.left.reduceValue(context);
		Int rightValue = (Int) this.right.reduceValue(context);
		
		return new Int(leftValue.getValue() + rightValue.getValue());
	}
}
