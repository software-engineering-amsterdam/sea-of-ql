package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.*;

public class Mul extends BinaryExpr
{
	public Mul(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}

	public String prettyString()
	{
		return " * ";
	}
}
