package org.uva.sea.ql.visitor.checkers.error;

public class QLErrorMSg {
	private final String errorMsg;
	
	public QLErrorMSg(String errorMsg){
		this.errorMsg=errorMsg;
	}
	
	public String getError(){
		return errorMsg;
	}

}
