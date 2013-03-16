package nl.stgm.ql.ast.expr.unary;
import nl.stgm.ql.ast.expr.*;

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
