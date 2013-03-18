package nl.stgm.ql.inspectors;

import nl.stgm.ql.ast.expr.*;

public interface ValueContext
{
	public LiteralExpr lookupValue(String name);
}
