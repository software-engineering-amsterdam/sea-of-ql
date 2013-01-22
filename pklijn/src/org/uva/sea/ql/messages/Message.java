package org.uva.sea.ql.messages;

public abstract class Message {

	private final String text;
	
	public Message(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
}
