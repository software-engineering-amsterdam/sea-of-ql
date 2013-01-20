package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.Expr;

public class Div extends BinaryExpr
{
	public Div(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
}
