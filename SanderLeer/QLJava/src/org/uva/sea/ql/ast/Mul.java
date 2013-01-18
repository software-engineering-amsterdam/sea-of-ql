package org.uva.sea.ql.ast;

public class Mul extends ExprBinary {
	public Mul(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
