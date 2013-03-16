package nl.stgm.ql.inspectors.checker;

public class Identifier
{
	public static enum Type
	{
		INT, BOOL, STRING;
		
		public static Type parse(String source)
		{
			switch(source)
			{
				case "int":
					return INT;
				case "boolean":
					return BOOL;
				case "string":
					return STRING;
			}
			
			return null;
		}
	}

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
	
	public boolean isComputed()
	{
		return computed;
	}
}
