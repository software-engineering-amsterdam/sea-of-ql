package org.uva.sea.ql.ast.stat;


import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.visitor.VisitorStatements;

public class IfStatement extends FormUnit {

	private final Expr condition;
	private final Block ifBody;
	private final Block elseBody;
	
	public IfStatement(Expr condition, Block ifBody, Block elseBody) {
		this.condition = condition;
		this.ifBody = ifBody;
		this.elseBody = elseBody;
	}

	public Expr getCondition() {
		return condition;
	}

	public Block getIfBody() {
		return ifBody;
	}
	
	public Block getElseBody() {
		return elseBody;
	}

	@Override
	public <T> T accept(VisitorStatements<T> visitor) {
		return visitor.visit(this);
	}

}
