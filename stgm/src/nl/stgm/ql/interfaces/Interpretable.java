package nl.stgm.ql.interfaces;

import nl.stgm.ql.data.*;

public interface Interpretable
{
	public abstract String render();
	public abstract Type getType(ValueContext context);
	public abstract Value getValue(ValueContext context);
}
