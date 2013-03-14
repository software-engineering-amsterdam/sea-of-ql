package nl.stgm.ql.ast.expr;

public class Sub extends BinaryExpr
{
	public Sub(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
	
	public String prettyString()
	{
		return " - ";
	}
}
