package nl.stgm.ql.data;

public class Bool implements Value
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
		return new BoolType();
	}

	public boolean equals(Value v)
	{
		assert v.getType().supportedAsBool();
		return this.value == ((Bool)v).getValue();
	}
}
