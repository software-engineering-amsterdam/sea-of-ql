package nl.stgm.ql.ast.types;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.inspector.CodeInspector;

public class Bool extends Expr
{
	private final boolean value;

	public Bool(boolean b)
	{
		this.value = b;
	}

	public boolean getValue()
	{
		return value;
	}
	
	public String prettyString()
	{
		return("bool: " + String.valueOf(value));
	}
}
