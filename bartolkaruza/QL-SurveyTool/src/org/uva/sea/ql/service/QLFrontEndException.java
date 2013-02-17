package org.uva.sea.ql.service;

public class QLFrontEndException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7178316213318020896L;
	
	private String message;
	
	public QLFrontEndException() {
		
	}
	
	public QLFrontEndException(String message) {
		this.message = message;
	}
	
	@Override
	public String getLocalizedMessage() {
		if(message != null || !message.equals("")) {
			return message;
		} else {
			return super.getLocalizedMessage();
		}
	}

}
