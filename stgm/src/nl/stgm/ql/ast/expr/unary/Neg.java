package nl.stgm.ql.ast.expr.unary;
import nl.stgm.ql.ast.expr.*;

public class Neg extends UnaryExpr
{
	public Neg(Expr arg)
	{
		this.arg = arg;
	}

	public String prettyString()
	{
		return "-";
	}
}
