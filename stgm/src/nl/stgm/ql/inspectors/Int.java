package nl.stgm.ql.inspectors;

public class Int extends Value
{
	private int intValue;
	
	private boolean containsBoolean = false;
	private boolean containsInt = true;
	
	public Int(int v)
	{
		intValue = v;
	}
	
	public int getIntValue()
	{
		if(!containsInt)
		{
			throw new Error("Tried getting intValue from non-integer.");
		}
		
		return intValue;
	}

	public String toString()
	{
		return String.valueOf(intValue);
	}
}
