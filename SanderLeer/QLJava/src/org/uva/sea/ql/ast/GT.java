package org.uva.sea.ql.ast;

public class GT extends ExprBinary {
	public GT(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
