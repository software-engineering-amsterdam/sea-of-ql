package nl.stgm.ql.ast.types;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.inspector.CodeInspector;

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
	
	public String prettyString()
	{
		return("Int: " + String.valueOf(value));
	}
}
