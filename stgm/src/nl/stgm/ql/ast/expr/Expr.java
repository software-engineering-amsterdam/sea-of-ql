package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspectors.*;

public abstract class Expr extends AbstractNode
{
	// This class and its descendants have three tree-recursive calculating methods
	
	public abstract String renderExpression();
	public abstract Type reduceType(TypeContext context) throws IncompatibleTypesException;
	public abstract LiteralExpr reduceValue(ValueContext context);

	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
