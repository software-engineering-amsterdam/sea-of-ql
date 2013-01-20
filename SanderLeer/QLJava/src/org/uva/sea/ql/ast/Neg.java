package org.uva.sea.ql.ast;

public class Neg extends UnaryExpression {
	public Neg(ASTNode expr) {
		super(expr);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
