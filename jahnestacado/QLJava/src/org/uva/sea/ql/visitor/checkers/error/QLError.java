package org.uva.sea.ql.visitor.checkers.error;

public class QLError {
	private final String errorMsg;
	
	public QLError(String errorMsg){
		this.errorMsg=errorMsg;
	}
	
	public String getError(){
		return errorMsg;
	}

}
