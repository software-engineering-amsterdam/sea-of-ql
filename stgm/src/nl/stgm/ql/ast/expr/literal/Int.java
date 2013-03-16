package nl.stgm.ql.ast.expr.literal;
import nl.stgm.ql.ast.expr.*;

public class Int extends LiteralExpr
{
	private final int value;

	public Int(int n)
	{
		this.value = n;
	}

	public int getValue()
	{
		return value;
	}	

	public String toString()
	{
		return String.valueOf(value);
	}
}
