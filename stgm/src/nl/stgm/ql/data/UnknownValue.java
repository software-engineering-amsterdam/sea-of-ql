package nl.stgm.ql.data;

public class UnknownValue extends Value
{
	public Type getType()
	{
		return Type.UNKNOWN;
	}
	
	public boolean isUnknown()
	{
		return true;
	}
}
