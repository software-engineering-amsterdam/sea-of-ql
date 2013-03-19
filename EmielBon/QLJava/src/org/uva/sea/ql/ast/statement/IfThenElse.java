package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expression;

/**
 * Represents a block of statements that is only evaluated when the condition is satisfied
 */
public class IfThenElse extends IfThen {

	private final Block elseBody;
	
	public IfThenElse(Expression condition, Block body, Block elseBody) {
		super(condition, body);
		this.elseBody = elseBody;
	}
	
	public Block getElseBody() {
		return elseBody;
	}

	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}