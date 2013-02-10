package org.uva.sea.ql.visitor;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.type.Type;

public class SymbolTable {
	private final Map<Ident, Type> identToType;
	
	public SymbolTable() {
		this.identToType = new HashMap<Ident, Type>();
	}

	public boolean containsKey(Ident ident) {
		return identToType.containsKey(ident);
	}

	public Type getType(Ident ident) {
		return identToType.get(ident);
	}

	public void setType(Ident ident, Type type) {
		identToType.put(ident, type);
	}
}
