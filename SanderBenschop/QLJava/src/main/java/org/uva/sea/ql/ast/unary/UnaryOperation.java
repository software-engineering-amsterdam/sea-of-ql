package org.uva.sea.ql.ast.unary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public abstract class UnaryOperation implements QLExpression {

	private final QLExpression expression;

	public UnaryOperation(QLExpression expression) {
		this.expression = expression;
	}

	public QLExpression getExpression() {
		return expression;
	}

    @Override
    public void accept(ASTNodeVisitor visitor) {
        expression.accept(visitor);
        visitor.visitUnaryOperation(this);
    }

    public abstract Class<?> getSupportedType();
}
