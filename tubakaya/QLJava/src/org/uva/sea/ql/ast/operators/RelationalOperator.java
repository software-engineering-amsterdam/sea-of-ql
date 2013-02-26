package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.types.declarations.BooleanDeclaration;
import org.uva.sea.ql.ast.types.declarations.TypeDeclaration;

public abstract class RelationalOperator extends BinaryOperator {

	public RelationalOperator(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public TypeDeclaration getType() {
		return new BooleanDeclaration();
	}
}
