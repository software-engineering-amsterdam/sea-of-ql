package nl.stgm.ql.ast.expr.binary;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.expr.literal.*;
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
	
	public LiteralExpr reduce(Interpreter context)
	{
		Int leftValue = (Int) this.left.reduce(context);
		Int rightValue = (Int) this.right.reduce(context);
		
		return new Int(leftValue.getValue() - rightValue.getValue());
	}
}
