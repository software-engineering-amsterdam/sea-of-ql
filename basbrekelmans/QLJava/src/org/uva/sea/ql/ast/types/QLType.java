package org.uva.sea.ql.ast.types;

public abstract class QLType {

	protected QLType() { }
	
	public abstract boolean isNumber();
	
	public static final QLType BOOLEAN = new BooleanType();
	public static final QLType STRING = new StringType();
	public static final QLType INTEGER = new IntegerType();
	public static final QLType MONEY = new MoneyType();
	public static final QLType UNKNOWN = new UnknownType();
	
	public static QLType parse(String name)
	{
		switch(name)
		{
			case "bool": return BOOLEAN;
			case "string": return STRING;
			case "money": return MONEY;
			case "int": return INTEGER;
			default:
				return UNKNOWN;
		}
	}
}
