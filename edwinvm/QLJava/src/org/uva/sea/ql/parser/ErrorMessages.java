package org.uva.sea.ql.parser;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessages {
	private final List<Message> _errorMessages;

	public ErrorMessages() {
		_errorMessages = new ArrayList<Message>();
	}
	
	public void add(String message) {
		_errorMessages.add(new Message(message));
	}
	
	public Boolean hasErrors() {
		return _errorMessages.size() > 0;
	}
}