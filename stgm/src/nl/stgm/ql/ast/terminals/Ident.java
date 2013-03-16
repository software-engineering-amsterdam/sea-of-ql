package nl.stgm.ql.ast.terminals;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspectors.*;

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

	public void check(SemanticChecker context)
	{
		// check of ident uberhaupt bestaat
		System.out.println("Check 1 element!" + this.toString());
	}

	public Class getType(SemanticChecker context)
	{
		// haal type uit context en return
		// either int or bool
		return(context.getType(this.name));
	}
}
