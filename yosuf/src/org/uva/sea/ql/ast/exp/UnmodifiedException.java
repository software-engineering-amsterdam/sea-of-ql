package org.uva.sea.ql.ast.exp;

/**
 * Indicates that the value to a reference is not modifed / known yet.
 */
public class UnmodifiedException extends RuntimeException {

	private static final long serialVersionUID = -7226851035650176522L;
	private final String message;

	public UnmodifiedException(final String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}