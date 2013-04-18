package nl.stgm.ql.data;

public class IntType implements Type
{
	public String toString()
	{
		return "int";
	}
	
	public boolean supportedAsBool()
	{
		return false;
	}
	
	public boolean supportedAsInt()
	{
		return true;
	}
	
	public boolean isUnknown()
	{
		return false;
	}
}
