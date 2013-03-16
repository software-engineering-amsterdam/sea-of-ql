package nl.stgm.ql.ast;

import nl.stgm.ql.inspectors.*;

public abstract class AbstractElement implements ASTNode, Printable, Checkable
{
	//
	// You will need to provide a prettyString() implementation for each concrete descendant of this class.
	// Alternatively, you can override print() to enable a more complex printing flow.
	//
	
	public void print(PrettyPrinter context)
	{
		context.print(this.prettyString());
	}
	
	public String prettyString() throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Pretty Printing code is missing in this node. Please check the documentation in AbstractElement.java");
	}
}
