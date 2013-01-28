package org.uva.sea.ql.checker.errors;

public abstract class FormCheckerError extends Exception{
	private static final long serialVersionUID = 0L;
	
	public FormCheckerError(){
		super();
	}
	
	public FormCheckerError(String msg){
		super(msg);
	}
}
