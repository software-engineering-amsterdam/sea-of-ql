package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.Expr;

public class Sub extends BinaryExpr
{
	public Sub(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
}
