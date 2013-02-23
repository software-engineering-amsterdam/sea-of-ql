package org.uva.sea.ql.parser.errors;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessages {
	private final List<Message> _errorMessages;

	public ErrorMessages() {
		_errorMessages = new ArrayList<Message>();
	}
	
	public void add(Message message) {
		_errorMessages.add(message);
	}
	
	public Boolean hasErrors() {
		return _errorMessages.size() > 0;
	}
}