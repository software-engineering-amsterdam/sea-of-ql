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

	public Type inferType(TypeContext context) throws IncompatibleTypesException
	{
		if(arg.inferType(context) == Type.BOOL)
			return Type.BOOL;
		else
			throw new IncompatibleTypesException();
	}
	
	public Value reduceValue(ValueContext context)
	{
		Value value = this.arg.reduceValue(context);
		
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
