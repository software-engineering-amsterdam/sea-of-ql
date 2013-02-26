package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.types.declarations.IntDeclaration;
import org.uva.sea.ql.ast.types.declarations.TypeDeclaration;

public abstract class ArithmeticOperator extends BinaryOperator {

	public ArithmeticOperator(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public TypeDeclaration getType() {
		return new IntDeclaration();
	}
}
