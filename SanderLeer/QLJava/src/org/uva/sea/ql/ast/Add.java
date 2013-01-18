package org.uva.sea.ql.ast;

public class Add extends ExprBinary {
	public Add(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
