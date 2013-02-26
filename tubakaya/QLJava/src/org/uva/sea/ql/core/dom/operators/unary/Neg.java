package org.uva.sea.ql.core.dom.operators.unary;

import org.uva.sea.ql.core.dom.ExpressionVisitor;
import org.uva.sea.ql.core.dom.Expression;
import org.uva.sea.ql.core.dom.operators.UnaryOperator;
import org.uva.sea.ql.core.dom.types.declarations.IntDeclaration;
import org.uva.sea.ql.core.dom.types.declarations.TypeDeclaration;

public class Neg extends UnaryOperator {

	public Neg(Expression expr) {
		super(expr);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public TypeDeclaration getType() {
		return new IntDeclaration();
	}
}
