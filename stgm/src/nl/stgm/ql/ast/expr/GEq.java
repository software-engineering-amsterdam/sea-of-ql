package nl.stgm.ql.ast.expr;

public class GEq extends BinaryExpr
{
	public GEq(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
}
