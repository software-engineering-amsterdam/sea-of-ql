package org.uva.sea.ql.ast.eval;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.Type;
//import org.uva.sea.ql.ast.values.Value;

public class Env {
	
	private final Env parent;
	private Map<Ident, Type> types;
//	private Map<Ident, Value> values; //TODO: add values here!
	
	public Env() {
		this(null);
	}
	
	public Env(Env parent) {
		this.parent = parent;
		types = new HashMap<Ident, Type>();
//		values = new HashMap<Ident, Value>();
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
			return null;
	}
	
	public void addIdent(Ident ident, Type type) {
		if (!types.containsKey(ident)) {
			types.put(ident, type);
		}
		else if (types.containsKey(ident)) {
			if (types.get(ident) != type) {
				throw new RuntimeException("Ident " + ident.getName() + " already exists but has different type");
			}
		}
	}
}
