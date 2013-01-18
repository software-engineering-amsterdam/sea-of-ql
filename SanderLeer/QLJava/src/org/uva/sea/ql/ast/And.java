package org.uva.sea.ql.ast;

public class And extends ExprBinary {
	public And(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
