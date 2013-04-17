package nl.stgm.ql.interfaces;

import nl.stgm.ql.data.*;

public interface Interpretable
{
	public abstract String renderExpressionString();
	public abstract Type inferType(TypeContext context) throws IncompatibleTypesException;
	public abstract Value reduceValue(ValueContext context);
}
