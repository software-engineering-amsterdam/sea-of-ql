package org.uva.sea.ql.ast.types;

public abstract class Type {

	protected Type() { }
	
	public boolean isNumber() {
		return false;
	}
	
	public boolean isBoolean() {
		return false;
	}
	
	public boolean isString() {
		return false;
	}
	
	public static final Type BOOLEAN = new BooleanType();
	public static final Type STRING = new StringType();
	public static final Type INTEGER = new IntegerType();
	public static final Type MONEY = new MoneyType();
	public static final Type UNKNOWN = new UnknownType();
}
