package org.uva.sea.ql.ast.nodetypes.unary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.parser.visitor.ASTNodeVisitor;

public abstract class UnaryOperationExpression extends QLExpression {
	
	private final QLExpression expression;
	
	public UnaryOperationExpression(QLExpression expression) {
		this.expression = expression;
	}
	
	public QLExpression getExpression() {
		return expression;
	}

    @Override
    public void accept(ASTNodeVisitor visitor) {
    }
}
