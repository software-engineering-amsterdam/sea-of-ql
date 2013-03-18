package nl.stgm.ql.ast.expr.unary;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public class Pos extends UnaryExpr
{
	public Pos(Expr arg)
	{
		super(arg);
	}

	public String toString()
	{
		return "+";
	}

	public Type inferType(TypeContext context) throws IncompatibleTypesException
	{
		if(arg.inferType(context) == Type.INT)
			return Type.INT;
		else
			throw new IncompatibleTypesException();
	}
	
	public Value reduceValue(ValueContext context)
	{
		Int value = (Int) this.arg.reduceValue(context);
		return value;
	}
}
