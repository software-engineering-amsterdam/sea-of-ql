package org.uva.sea.ql.ast.expressions.unary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.Type;
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
	public List<Message> checkType(Map<Ident, Type> typeEnv) {
		List<Message> errors = new ArrayList<Message>();

		errors.addAll(arg.checkType(typeEnv));
		
		if (!this.allowedTypes.contains(arg.typeOf(typeEnv))) {
			errors.add(new Error("The type of the argument are not allowed in operation " + getName()));
		}
		
		return errors;
	}
}
