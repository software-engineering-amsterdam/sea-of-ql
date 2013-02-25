package org.uva.sea.ql.parser;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.types.Type;

public class TypeEnvironment {
	private final Map<Identifier, Type> _typeEnvironment;

	public TypeEnvironment() {
		_typeEnvironment = new HashMap<Identifier, Type>();
	}
	
	public void add(Identifier identifier, Type type) {
		if (!contains(identifier)) {
			_typeEnvironment.put(identifier, type);
		}
	}
	
	public Boolean contains(Identifier identifier) {
		return _typeEnvironment.containsKey(identifier);
	}
	
	public Type get(Identifier identifier) {
		return _typeEnvironment.get(identifier);
	}
}