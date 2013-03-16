package nl.stgm.ql.ast.expr.terminal;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;

public class Ident extends TerminalExpr
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

	public String prettyString()
	{
		return(name);
	}

	public String toString()
	{
		return(name);
	}

	public Identifier.Type getType(SemanticChecker context)
	{
		// haal type uit context en return
		// either int or bool
		return(context.lookupType(this.name));
	}
}
