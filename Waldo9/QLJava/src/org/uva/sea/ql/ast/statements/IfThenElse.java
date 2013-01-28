package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.expressions.Expr;

public class IfThenElse extends Statement {

	private final Block body;
	private final Block elseBody;
	private final Expr condition;

	public IfThenElse(Expr condition, Block body, Block elseBody) {
		this.body = body;
		this.elseBody = elseBody;
		this.condition = condition;
	}
	
	public Block getBody() {
		return body;
	}
	
	public Block getElseBody() {
		return elseBody;
	}
	
	public Expr getCondition() {
		return condition;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
	
}
