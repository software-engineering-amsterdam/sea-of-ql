package org.uva.sea.ql.ast.type;

public class IntegerType extends NumberType {
	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

	@Override
	public String getName() {
		return "Integer";
	}
}
