package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.INode;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents If-Then statement.
 */
public class Else implements INode {
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
	 * Retrieves the body.
	 *
	 * @return The body of the ELSE.
	 */
	public Statements getBody() {
		return this.body;
	}

	@Override
	public <T> T accept( NodeVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
