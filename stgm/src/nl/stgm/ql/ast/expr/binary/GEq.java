package nl.stgm.ql.ast.expr.binary;
import nl.stgm.ql.ast.expr.*;

public class GEq extends BinaryExpr
{
	public GEq(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}

	public String toString()
	{
		return ">=";
	}
}
