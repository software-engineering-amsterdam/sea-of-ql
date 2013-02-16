package org.uva.sea.ql.ast.type;

abstract public class NumberType extends Type {
	protected NumberType() {}

	@Override
	public boolean isCompatibleTo( Type type ) {
		return type.isCompatibleToNumber();
	}

	@Override
	public boolean isCompatibleToNumber() {
		return true;
	}

	@Override
	public boolean isCompatibleToInt() {
		return false;
	}

	@Override
	public boolean isCompatibleToMoney() {
		return false;
	}

	@Override
	public String getName() {
		return "Number";
	}
}
