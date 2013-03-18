package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefType;


public class Identifier extends Expression {

	private final String name;

	public Identifier(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public <T> T accept(final ExpressionVisitor<T> v){
		return v.visit(this);
	}
	
	@Override
	public Type typeOf(final Map<Identifier, Type> typeEnv) {
		final Type type = typeEnv.get(this);
		if(type != null){
			return type;
		}
		return new UndefType();
	}

	@Override
	public String toString() {
		return "Identifier [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Identifier other = (Identifier) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
