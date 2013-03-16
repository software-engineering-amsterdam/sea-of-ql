package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;

public abstract class Expr extends AbstractElement
{
	public abstract Type getType(SemanticChecker context) throws IncompatibleTypesException;

	// recursively generates complete expression string
	public abstract String pretty();

	public void print(PrettyPrinter context)
	{
		context.print(this.pretty());
	}	
}
