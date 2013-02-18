package org.uva.sea.ql.base;

public class BrowserException extends Exception {
	private static final long serialVersionUID = 1L;

	public BrowserException(final Throwable exception) {
		super("Browser Exception", exception);
	}
}
