package nl.stgm.ql.inspectors.checker;

public class Identifier
{
	String name;
	Type type;
	boolean computed;
	
	public Identifier(String name, String type, boolean isComputed)
	{
		this.name = name;
		this.type = Type.parse(type);
		this.computed = computed;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Type getType()
	{
		return this.type;
	}
	
	public boolean isOfType(String type)
	{
		return this.type == Type.parse(type);
	}
	
	public boolean isComputed()
	{
		return this.computed;
	}
}
