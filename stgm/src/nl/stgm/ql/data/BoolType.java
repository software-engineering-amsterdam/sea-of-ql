package nl.stgm.ql.data;

public class BoolType implements Type
{
	public String toString()
	{
		return "boolean";
	}
	
	public boolean supportedAsBool()
	{
		return true;
	}
	
	public boolean supportedAsInt()
	{
		return false;
	}
	
	public boolean isUnknown()
	{
		return false;
	}
	
	public boolean equals(Bool b)
	{
		return true;
	}
	
	public boolean equals(Int b)
	{
		return false;
	}
}
