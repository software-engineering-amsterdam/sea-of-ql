package org.uva.sea.ql.ast.eval;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.NotDefinedType;
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
			return new NotDefinedType();
	}
	
	// TODO: Met Tijs overleggen over betere aanpak!
	public EnvAddIdentResults addIdent(Ident ident, Type type) {
		Type typeOfExistingIdent = typeOf(ident);
		if (typeOfExistingIdent instanceof NotDefinedType) {
			types.put(ident, type);
			return EnvAddIdentResults.NEW_ADDED;
		}
		else if (!(typeOfExistingIdent.equals(type))) {
			return EnvAddIdentResults.DIFFERENT_TYPE_FOUND;
		}
		else {
			return EnvAddIdentResults.SAME_TYPE_FOUND;
		}
	}
}
