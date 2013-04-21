package nl.stgm.ql.ast;

import nl.stgm.ql.data.*;

public interface TypeCheckable
{
	public void checkType(TypeCheckContext context);
}
