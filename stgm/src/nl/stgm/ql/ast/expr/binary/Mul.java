package nl.stgm.ql.ast.expr.binary;
import nl.stgm.ql.ast.expr.*;

public class Mul extends BinaryExpr
{
	public Mul(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}

	public String toString()
	{
		return "*";
	}
}
