package org.uva.sea.ql.ast.nodetypes.unary;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public abstract class UnaryOperation implements QLExpression {

	private final ASTNode expression;

	public UnaryOperation(ASTNode expression) {
		this.expression = expression;
	}

	public ASTNode getExpression() {
		return expression;
	}

    @Override
    public void accept(ASTNodeVisitor visitor) {
        expression.accept(visitor);
        visitor.visitUnaryOperation(this);
    }

    public abstract Class<?> getSupportedType();
}
