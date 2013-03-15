package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.*;

public class Or extends BinaryExpr
{
	public Or(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}

	public String prettyString()
	{
		return " || ";
	}
}
