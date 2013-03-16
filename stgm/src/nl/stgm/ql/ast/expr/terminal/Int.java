package nl.stgm.ql.ast.expr.terminal;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.inspectors.*;

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

	public void check(SemanticChecker context)
	{
		System.out.println("Check 1 element!" + this.toString());
	}

	public Class getType(SemanticChecker context)
	{
		return(Int.class);
	}
}
