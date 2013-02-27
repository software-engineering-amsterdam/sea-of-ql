package eu.karuza.ql;

public class QLFrontEndException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7178316213318020896L;
	
	private String message;
	
	public QLFrontEndException(Exception e) {
		this.message = e.getLocalizedMessage();
		setStackTrace(e.getStackTrace());
	}
	
	public QLFrontEndException() {
		
	}
	
	public QLFrontEndException(String message) {
		this.message = message;
	}
	
	@Override
	public String getLocalizedMessage() {
		if(message != null && !message.equals("")) {
			return message;
		} else {
			return super.getLocalizedMessage();
		}
	}

}
