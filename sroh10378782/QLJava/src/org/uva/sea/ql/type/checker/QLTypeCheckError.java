package org.uva.sea.ql.type.checker;

public class QLTypeCheckError {
	
	private final String error;
	public QLTypeCheckError(String error){
		this.error = "Error : " + error;
	}
	
	public QLTypeCheckError(String error, int lineNumber){
		this.error = "Line : " + lineNumber + " : " + "Error : " + error;
	}
	
	public String getError(){
		return this.error;
	}
}
