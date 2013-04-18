package nl.stgm.ql.interfaces;

import nl.stgm.ql.data.*;

public interface TypeCheckContext extends ValueContext
{
	public void registerTypeError(TypeCheckable expr, String errorMessage);
}
