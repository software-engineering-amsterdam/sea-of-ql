package nl.stgm.ql.ast.expr.binary;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.expr.literal.*;
import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.inspectors.interpreter.*;

public class NEq extends BinaryExpr
{
	public NEq(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}

	public String toString()
	{
		return "!=";
	}

	public LiteralExpr reduceValue(Interpreter context)
	{
		LiteralExpr leftValue = (LiteralExpr) this.left.reduceValue(context);
		LiteralExpr rightValue = (LiteralExpr) this.right.reduceValue(context);
		
		switch(leftValue.reduceType(context))
		{
			case INT:
				return new Bool( ((Int)leftValue).getValue() != ((Int)rightValue).getValue() );
			case BOOL:
				return new Bool( ((Bool)leftValue).getValue() != ((Bool)rightValue).getValue() );
			default:
				throw new Error("Encountered an unknown type in tree.");
		}
	}
}
