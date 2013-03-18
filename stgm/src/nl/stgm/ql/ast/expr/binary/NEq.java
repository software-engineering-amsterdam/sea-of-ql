package nl.stgm.ql.ast.expr.binary;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public class NEq extends BinaryExpr
{
	public NEq(Expr left, Expr right)
	{
		super(left, right);
	}

	public String toString()
	{
		return "!=";
	}

	public Value reduceValue(ValueContext context)
	{
		Value leftValue = (Value) this.left.reduceValue(context);
		Value rightValue = (Value) this.right.reduceValue(context);
		
		switch(leftValue.getType())
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
