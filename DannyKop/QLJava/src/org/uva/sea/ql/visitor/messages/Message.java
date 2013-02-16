package org.uva.sea.ql.visitor.messages;
/**
 * Class: Message
 * @author Danny
 *
 */
public abstract class Message {
	
	// The actual message
	private String message;
	
	/**
	 * Constructor
	 * @param msg - the actual message
	 */
	public Message(String msg) {
		this.message = msg;
	}
	/**
	 * getMessage()
	 * @return message
	 */
	public String getMessage(){
		return this.message;
	}

}
