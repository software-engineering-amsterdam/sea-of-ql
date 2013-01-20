package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.Expr;

public class GEq extends BinaryExpr
{
	public GEq(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
}
