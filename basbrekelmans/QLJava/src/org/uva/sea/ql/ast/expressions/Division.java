package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.IExpressionVisitor;

public class Division extends Arithmetic {

	public Division(ICodeLocationInformation codeLocation,
			Expression left, Expression right) {
		super(codeLocation, left, right);
	}
	
	public <T> T accept(IExpressionVisitor<T> visitor)
	{
		return visitor.visit(this);
	}
}
