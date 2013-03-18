package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;
import nl.stgm.ql.inspectors.interpreter.*;

public abstract class Expr extends AbstractElement
{
	// This class and its descendants delegate the inspecting to
	// tree-recursive calculating methods.
	
	public void print(PrettyPrinter context)
	{
		context.print(this.renderExpression());
	}	

	// renderExpression() is used by both the PrettyPrinter and the SemanticChecker!

	public abstract String renderExpression();

	public void check(SemanticChecker context)
	{
		context.performTypeCheck(this);
	}
	
	public abstract Type reduceType(SemanticChecker context) throws IncompatibleTypesException;

	public void interpret(Interpreter context)
	{
		// no-op, because CalcQuestion and Conditional will call reduceValue() below
		throw new Error("This method should not be called on an Expr.");
	}

	public abstract LiteralExpr reduceValue(Interpreter context);
}
