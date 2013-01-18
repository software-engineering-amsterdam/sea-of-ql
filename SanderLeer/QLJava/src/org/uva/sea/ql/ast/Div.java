package org.uva.sea.ql.ast;

public class Div extends ExprBinary {
	public Div(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
