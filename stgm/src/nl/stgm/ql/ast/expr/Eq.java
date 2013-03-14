package nl.stgm.ql.ast.expr;

public class Eq extends BinaryExpr
{
	public Eq(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}

	public String prettyString()
	{
		return " == ";
	}
}
