package org.uva.sea.ql.ast.error;

import org.uva.sea.ql.ast.expr.Expr;

public class ErrorMessage {

	private final String errorMessage;
	private final Expr expression;
	
	public ErrorMessage(Expr ex,String message){
		this.expression = ex;
		this.errorMessage = message;
	}
	
	@Override
	public String toString() {
		return "Error in:"+this.expression.toString() + " - with given error message: "+ this.errorMessage;
	}
}
