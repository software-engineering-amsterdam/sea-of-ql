package nl.stgm.ql.ast.expr;

import nl.stgm.ql.inspectors.*;

public abstract class UnaryExpr extends Expr
{
	protected Expr arg;

	public void print(PrettyPrinter context)
	{
		context.print(this.prettyString());
		arg.print(context);
	}

	public void check(SemanticChecker context)
	{
		System.out.println("Check 1 element!" + this.toString());

		arg.check(context);
	}

	public Identifier.Type getType(SemanticChecker context)
	{
		// if(arg.getClass())
		// {
			return arg.getType(context);
		// }
		// else
		// {
		// 	// interpretererror
		// 	throw new Error();
		// }
	}
}
