package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.IExpressionVisitor;

public class StringLiteral extends Literal {

	private final String value;
	
	public StringLiteral(ICodeLocationInformation codeLocation, String value) {
		super(codeLocation);
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}
	
	public <T> T accept(IExpressionVisitor<T> visitor)
	{
		return visitor.visit(this);
	}
}
