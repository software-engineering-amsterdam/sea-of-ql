package org.uva.sea.ql.eval;

import org.uva.sea.ql.ast.INode;

/**
 * Represents an error.
 */
public class Error {
	/**
	 * Holds the error message.
	 */
	private final String message;

	/**
	 * Holds the node at which the error is attached.
	 */
	private final INode node;

	/**
	 * Constructs a new error.
	 *
	 * @param message
	 * @param node
	 */
	public Error( String message, INode node ) {
		this.message = message;
		this.node = node;
	}

	/**
	 * Retrieves the error message.
	 *
	 * @return The error message.
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Retrieves the node attached with the error.
	 *
	 * @return The node.
	 */
	public INode getNode() {
		return this.node;
	}
}
