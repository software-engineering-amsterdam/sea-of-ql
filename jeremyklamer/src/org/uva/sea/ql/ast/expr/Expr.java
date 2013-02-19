package org.uva.sea.ql.ast.expr;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.message.Message;

public abstract class Expr implements ASTNode {
		
	protected static String getSimpleName(Object e) { 
		return e.getClass().getSimpleName();
	}

	public abstract Value eval(Env env);
	
	public abstract Type typeOf(Env env);
	
	public void checkType(List<Message> errors, Env env) {
		
	}
	
	public List<Message> getTypeErrors(Env env) {
		ArrayList<Message> errors = new ArrayList<Message>();
		checkType(errors, env);
		return errors; 
	}
	
}
