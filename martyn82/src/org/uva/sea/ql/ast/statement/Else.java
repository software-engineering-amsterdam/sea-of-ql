package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.visitor.IStatementVisitor;

/**
 * Represents If-Then statement.
 */
public class Else extends Statement {
	/**
	 * Holds the body.
	 */
	private final Statements body;

	/**
	 * Constructs a new ELSE body.
	 *
	 * @param body
	 */
	public Else( Statements body ) {
		this.body = body;
	}

	/**
	 * Accept a statement visitor.
	 *
	 * @param visitor
	 */
	@Override
	public <T> T accept( IStatementVisitor<T> visitor ) {
		return visitor.visit( this );
	}

	/**
	 * Retrieves the body.
	 *
	 * @return The body of the ELSE.
	 */
	public Statements getBody() {
		return this.body;
	}
}
