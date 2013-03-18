package org.uva.sea.ql.parser.antlr.error;

public class ParseError extends ANTLRError {
	public ParseError(String error){
		super(error);
	}
	
	@Override
	public String toString() {
		return "ParseError : " + super.toString();
	}
}