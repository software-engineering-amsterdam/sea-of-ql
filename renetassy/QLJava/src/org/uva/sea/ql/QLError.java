package org.uva.sea.ql;

public class QLError {
	
	private String msg;
	
	public QLError (String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
	
}
