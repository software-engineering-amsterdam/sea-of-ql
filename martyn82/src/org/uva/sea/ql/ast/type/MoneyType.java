package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.visitor.TypeVisitor;

public class MoneyType extends NumberType {
	public final static MoneyType MONEY = new MoneyType();

	private MoneyType() {}

	@Override
	public <T> T accept( TypeVisitor<T> visitor ) {
		return visitor.visit( this );
	}

	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}

	@Override
	public String getName() {
		return "Money";
	}
}
