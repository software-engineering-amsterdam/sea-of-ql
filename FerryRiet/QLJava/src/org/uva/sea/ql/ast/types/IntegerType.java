package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.operators.ExpressionResult;
import org.uva.sea.ql.ast.operators.IntegerResult;

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

	@Override
	public ExpressionResult getTypeContainer() {
		return new IntegerResult(0);
	}
}
