package nl.stgm.ql.ast.expr.binary;
import nl.stgm.ql.ast.expr.*;

public class LT extends BinaryExpr
{
	public LT(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}

	public String prettyString()
	{
		return " < ";
	}
}
