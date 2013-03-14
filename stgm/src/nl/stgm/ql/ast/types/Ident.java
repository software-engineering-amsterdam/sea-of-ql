package nl.stgm.ql.ast.types;

import nl.stgm.ql.ast.*;

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

	public String prettyString()
	{
		return(name);
	}
}
