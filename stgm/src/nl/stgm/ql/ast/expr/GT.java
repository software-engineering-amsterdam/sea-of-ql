package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.Expr;

public class GT extends BinaryExpr
{
	public GT(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
}
