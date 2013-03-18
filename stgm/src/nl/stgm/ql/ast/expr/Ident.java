package nl.stgm.ql.ast.expr;

import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public class Ident extends Expr
{
	private final String name;

	public Ident(String name)
	{
		this.name = name;
	}

	public String renderExpressionString()
	{
		return name;
	}

	public Type inferType(TypeContext context)
	{
		// the semantic checker knowns our type from previous definitions
		return context.lookupType(this.name);
	}

	public Value reduceValue(ValueContext context)
	{
		// the semantic checker knowns our type from previous input
		return context.lookupValue(name);
	}
}
