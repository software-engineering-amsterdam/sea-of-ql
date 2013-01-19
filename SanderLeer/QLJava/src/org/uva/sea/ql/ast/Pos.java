package org.uva.sea.ql.ast;

public class Pos extends ExprUnary {
	public Pos(Expr expr) {
		super(expr);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
