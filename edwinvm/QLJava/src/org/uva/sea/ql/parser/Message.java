package org.uva.sea.ql.parser;

public class Message {
	private final String _errorMessage;

	public Message(String msg) {
		_errorMessage = msg;
	}
	
	public String getErrorMessage() {
		return _errorMessage;
	}
}