package nl.stgm.ql.data;

public class Int implements Value
{
	int value;
	
	public Int(int i)
	{
		this.value = i;
	}
	
	public Int(String s)
	{
		this.value = Integer.parseInt(s);
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
		return new IntType();
	}

	public boolean equals(Value v)
	{
		assert v.getType().supportedAsInt();
		return this.value == ((Int)v).getValue();
	}
}
