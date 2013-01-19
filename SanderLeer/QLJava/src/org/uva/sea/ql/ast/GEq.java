package org.uva.sea.ql.ast;

public class GEq extends ExprBinary {
	public GEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
