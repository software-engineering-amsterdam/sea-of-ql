package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;

/**
 * Represents a block of statements that is only evaluated when the condition is satisfied
 */
public class IfBlock extends Statement {

	private final Expression condition;
	private final Statements body;
	
	public IfBlock(Expression expression, Statements body) {
		this.condition = expression;
		this.body = body;
	}

	/**
	 * Returns the expression by which the condition is determined
	 * @return The expression in the if() statement
	 */
	public Expression getCondition() {
		return condition;
	}
	
	public Statements getBody() {
		return body;
	}

	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}