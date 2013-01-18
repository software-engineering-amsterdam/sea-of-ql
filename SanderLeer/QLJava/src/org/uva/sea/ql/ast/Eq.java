package org.uva.sea.ql.ast;

public class Eq extends ExprBinary {
	public Eq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
