package org.uva.sea.ql.ast.types;

import java.math.BigDecimal;

import org.uva.sea.ql.ast.operators.ExpressionResult;
import org.uva.sea.ql.ast.operators.MoneyResult;

public class MoneyType extends TypeDescription {

	public MoneyType() {
		super("money");
	}

	@Override
	public boolean isCompatibleTo(TypeDescription t) {
		return t.isCompatibleToMoney();
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
	public ExpressionResult getTypeContainer() {
		return new MoneyResult(new BigDecimal(0));
	}
}
