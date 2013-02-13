package org.uva.sea.ql.checker.errors;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.util.VisitorExprPrint;

public abstract class Error {
	
	private String msg;
	
	public Error(){
	}
	
	public Error(String msg){
		this.msg = msg;
	}
	
	public String getMessage(){
		return msg;
	}
	
	protected static String expressionToString(Expr expr){
		return expr.accept(new VisitorExprPrint());
	}
	
}
