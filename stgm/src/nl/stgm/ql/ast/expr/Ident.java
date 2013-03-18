package nl.stgm.ql.ast.expr;

import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;
import nl.stgm.ql.inspectors.interpreter.*;

public class Ident extends Expr
{
	private final String name;

	public Ident(String name)
	{
		this.name = name;
	}

	public String pretty()
	{
		return name;
	}

	public Type type(SemanticChecker context)
	{
		// the semantic checker knowns our type from previous definitions
		return context.lookupType(this.name);
	}

	public LiteralExpr reduce(Interpreter context)
	{
		return context.lookupValue(name);
	}
}
