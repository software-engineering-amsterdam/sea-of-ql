package org.uva.sea.ql.ast.types;

public class IntegerType extends TypeDescription {

	public IntegerType() {
		super("numeral");
	}

	@Override
	public boolean isCompatibleTo(TypeDescription t) {
		return t.isCompatibleToInt();
	}

	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

	@Override
	public boolean isCompatibleToMoney() {
		return false;
	}
}
