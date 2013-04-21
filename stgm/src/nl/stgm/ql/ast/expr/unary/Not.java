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
		// TODO blerf
		
		if(this.arg.getValue(context).getType().supportedAsBool())
		{
			Bool value = (Bool) this.arg.getValue(context);
			return new Bool(!value.getValue());
		}
		else
		{
			return new Unknown();
		}
	}
}
