package org.uva.sea.ql.ast.expr.type;

import org.uva.sea.ql.ast.expr.grouping.ValueExpr;

public class NumericType extends Type {

	@Override
	public ValueExpr getMatchingNode(int lineNumber) {
		MoneyType type = new MoneyType();
		return type.getMatchingNode(lineNumber);
	}

	@Override
	public boolean isCompatibleTo(Type type) {
		return type.isCompatibleToNumeric();
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
