package org.uva.sea.ql.typechecker;

import java.util.Map;
import java.util.HashMap;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.ErrorType;

public class TypeEnvironment {

	private final Map<Identifier, Type> environment = new HashMap<Identifier, Type>();
	
	public boolean isDeclared(Identifier id) {
		return environment.containsKey(id);
	}
	
	public void declare(Identifier id, Type type) {
		environment.put(id, type);
	}
	
	public Type getType(Identifier id) {
		return (isDeclared(id)) ? environment.get(id) : new ErrorType();
	}
	
	public String toString() {
		return environment.entrySet().toString();
	}
	
}
