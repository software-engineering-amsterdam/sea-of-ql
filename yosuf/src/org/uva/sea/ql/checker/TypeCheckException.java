package org.uva.sea.ql.checker;

/**
 * Exception with human readable toString().
 * 
 */
public class TypeCheckException extends Exception {

	private static final long serialVersionUID = -9127574781015115149L;
	private final String message;

	public TypeCheckException(final String message, final Exception exception) {
		super(message, exception);
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
