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
		context.print(this.pretty());
	}	

	public abstract String pretty();

	public void check(SemanticChecker context)
	{
		context.performTypeCheck(this);
	}
	
	public abstract Type type(SemanticChecker context) throws IncompatibleTypesException;

	public void interpret(Interpreter context)
	{
		// context.register
	}

	public abstract Value evaluate(Interpreter context);
}
