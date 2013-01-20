package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.Expr;

public class Not extends UnaryExpr
{
	public Not(Expr arg)
	{
		this.arg = arg;
	}
}
