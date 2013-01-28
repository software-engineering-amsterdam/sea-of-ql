package org.uva.sea.ql.ast.expressions.unary;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.messages.Error;
import org.uva.sea.ql.messages.Message;

public abstract class Unary extends Expr {
	private Expr arg;
	
	public Unary(Expr arg) {
		this.arg = arg;
	}
	
	public Expr getArg() {
		return arg;
	}
	
	@Override
	public List<Message> checkType(Env environment) {
		List<Message> errors = new ArrayList<Message>();

		errors.addAll(arg.checkType(environment));
		
		if (!this.allowedTypes.contains(arg.typeOf(environment))) {
			errors.add(new Error("The type of the argument are not allowed in operation " + getName() + 
					" allowed types are: " + getPrintableAllowedTypes() + ". Gotten " + arg.typeOf(environment)));
		}
		
		return errors;
	}
}
