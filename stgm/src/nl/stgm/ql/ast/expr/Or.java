package nl.stgm.ql.ast.expr;

public class Or extends BinaryExpr
{
	public Or(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
}