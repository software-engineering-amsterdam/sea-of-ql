package nl.stgm.ql.ast.types;

import nl.stgm.ql.ast.Expr;

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
		return("ident " + name);
	}
}
