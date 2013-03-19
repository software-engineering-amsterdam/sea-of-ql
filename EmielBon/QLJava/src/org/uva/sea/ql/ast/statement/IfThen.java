package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expression;

/**
 * Represents a block of statements that is only evaluated when the condition is satisfied
 */
public class IfThen extends Statement {

	private final Expression condition;
	private final Block body;
	
	public IfThen(Expression condition, Block body) {
		this.condition = condition;
		this.body = body;
	}

	/**
	 * Returns the expression by which the condition is determined
	 * @return The expression in the if() statement
	 */
	public Expression getCondition() {
		return condition;
	}
	
	public Block getBody() {
		return body;
	}

	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}
	
}