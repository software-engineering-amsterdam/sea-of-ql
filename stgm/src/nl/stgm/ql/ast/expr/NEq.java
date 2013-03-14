package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.*;

public class NEq extends BinaryExpr
{
	public NEq(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}

	public String prettyString()
	{
		return " != ";
	}
}
