package org.uva.sea.ql.ast;

import org.uva.sea.ql.astvisitor.ASTNodeVisitor;

public class ConditionalStatement extends Statement {

	private final Expr expression;
	private final Statement compound;

	public ConditionalStatement(Expr ex, Statement c) {
		expression = ex;
		compound = c;
	}

	public Expr getExpression() {
		return expression;
	}

	public Statement getCompound() {
		return compound;
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
