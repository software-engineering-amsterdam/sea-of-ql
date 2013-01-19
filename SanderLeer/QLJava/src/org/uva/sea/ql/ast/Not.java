package org.uva.sea.ql.ast;

public class Not extends ExprUnary {
	public Not(Expr expr) {
		super(expr);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
