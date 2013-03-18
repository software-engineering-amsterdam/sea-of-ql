package nl.stgm.ql.inspectors;

public class Identifier
{
	String name;
	Type type;
	boolean computed;

	public Identifier(String name, Type type, boolean isComputed)
	{
		this.name = name;
		this.type = type;
		this.computed = computed;
	}

	public Type getType()
	{
		return this.type;
	}

	public boolean isOfType(Type type)
	{
		return this.type == type;
	}

	public boolean isComputed()
	{
		return this.computed;
	}
}
