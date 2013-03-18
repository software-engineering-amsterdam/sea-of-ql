package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;
import nl.stgm.ql.inspectors.interpreter.*;

public abstract class Expr extends AbstractNode
{
	// This class and its descendants delegate the inspecting to
	// tree-recursive calculating methods.
	
	public void print(PrettyPrinter context)
	{
		context.printExpression(this);
	}	

	public void check(Checker context)
	{
		context.checkExpression(this);
	}
	
	public void interpret(Interpreter context)
	{
		// no-op, because CalcQuestion and Conditional will call reduceValue() below
		throw new Error("This method should not be called on an Expr.");
	}

	// renderExpression() is used by both the PrettyPrinter and the Checker!
	public abstract String renderExpression();
	public abstract Type reduceType(TypeContext context) throws IncompatibleTypesException;
	public abstract LiteralExpr reduceValue(ValueContext context);
}
