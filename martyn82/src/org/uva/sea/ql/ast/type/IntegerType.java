package org.uva.sea.ql.ast.type;

public class IntegerType extends NumberType {
	public final static IntegerType INTEGER = new IntegerType();

	private IntegerType() {}

	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

	@Override
	public String getName() {
		return "Integer";
	}
}
