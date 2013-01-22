package org.uva.sea.ql.ast;

public class NumeralType extends TypeDescription {

	public NumeralType() {
		super("numeral");
	}

	@Override
	public boolean compatibleType(TypeDescription testType) {
		if (testType.getClass() == NumeralType.class
				|| testType.getClass() == MoneyType.class) {
			return true;
		}
		return false;
	}
}
