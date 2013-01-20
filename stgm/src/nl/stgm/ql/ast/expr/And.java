package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.Expr;

public class And extends BinaryExpr
{
	public And(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
}
