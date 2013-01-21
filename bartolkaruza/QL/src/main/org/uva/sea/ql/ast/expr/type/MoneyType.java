package org.uva.sea.ql.ast.expr.type;

import org.uva.sea.ql.ast.expr.grouping.ValueExpr;
import org.uva.sea.ql.ast.expr.value.Money;

public class MoneyType extends NumericType {

	@Override
	public ValueExpr getMatchingNode(int lineNumber) {
		return new Money(lineNumber);
	}
	
	@Override
	public boolean isCompatibleTo(Type type) {
		return type.isCompatibleToMoney();
	}

}
