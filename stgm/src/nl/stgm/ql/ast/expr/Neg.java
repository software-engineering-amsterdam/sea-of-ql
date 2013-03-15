package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.*;

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
