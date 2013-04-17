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

	public Type getType(TypeContext context)
	{
		return Type.BOOL;
	}
	
	public void checkType(TypeCheckContext context)
	{
		if(arg.getType(context) != Type.BOOL)
		{
			context.registerTypeError(this, "Argument to ! should be a bool.");
		}
	}

	public Value getValue(ValueContext context)
	{
		Value value = this.arg.getValue(context);
		
		if(value.isUnknown()) // TODO stuff like this
		{
			return value;
		}
		else
		{
			Bool boolValue = (Bool) value;
			return new Bool(!boolValue.getValue());
		}
	}
}
