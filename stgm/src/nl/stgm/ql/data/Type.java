package nl.stgm.ql.data;

public interface Type
{
	public String toString();
	
	public boolean supportedAsBool();
	public boolean supportedAsInt();
	public boolean isUnknown();
}
