package nl.stgm.ql.ast.expr;

import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;

public abstract class UnaryExpr extends Expr
{
	protected Expr arg;

	public void print(PrettyPrinter context)
	{
		context.print(this.prettyString());
		arg.print(context);
	}

	// public void check(SemanticChecker context)
	// {
	// 	System.out.println("Check 1 element!" + this.toString());
	// 
	// 	arg.check(context);
	// }
	
	public String toString()
	{
		return(this.prettyString() + arg.toString());
	}

	public Identifier.Type getType(SemanticChecker context)
	{
		// TODO: check if operator is appropriate for arg
		return arg.getType(context);
	}
}
