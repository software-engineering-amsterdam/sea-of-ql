package org.uva.sea.ql.visitor;

public class TypeCheckError {

	private final String errorMessage;

	public TypeCheckError(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public String toString() {
		return "TypeCheckError [errorMessage=" + errorMessage + "]";
	}
	
	

}
