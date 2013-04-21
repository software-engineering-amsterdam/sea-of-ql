package nl.stgm.ql.ast.expr.unary;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;

public class Neg extends UnaryExpr
{
	public Neg(ASTExpressionNode arg)
	{
		super(arg);
	}

	public String toString()
	{
		return "-";
	}

	public Type getType(ValueContext context)
	{
		return new IntType();
	}
	
	public Type checkType(TypeCheckContext context)
	{
		if(!arg.checkType(context).supportedAsInt())
		{
			context.registerError(this, "Argument to - should be an int.");
		}

		return new IntType();
	}

	public Value getValue(ValueContext context)
	{
		Int value = (Int) this.arg.getValue(context);
		return new Int(-value.getValue());
	}
}
