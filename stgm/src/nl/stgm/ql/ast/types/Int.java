package nl.stgm.ql.ast.types;
import nl.stgm.ql.ast.expr.*;

public class Int extends Expr
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
		return("Int: " + String.valueOf(value));
	}
}
