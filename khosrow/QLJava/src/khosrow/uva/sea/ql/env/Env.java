package khosrow.uva.sea.ql.env;

import java.util.HashMap;
import java.util.Map;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.values.IValue;

public class Env {
	private final Map<Ident, Type> types;
	private final Map<Ident, IValue> bindings;
	
	public Env() {
		this.types = new HashMap<Ident, Type>();
		this.bindings = new HashMap<Ident, IValue>();
	}
	
	public boolean lookUpType(Ident name) {
		if (types.containsKey(name)) 
			return true;		
		return false;
	}
	
	public boolean lookUpValue(Ident name) {
		if (bindings.containsKey(name)) 
			return true;		
		return false;
	}
	
	public Type typeOf(Ident name) {
		return types.get(name);
	}
	
	public IValue valueOf(Ident name) {
		return bindings.get(name);
	}
	
	public void declareType(Ident name, Type type) {
		types.put(name, type);
	}
		
	public void declareValue(Ident name, IValue value) {
		bindings.put(name, value);
	}
}
