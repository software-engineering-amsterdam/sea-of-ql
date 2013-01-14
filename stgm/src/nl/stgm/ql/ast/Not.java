package nl.stgm.ql.ast;

public class Not extends Expr
{
	private final Expr arg;

	public Not(Expr arg)
	{
		this.arg = arg;
	}
}
