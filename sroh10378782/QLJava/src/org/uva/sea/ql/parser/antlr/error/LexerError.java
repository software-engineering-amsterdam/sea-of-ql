package org.uva.sea.ql.parser.antlr.error;

public class LexerError extends ANTLRError {
	
	public LexerError(String error){
		super(error);
	}
	
	@Override
	public String toString() {
		return "LexerError : " + super.toString();
	}
}
