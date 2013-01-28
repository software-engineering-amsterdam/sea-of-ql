package org.uva.sea.ql.type;

public class TypeCheckError extends Exception {
	private static final long serialVersionUID = 1L;
	public TypeCheckError(String msg) {
		super(msg);
	}
}
