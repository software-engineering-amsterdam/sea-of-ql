package org.uva.sea.ql.parser;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.literal.Identifier;
import org.uva.sea.ql.ast.values.Value;

public class ValueEnvironment {
	private final Map<Identifier, Value> _valueEnvironment;

	public ValueEnvironment() {
		_valueEnvironment = new HashMap<Identifier, Value>();
	}
	
	public void add(Identifier identifier, Value value) {
		if (!contains(identifier)) {
			_valueEnvironment.put(identifier, value);
		}
	}
	
	public Boolean contains(Identifier identifier) {
		return _valueEnvironment.containsKey(identifier);
	}
	
	public Value get(Identifier identifier) {
		return _valueEnvironment.get(identifier);
	}
	
	public Map<Identifier, Value> getEnvironment() {
		return _valueEnvironment;
	}
}