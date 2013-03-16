package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;

public abstract class Expr extends AbstractElement
{
	// recursively finds the type of the expression, throwing errors wherever it 
	// goes wrong
	public abstract Type getType(SemanticChecker context) throws IncompatibleTypesException;

	// no special line breaks etc in printing expressions, so we delegate to the
	// tree-recursive pretty() function that generates one string for the 
	// complete expression
	public void print(PrettyPrinter context)
	{
		context.print(this.pretty());
	}	

	// recursively generates complete expression string
	// used with the PrettyPrinter and the SemanticChecker (for error reporting)
	public abstract String pretty();
}
