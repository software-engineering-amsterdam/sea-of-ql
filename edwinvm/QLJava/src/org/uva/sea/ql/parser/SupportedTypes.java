package org.uva.sea.ql.parser;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.literal.Ident;

public class SupportedTypes {
	private final Map<Ident, Type> _supportedTypes;

	public SupportedTypes() {
		_supportedTypes = new HashMap<Ident, Type>();
	}
	
	public Boolean contains(Ident identifier) {
		return _supportedTypes.containsKey(identifier);
	}
	
	public void add(String identifier, Type type) {
		_supportedTypes.put(new Ident(identifier), type);
	}
	
	public Type get(Ident identifier) {
		return _supportedTypes.get(identifier);
	}
}