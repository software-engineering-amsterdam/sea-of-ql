package nl.stgm.ql.ast.expr;

public class Not extends UnaryExpr
{
	public Not(Expr arg)
	{
		this.arg = arg;
	}

	public String prettyString()
	{
		return "!";
	}
}
