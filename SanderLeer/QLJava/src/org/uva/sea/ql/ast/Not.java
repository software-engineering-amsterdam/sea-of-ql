package org.uva.sea.ql.ast;

public class Not extends UnaryExpression {
	public Not(ASTNode expr) {
		super(expr);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
