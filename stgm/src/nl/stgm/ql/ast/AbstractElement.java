package nl.stgm.ql.ast;
import nl.stgm.ql.inspector.pretty.*;

public abstract class AbstractElement implements ASTNode, Printable
{
	public void print(ConsolePrinter context)
	{
		context.print(this.prettyString());
	}
	
	public String prettyString() throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException("either prettyString() must be overridden in this class to provide a representation for the pretty printer; or print() must be overridden not to call prettyString()");
	}
}
