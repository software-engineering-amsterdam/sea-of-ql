package nl.stgm.ql.ast.expr.terminal;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;

public class Bool extends TerminalExpr
{
	private final boolean value;

	public Bool(boolean b)
	{
		this.value = b;
	}

	public boolean getValue()
	{
		return value;
	}
	
	public String prettyString()
	{
		return("bool: " + String.valueOf(value));
	}
	
	public String toString()
	{
		return(String.valueOf(value));
	}

	public Identifier.Type getType(SemanticChecker context)
	{
		// TODO
		return(Identifier.Type.BOOL);
	}
}
