package org.uva.sea.ql.parser.error;

public class SemanticError extends Exception {
	private static final long serialVersionUID = 1L;

	public SemanticError(String msg) {
		//super(msg);
		System.out.println("Semantic error: " + msg);
	}
}
