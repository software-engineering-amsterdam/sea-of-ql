package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.types.declarations.BooleanDeclaration;
import org.uva.sea.ql.ast.types.declarations.TypeDeclaration;

public abstract class ConditionalOperator extends Expression {

	private final Expression lhs;
	private final Expression rhs;

	public ConditionalOperator(Expression lhs, Expression rhs) {
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
		return new BooleanDeclaration();
	}
}
