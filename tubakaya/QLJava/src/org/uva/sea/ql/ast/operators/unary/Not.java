package org.uva.sea.ql.ast.operators.unary;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.operators.UnaryOperator;
import org.uva.sea.ql.ast.types.declarations.BooleanDeclaration;
import org.uva.sea.ql.ast.types.declarations.TypeDeclaration;

public class Not extends UnaryOperator {

	public Not(Expression expr) {
		super(expr);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public TypeDeclaration getType() {
		return new BooleanDeclaration();
	}
}
