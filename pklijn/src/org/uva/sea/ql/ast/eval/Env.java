package org.uva.sea.ql.ast.eval;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.NotDefinedType;
import org.uva.sea.ql.ast.types.Type;

public class Env {
	
	private final Env parent;
	private Map<Ident, Type> types;
	
	public Env() {
		this(null);
	}
	
	public Env(Env parent) {
		this.parent = parent;
		types = new HashMap<Ident, Type>();
	}
	
	public Env getParent() {
		return parent;
	}
	
	public Type typeOf(Ident ident) {
		if (types.containsKey(ident))
			return types.get(ident);
		else if (parent != null)
			return parent.typeOf(ident);
		else 
			return new NotDefinedType();
	}
	
	public boolean hasIdent(Ident ident) {
		if (types.containsKey(ident))
			return true;
		else if (parent != null)
			return parent.hasIdent(ident);
		return false;
	}
	
	public void addIdent(Ident ident, Type type) {
		types.put(ident, type);
	}
}
