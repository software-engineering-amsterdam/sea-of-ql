package org.uva.sea.ql.ast.expr;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.message.Error;

public abstract class Unary extends Expr{

	protected final Expr expr;

	public Unary(Expr expr){
		this.expr = expr;
	}
	
	@Override
	public List<Message> checkType(Env env) {
		ArrayList<Message> errors = new ArrayList<Message>();
		Type type = expr.typeOf(env);
		if(!(type.isCompatibleTo(type)))
			errors.add(new Error(type.getClass().getSimpleName() + " is not compatible. In " + getSimpleName(this)));
		return errors;			
	}
	
}
