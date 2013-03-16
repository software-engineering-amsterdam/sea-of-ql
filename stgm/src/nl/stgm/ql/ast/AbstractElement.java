package nl.stgm.ql.ast;

import nl.stgm.ql.inspectors.pretty.*;
import nl.stgm.ql.inspectors.checker.*;

public abstract class AbstractElement implements ASTNode, Printable, Checkable
{
	public void print(PrettyPrinter context)
	{
		context.print(this.prettyString());
	}
	
	public String prettyString() throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Pretty Printing code is missing in this node. Please check the documentation in AbstractElement.java");
	}
}
