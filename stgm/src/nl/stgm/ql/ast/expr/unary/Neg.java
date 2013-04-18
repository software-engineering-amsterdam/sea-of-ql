package nl.stgm.ql.ast.expr.unary;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

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
	
	public void checkType(TypeCheckContext context)
	{
		if(!arg.getType(context).supportedAsInt())
		{
			context.registerTypeError(this, "Argument to - should be an int.");
		}
	}

	public Value getValue(ValueContext context)
	{
		Int value = (Int) this.arg.getValue(context);
		return new Int(-value.getValue());
	}
}
