package org.uva.sea.ql.ast;

public class Neg extends ExprUnary {
	public Neg(Expr expr) {
		super(expr);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
