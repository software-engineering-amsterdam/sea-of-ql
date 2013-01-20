package org.uva.sea.ql.ast;

public class Pos extends UnaryExpression {
	public Pos(ASTNode expr) {
		super(expr);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
