package org.uva.sea.ql.ast;

import org.uva.sea.ql.astnodevisitor.Visitor;
import org.uva.sea.ql.astnodevisitor.VisitorResult;

public abstract class Expr implements ASTNode {
	private final TypeDescription exprType;

	public Expr(TypeDescription xtype) {
		exprType = xtype;
	}

	@Override
	public VisitorResult accept(Visitor visitor) {
		return visitor.visit(this);
	}

	public TypeDescription getExprType() {
		return exprType;
	}
}
