package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.*;

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
