package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class BooleanLiteral extends Literal {

	private final boolean value;

	public BooleanLiteral(ICodeLocationInformation codeLocation, boolean value) {
		super(codeLocation);
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
