package org.uva.sea.ql.ast.values;

import java.util.Map;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.ErrorType;
import org.uva.sea.ql.ast.visitor.ICheckExprVisitor;

public class Ident extends Value {
	
	private final String name;
	
	public Ident(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public <T> T accept(ICheckExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		if (typeEnv.containsKey(this)){
			return typeEnv.get(this);
		}
		return new ErrorType();
	}
}
