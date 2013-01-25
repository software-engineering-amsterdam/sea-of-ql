package nl.stgm.ql.ast.expr;

public class Div extends BinaryExpr
{
	public Div(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
}
