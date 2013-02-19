package org.uva.sea.ql.parser;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.types.Error;
import org.uva.sea.ql.ast.expressions.literal.Ident;

public class SupportedTypes {
	private final Map<Ident, Type> _supportedTypes;

	public SupportedTypes() {
		_supportedTypes = new HashMap<Ident, Type>();
	}
	
	public void add(Ident identifier, Type type) {
		_supportedTypes.put(identifier, type);
	}
	
	public Boolean contains(Ident identifier) {
		for (Ident i: _supportedTypes.keySet()) {
			if (identifier.equals(i)) {
				return true;
			}
		}
		return false;
	}
	
	public Type get(Ident identifier) {
		for (Ident i: _supportedTypes.keySet()) {
			if (identifier.equals(i)) {
				return _supportedTypes.get(i);
			}
		}
		return new Error();
	}
}