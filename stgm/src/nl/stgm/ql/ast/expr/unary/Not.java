package nl.stgm.ql.ast.expr.unary;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;

public class Not extends UnaryExpr
{
	public Not(ASTExpressionNode arg)
	{
		super(arg);
	}

	public String toString()
	{
		return "!";
	}

	public Type checkType(TypeCheckContext context)
	{
		if(!arg.checkType(context).supportedAsBool())
		{
			context.registerError(this, "Argument to ! should be a bool.");
		}

		return new BoolType();
	}

	public Value getValue(ValueContext context)
	{
		Value v = this.arg.getValue(context);
		
		if(v.getType().supportedAsBool())
		{
			return new Bool(!((Bool) v).getValue());
		}
		else
		{
			return new Unknown();
		}
	}
}
