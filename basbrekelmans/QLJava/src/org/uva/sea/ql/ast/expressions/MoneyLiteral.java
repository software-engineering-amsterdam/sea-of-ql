package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.types.QLType;

public class MoneyLiteral extends NumberLiteral {

	private double value;
	
	public MoneyLiteral(ICodeLocationInformation codeLocation, double value) {
		super(codeLocation);
		this.value = value;
	}

	@Override
	public QLType getType() {
		return QLType.MONEY;
	}

}
