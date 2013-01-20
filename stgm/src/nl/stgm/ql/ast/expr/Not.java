package nl.stgm.ql.ast.expr;

public class Not extends Expr
{
	private final Expr arg;

	public Not(Expr arg)
	{
		this.arg = arg;
	}
}
