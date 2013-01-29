package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.message.Error;

public abstract class Unary extends Expr{

	private final Expr expr;

	public Unary(Expr expr){
		this.expr = expr;
	}
	
	public Expr getExpr() {
		return expr;
	}
	
	@Override
	public List<Message> checkType(Map<Ident, Type> typeEnv) {
		ArrayList<Message> errors = new ArrayList<Message>();
		Type type = expr.typeOf(typeEnv);
		if(!(permittedTypes.isCompatibleTo(type)))
			errors.add(new Error(type.getClass().getSimpleName() + " is not compatible. In " + getSimpleName(this)));
		return errors;			
	}
	
}
