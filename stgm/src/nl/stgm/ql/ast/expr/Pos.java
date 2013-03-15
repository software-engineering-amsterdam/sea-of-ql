package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.*;

public class Pos extends UnaryExpr
{
	public Pos(Expr arg)
	{
		this.arg = arg;
	}

	public String prettyString()
	{
		return "+";
	}
}
