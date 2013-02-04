package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.IExpressionVisitor;

public class IntegerLiteral extends NumberLiteral {

	private long value;
	
	public IntegerLiteral(ICodeLocationInformation codeLocation, long value) {
		super(codeLocation);
		this.value = value;
	}
	
	public long getValue() {
		return value;
	}
	
	public <T> T accept(IExpressionVisitor<T> visitor)
	{
		return visitor.visit(this);
	}
}
