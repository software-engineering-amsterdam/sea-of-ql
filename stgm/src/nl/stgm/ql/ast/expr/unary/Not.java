package nl.stgm.ql.ast.expr.unary;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

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

	public Type getType(ValueContext context)
	{
		return new BoolType();
	}
	
	public void checkType(TypeCheckContext context)
	{
		if(!arg.getType(context).supportedAsBool())
		{
			context.registerTypeError(this, "Argument to ! should be a bool.");
		}
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
