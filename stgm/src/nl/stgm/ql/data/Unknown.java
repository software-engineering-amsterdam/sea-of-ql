package nl.stgm.ql.data;

public class Unknown implements Value
{
	public Type getType()
	{
		return new UnknownType();
	}
	
	public boolean equals(Value v)
	{
		return false;
	}
}
