package nl.stgm.ql.ast.expr.binary;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public abstract class BinaryBoolExpr extends BinaryExpr
{
	public BinaryBoolExpr(Expr left, Expr right)
	{
		super(left, right);
	}

	public Type inferType(TypeContext context) throws IncompatibleTypesException
	{
		if(left.inferType(context) == Type.BOOL && right.inferType(context) == Type.BOOL)
			return Type.BOOL;
		else
			throw new IncompatibleTypesException();
	}
}
