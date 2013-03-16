package nl.stgm.ql.ast.expr.terminal;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;

public class Int extends TerminalExpr
{
	private final int value;

	public Int(int n)
	{
		this.value = n;
	}

	public int getValue()
	{
		return value;
	}	
	
	public String prettyString()
	{
		return("Int: " + String.valueOf(value));
	}

	public String toString()
	{
		return(String.valueOf(value));
	}

	public Identifier.Type getType(SemanticChecker context)
	{
		return(Identifier.Type.INT);
	}
}
