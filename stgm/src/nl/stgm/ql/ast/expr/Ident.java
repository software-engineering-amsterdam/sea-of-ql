package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.data.*;

public class Ident extends ASTExpressionNode
{
	private final String name;

	public Ident(String name)
	{
		this.name = name;
	}

	public String render()
	{
		return name;
	}

	public Type getType(ValueContext context)
	{
		// the semantic checker knowns our type from previous definitions
		return context.getValue(this.name).getType();
	}
	
	public Type checkType(TypeCheckContext context)
	{
		return context.getType(this.name);
	}

	public Value getValue(ValueContext context)
	{
		// the semantic checker knowns our type from previous input
		return context.getValue(this.name);
	}
}
