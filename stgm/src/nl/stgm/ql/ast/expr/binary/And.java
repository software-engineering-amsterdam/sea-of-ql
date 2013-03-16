package nl.stgm.ql.ast.expr.binary;
import nl.stgm.ql.ast.expr.*;

public class And extends BinaryExpr
{
	public And(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}

	public String prettyString()
	{
		return " && ";
	}
}
