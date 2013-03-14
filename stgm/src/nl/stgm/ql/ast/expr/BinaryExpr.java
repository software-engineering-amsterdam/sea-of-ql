package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspector.pretty.*;

public abstract class BinaryExpr extends Expr
{
	protected Expr left;
	protected Expr right;
	
	public Expr getLeft()
	{
		return left;
	}

	public Expr getRight()
	{
		return right;
	}

	public void print(ConsolePrinter context)
	{
		left.print(context);
		context.print(this.prettyString());
		right.print(context);
	}
}
