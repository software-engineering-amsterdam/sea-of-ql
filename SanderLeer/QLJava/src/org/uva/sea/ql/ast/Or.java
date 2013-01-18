package org.uva.sea.ql.ast;

public class Or extends ExprBinary {
	public Or(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
