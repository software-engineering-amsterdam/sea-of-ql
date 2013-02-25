package org.uva.sea.ql.parser.errors;

public class Message {
	private final String _errorMessage;

	public Message(String message) {
		_errorMessage = message;
	}
	
	public String getErrorMessage() {
		return _errorMessage;
	}
}