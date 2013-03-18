package nl.stgm.ql.ast.expr.binary;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.expr.literal.*;

import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public class Eq extends BinaryExpr
{
	public Eq(Expr left, Expr right)
	{
		super(left, right);
	}

	public String toString()
	{
		return "==";
	}

	public LiteralExpr reduceValue(ValueContext context)
	{
		LiteralExpr leftValue = (LiteralExpr) this.left.reduceValue(context);
		LiteralExpr rightValue = (LiteralExpr) this.right.reduceValue(context);
		
		switch(leftValue.reduceType((VisitingInterpreter)context))
		{
			case INT:
				return new Bool( ((Int)leftValue).getValue() == ((Int)rightValue).getValue() );
			case BOOL:
				return new Bool( ((Bool)leftValue).getValue() == ((Bool)rightValue).getValue() );
			default:
				throw new Error("Encountered an unknown type in tree.");
		}
	}
}
