package org.uva.sea.ql.evaluator;

import org.uva.sea.ql.ast.Node;

abstract public class Error {
	private final String message;
	private final Node node;
	private final int code;

	protected Error( int code, String message, Node node ) {
		this.code = code;
		this.message = message;
		this.node = node;
	}

	final public String getMessage() {
		return this.message;
	}

	final public int getCode() {
		return this.code;
	}

	final public Node getNode() {
		return this.node;
	}

	@Override
	abstract public String toString();
}
