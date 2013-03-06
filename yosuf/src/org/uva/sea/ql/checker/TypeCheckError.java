package org.uva.sea.ql.checker;

public class TypeCheckError {

	private final String message;

	public TypeCheckError(final String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
