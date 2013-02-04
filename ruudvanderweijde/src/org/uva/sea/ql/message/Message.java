package org.uva.sea.ql.message;

public abstract class Message {
	private final String message;

	public Message(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
