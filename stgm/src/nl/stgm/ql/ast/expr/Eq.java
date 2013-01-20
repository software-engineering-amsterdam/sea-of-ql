package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.Expr;

public class Eq extends BinaryExpr
{
	public Eq(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
}
