package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.type.Type;

public abstract class Unary extends Expr{

	private final Expr expr;

	public Unary(Expr expr){
		this.expr = expr;
	}
	
	public Expr getExpr() {
		return expr;
	}
	
	@Override
	public List<Error> checkType(Map<Ident, Type> typeEnv) {
		ArrayList<Error> errors = new ArrayList<Error>();
		Type type = expr.typeOf(typeEnv);
		if(!(permittedTypes.isCompatibleTo(type)))
			errors.add(new Error(type.getClass().getSimpleName() + " is not compatible. In " + getName(this)));
		return errors;			
	}
}
