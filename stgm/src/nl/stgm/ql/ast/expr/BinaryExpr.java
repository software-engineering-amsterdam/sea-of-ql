package nl.stgm.ql.ast.expr;

import nl.stgm.ql.inspectors.*;

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

	public void print(PrettyPrinter context)
	{
		left.print(context);
		context.print(this.prettyString());
		right.print(context);
	}

	public void check(SemanticChecker context)
	{
		System.out.println("Check 1 element!" + this.toString());

		left.check(context);
		right.check(context);
	}

	public Identifier.Type getType(SemanticChecker context)
	{
		if(left.getType(context) == right.getType(context))
		{
			return left.getType(context);
		}
		else
		{
			// interpretererror?
			throw new Error("Incompatible types");
		}
	}
}
