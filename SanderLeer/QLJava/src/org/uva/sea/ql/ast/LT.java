package org.uva.sea.ql.ast;

public class LT extends ExprBinary {
	public LT(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
