package nl.stgm.ql.ast.expr;

public class LT extends BinaryExpr
{
	public LT(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
}
