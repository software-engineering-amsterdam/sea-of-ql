package nl.stgm.ql.ast.expr.binary;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public abstract class BinaryIntExpr extends BinaryExpr
{
	public BinaryIntExpr(ASTExpressionNode left, ASTExpressionNode right)
	{
		super(left, right);
	}

	public Type inferType(TypeContext context) throws IncompatibleTypesException
	{
		if(left.inferType(context) == Type.INT && right.inferType(context) == Type.INT)
			return Type.INT;
		else
			throw new IncompatibleTypesException();
	}
}
