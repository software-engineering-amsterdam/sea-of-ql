package org.uva.sea.ql.checker;

public abstract class ErrorFormChecker extends Exception{
	private static final long serialVersionUID = 0L;
	
	public ErrorFormChecker(){
		super();
	}
	
	public ErrorFormChecker(String msg){
		super(msg);
	}
}
