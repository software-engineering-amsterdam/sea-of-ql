package nl.stgm.ql.data;

public interface Type
{
	public String toString();
	
	public boolean supportedAsBool();
	public boolean supportedAsInt();
	public boolean isUnknown();
	
	public boolean equals(Bool b);
	public boolean equals(Int b);
}
