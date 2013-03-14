package nl.stgm.ql.ast.expr;

public class GT extends BinaryExpr
{
	public GT(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}

	public String prettyString()
	{
		return " > ";
	}
}
