package nl.stgm.ql.data;

public abstract class Value
{
	public abstract Type getType();

	public boolean isUnknown()
	{
		return false;
	}
}
