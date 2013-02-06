package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.StatementVisitor;

/**
 * Represents an ElseIf block.
 */
public class ElseIf extends Statement {
	/**
	 * Holds the condition of the ELSE-IF.
	 */
	private final Expression condition;

	/**
	 * Holds the body of the ELSE-IF.
	 */
	private final Statements body;

	/**
	 * Constructs a new ElseIf node.
	 *
	 * @param condition
	 * @param body
	 */
	public ElseIf( Expression condition, Statements body ) {
		this.condition = condition;
		this.body = body;
	}

	/**
	 * Retrieves the condition of the ELSE-IF.
	 *
	 * @return The condition expression.
	 */
	public Expression getCondition() {
		return this.condition;
	}

	/**
	 * Accept a statement visitor.
	 *
	 * @param visitor
	 */
	@Override
	public <T> T accept( StatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}

	/**
	 * Retrieves the body of the ELSE-IF.
	 *
	 * @return The body statements.
	 */
	public Statements getBody() {
		return this.body;
	}
}
