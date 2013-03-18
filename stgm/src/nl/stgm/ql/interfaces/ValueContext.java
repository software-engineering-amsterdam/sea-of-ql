package nl.stgm.ql.interfaces;

import nl.stgm.ql.ast.expr.*;

public interface ValueContext
{
	public LiteralExpr lookupValue(String name);
}
