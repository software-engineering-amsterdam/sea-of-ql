package nl.stgm.ql.data;

public class Bool extends Value
{
	boolean value;
	
	public Bool(boolean b)
	{
		this.value = b;
	}
	
	public String toString()
	{
		return String.valueOf(value);
	}
	
	public boolean getValue()
	{
		return this.value;
	}

	public Type getType()
	{
		return Type.BOOL;
	}
}
