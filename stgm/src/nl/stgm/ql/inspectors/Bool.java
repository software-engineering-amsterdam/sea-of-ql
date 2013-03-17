package nl.stgm.ql.inspectors;

public class Bool extends Value
{
	private boolean booleanValue;
	
	private boolean containsBoolean = true;
	private boolean containsInt = false;
	
	public Bool(boolean v)
	{
		booleanValue = v;
	}
	
	public boolean getBooleanValue()
	{
		if(!containsBoolean)
		{
			throw new Error("Tried getting booleanValue from non-boolean.");
		}
		
		return booleanValue;
	}
	
	public String toString()
	{
		return String.valueOf(booleanValue);
	}
}
