package org.uva.sea.ql.ast.types;


public class NumeralType extends TypeDescription {

	public NumeralType() {
		super("numeral");
	}

	@Override
	public boolean isCompatibleTo(TypeDescription t) {
		return t.isCompatibleToNumeric();
	}

	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}

	@Override
	public boolean isCompatibleToNumeric() {
		return true;
	}
}
