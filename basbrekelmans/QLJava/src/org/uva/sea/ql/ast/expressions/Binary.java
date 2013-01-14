package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

public abstract class Binary extends Expression {
	
	private final Expression left;
	private final Expression right;
	
	public Binary(ICodeLocationInformation codeLocation, Expression left, Expression right) {
		super(codeLocation);
		this.left = left;
		this.right = right;
	}
	
	public Expression getLeft() {
		return left;
	}
	
	public Expression getRight() {
		return right;
	}
}
