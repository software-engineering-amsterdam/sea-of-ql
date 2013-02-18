package org.uva.sea.ql.ast.traversal.codegeneration.base;

public class WebGenerationException extends Exception {
	private static final long serialVersionUID = 1L;

	public WebGenerationException(final Throwable exception) {
		super("Web Generation Exception", exception);
	}
}
