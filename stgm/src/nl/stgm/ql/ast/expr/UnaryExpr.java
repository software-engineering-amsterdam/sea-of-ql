package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspectors.*;

public abstract class UnaryExpr extends Expr
{
	protected Expr arg;

	public void print(PrettyPrinter context)
	{
		context.print(this.prettyString());
		arg.print(context);
	}
}
