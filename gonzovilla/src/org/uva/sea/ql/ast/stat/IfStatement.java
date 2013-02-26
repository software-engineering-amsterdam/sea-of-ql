package org.uva.sea.ql.ast.stat;


import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.visitor.VisitorStatements;

public class IfStatement extends FormUnit {

	private final Expr condition;
	private final Block body;
	
	public IfStatement(Expr condition, Block body) {
		this.condition = condition;
		this.body = body;
	}

	public Expr getCondition() {
		return condition;
	}

	public Block getBody() {
		return body;
	}

	@Override
	public <T> T accept(VisitorStatements<T> visitor) {
		return visitor.visit(this);
	}
}
