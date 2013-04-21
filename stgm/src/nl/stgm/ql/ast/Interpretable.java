package nl.stgm.ql.ast;

import nl.stgm.ql.data.*;

public interface Interpretable
{
	public abstract Value getValue(ValueContext context);
}
