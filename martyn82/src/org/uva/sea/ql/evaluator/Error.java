package org.uva.sea.ql.evaluator;

import org.uva.sea.ql.ast.Node;

/**
 * Represents an error.
 */
abstract public class Error {
	/**
	 * Holds the error message.
	 */
	private final String message;

	/**
	 * Holds the node at which the error is attached.
	 */
	private final Node node;

	/**
	 * Holds the error code.
	 */
	private final int code;

	/**
	 * Constructs a new error.
	 *
	 * @param code
	 * @param message
	 * @param node
	 */
	protected Error( int code, String message, Node node ) {
		this.code = code;
		this.message = message;
		this.node = node;
	}

	/**
	 * Retrieves the error message.
	 *
	 * @return The error message.
	 */
	final public String getMessage() {
		return this.message;
	}

	/**
	 * Retrieves the error code.
	 *
	 * @return The error code;
	 */
	final public int getCode() {
		return this.code;
	}

	/**
	 * Retrieves the node attached with the error.
	 *
	 * @return The node.
	 */
	final public Node getNode() {
		return this.node;
	}

	/**
	 * Converts this object to its string representation.
	 */
	@Override
	abstract public String toString();
}
