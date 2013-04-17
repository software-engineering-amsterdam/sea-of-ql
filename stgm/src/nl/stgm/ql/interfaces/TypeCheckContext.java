package nl.stgm.ql.interfaces;

import nl.stgm.ql.data.*;

public interface TypeCheckContext extends TypeContext
{
	public void registerTypeError(TypeCheckable expr, String errorMessage);
}
