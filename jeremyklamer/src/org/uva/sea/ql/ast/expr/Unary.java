package org.uva.sea.ql.ast.expr;

import java.util.List;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.message.Error;
import org.uva.sea.ql.message.Message;

public abstract class Unary extends Expr{

	protected final Expr expr;

	public Unary(Expr expr){
		this.expr = expr;
	}
	
	@Override
	public void checkType(List<Message> errors, Env env) {
		Type type = expr.typeOf(env);
		if(!(type.isCompatibleTo(this.typeOf(env)))) {
			errors.add(new Error(type.getClass().getSimpleName() + " is not compatible. In " + getSimpleName(this)));
		}			
	}
	
}
