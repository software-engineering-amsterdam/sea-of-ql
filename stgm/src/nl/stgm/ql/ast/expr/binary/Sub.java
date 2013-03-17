package nl.stgm.ql.ast.expr.binary;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.inspectors.interpreter.*;

public class Sub extends BinaryExpr
{
	public Sub(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
	
	public String toString()
	{
		return "-";
	}
	
	public Value evaluate(Interpreter context)
	{
		Int leftValue = (Int) this.left.evaluate(context);
		Int rightValue = (Int) this.right.evaluate(context);
		
		return new Int(leftValue.getIntValue() - rightValue.getIntValue());
	}
}
