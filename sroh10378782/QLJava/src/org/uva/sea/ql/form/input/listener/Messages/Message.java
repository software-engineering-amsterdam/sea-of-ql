package org.uva.sea.ql.form.input.listener.Messages;

public class Message {
	private final String message;
	private final boolean isError;
	public Message(String msg, boolean isError){
		this.message = msg;
		this.isError = isError;
	}
	
	@Override
	public String toString() {
		String prefix = "Success Message: ";
		if(isError){
			prefix = "Error Message: ";
		}
		return prefix + message ;
	}
}
