package nl.stgm.ql.data;

public interface Value
{
	public abstract Type getType();
	public abstract boolean equals(Value v);
}
