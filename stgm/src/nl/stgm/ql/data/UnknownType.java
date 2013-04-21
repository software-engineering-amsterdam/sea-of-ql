package nl.stgm.ql.data;

public class UnknownType implements Type
{
	public String toString()
	{
		assert false : "toString() should not be called on an unknown value";
		return null;
	}
	
	public boolean supportedAsBool()
	{
		return false;
	}
	
	public boolean supportedAsInt()
	{
		return false;
	}
	
	public boolean isUnknown()
	{
		return true;
	}

	public boolean equals(Bool b)
	{
		return false;
	}
	
	public boolean equals(Int b)
	{
		return false;
	}
}
