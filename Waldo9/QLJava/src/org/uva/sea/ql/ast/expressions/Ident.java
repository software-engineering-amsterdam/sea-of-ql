package org.uva.sea.ql.ast.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.types.ErrorType;
import org.uva.sea.ql.ast.types.Type;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
    }
	
	@Override
	public Type typeOf(Map<String, Type> typeEnvironment) {
		if (typeEnvironment.containsKey(name)) {
			return typeEnvironment.get(name);
			}
		return new ErrorType();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ident) {
			Ident otherIdent = (Ident) obj;
			return otherIdent.getName().equals(name);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}

}
