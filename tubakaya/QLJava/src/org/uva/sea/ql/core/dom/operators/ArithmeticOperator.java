package org.uva.sea.ql.core.dom.operators;

import org.uva.sea.ql.core.dom.Expression;
import org.uva.sea.ql.core.dom.types.declarations.IntDeclaration;
import org.uva.sea.ql.core.dom.types.declarations.TypeDeclaration;

public abstract class ArithmeticOperator extends Expression {

	private final Expression lhs;
	private final Expression rhs;

	public ArithmeticOperator(Expression lhs, Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expression getLhs() {
		return lhs;
	}

	public Expression getRhs() {
		return rhs;
	}

	@Override
	public TypeDeclaration getType() {
		return new IntDeclaration();
	}
}
