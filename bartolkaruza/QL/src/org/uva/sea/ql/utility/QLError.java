package org.uva.sea.ql.utility;

public class QLError {

	private String cause;

	public QLError(String cause) {
		this.cause = cause;
	}

	public String getCause() {
		return cause;
	}
}
