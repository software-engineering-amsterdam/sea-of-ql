package org.uva.sea.ql.visitor;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.value.Value;

public class ValueMapper {
	private final Map<Ident, Value> identToValue;
	
	public ValueMapper() {
		this.identToValue = new HashMap<Ident, Value>();
	}
	
	public boolean hasValueKey(Ident ident) {
		return identToValue.containsKey(ident);
	}

	public Value getValue(Ident ident) {
		return identToValue.get(ident);
	}

	public void setValue(Ident ident, Value value) {
		identToValue.put(ident, value);
	}
}
