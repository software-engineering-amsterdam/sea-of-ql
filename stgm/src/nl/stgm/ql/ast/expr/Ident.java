package nl.stgm.ql.ast.expr;

import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;

public class Ident extends Expr
{
	private final String name;

	public Ident(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public String toString()
	{
		return name;
	}

	public String pretty()
	{
		return name;
	}

	public Type getType(SemanticChecker context)
	{
		// context knowns our type from previous definitions
		return context.lookupType(this.name);
	}
}
