package org.uva.sea.ql.visitor;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;

public class SymbolTable {
	private final Map<Ident, Type> identToType;
	private final Map<Ident, Value> identToValue;
	
	public SymbolTable() {
		this.identToType = new HashMap<Ident, Type>();
		this.identToValue = new HashMap<Ident, Value>();
	}

	public boolean hasTypeKey(Ident ident) {
		return identToType.containsKey(ident);
	}

	public Type getType(Ident ident) {
		return identToType.get(ident);
	}

	public void setType(Ident ident, Type type) {
		identToType.put(ident, type);
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
