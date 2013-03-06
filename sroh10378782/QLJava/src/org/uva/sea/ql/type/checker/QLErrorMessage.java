package org.uva.sea.ql.type.checker;

public class QLErrorMessage {
	private final String error;
	public QLErrorMessage(String error){
		this.error = "Type Error : " + error;
	}
	public QLErrorMessage(String error, int lineNumber){
		this.error = "Line : " + lineNumber + " : " + "Error : " + error;
	}
	public String getError(){
		return this.error;
	}
}
