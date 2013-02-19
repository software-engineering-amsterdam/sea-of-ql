package org.uva.sea.ql.parser;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.literal.Ident;

public class TypeEnvironment {
	private final Map<Ident, Type> _typeEnvironment;

	public TypeEnvironment() {
		_typeEnvironment = new HashMap<Ident, Type>();
	}
	
	public void add(Ident identifier, Type type) {
		_typeEnvironment.put(identifier, type);
	}
	
	public Boolean contains(Ident identifier) {
		return _typeEnvironment.containsKey(identifier);
	}
	
	public Type get(Ident identifier) {
		return _typeEnvironment.get(identifier);
	}
}