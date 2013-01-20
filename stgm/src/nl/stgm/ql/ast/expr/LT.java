package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.Expr;

public class LT extends BinaryExpr
{
	public LT(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
}
