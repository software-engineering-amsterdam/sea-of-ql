package org.uva.sea.ql.check;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.values.Value;

public class ValueEnvironment {
	private final Map<Identifier, Value> _valueEnvironment;

	public ValueEnvironment() {
		_valueEnvironment = new HashMap<Identifier, Value>();
	}
	
	public void add(Identifier identifier, Value value) {
		_valueEnvironment.put(identifier, value);
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
	
	public Set<Entry<Identifier, Value>> getValueEntries() {
		return _valueEnvironment.entrySet();
	}
}