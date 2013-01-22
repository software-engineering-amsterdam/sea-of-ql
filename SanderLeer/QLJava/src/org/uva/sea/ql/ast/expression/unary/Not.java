package org.uva.sea.ql.ast.expression.unary;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.expression.Expression;

public class Not extends UnaryExpression {
	public Not(Expression operand) {
		super(operand);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
