package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.IExpressionVisitor;

public class MoneyLiteral extends NumberLiteral {

	private double value;
	
	public MoneyLiteral(ICodeLocationInformation codeLocation, double value) {
		super(codeLocation);
		this.value = value;
	}

	public double getValue() {
		return value;
	}
	
	public <T> T accept(IExpressionVisitor<T> visitor)
	{
		return visitor.visit(this);
	}

}
