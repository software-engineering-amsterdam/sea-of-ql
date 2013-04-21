package nl.stgm.ql.ast;

import nl.stgm.ql.data.*;

public interface TypeCheckContext
{
	public Type getType(String id);
	public void registerError(TypeCheckable expr, String errorMessage);
}
