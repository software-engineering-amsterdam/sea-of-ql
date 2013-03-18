package org.uva.sea.ql.parser.antlr.error;

public abstract class ANTLRError {
	protected String error;
	public ANTLRError(String error){
		this.error = error;
	}
	
	@Override
	public String toString(){
		return error;
	}
}
