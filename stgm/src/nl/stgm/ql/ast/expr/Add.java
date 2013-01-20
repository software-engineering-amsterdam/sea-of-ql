package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.Expr;

public class Add extends BinaryExpr
{
	public Add(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
}
