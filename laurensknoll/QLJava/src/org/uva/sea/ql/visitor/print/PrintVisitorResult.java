package org.uva.sea.ql.visitor.print;

import org.uva.sea.ql.visitor.VisitorResult;

public class PrintVisitorResult implements VisitorResult {

	private boolean valid;
	private String message;

	public PrintVisitorResult(boolean valid) throws IllegalArgumentException {
		this(valid, null);
	}

	public PrintVisitorResult(boolean valid, String message)
			throws IllegalArgumentException {
		if (!valid && message == null) {
			throw new IllegalArgumentException(
					"Message is required when the result is invalid.");
		}

		this.valid = valid;
		this.message = message;
	}

	@Override
	public boolean isValid() {
		return this.valid;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
