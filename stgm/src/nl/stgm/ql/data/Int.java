package nl.stgm.ql.data;

public class Int extends Value
{
	int value;
	
	public Int(int i)
	{
		this.value = i;
	}
	
	public String toString()
	{
		return String.valueOf(value);
	}
	
	public int getValue()
	{
		return this.value;
	}

	public Type getType()
	{
		return Type.INT;
	}
}
