package khosrow.uva.sea.ql.env;

import java.util.HashMap;
import java.util.Map;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.type.Type;

public class Env {
	private final Map<Ident, Type> types;
	
	public Env() {
		this.types = new HashMap<Ident, Type>();
	}
	
	public boolean Contains(Ident name) {
		if (types.containsKey(name)) 
			return true;		
		return false;
	}
	
	public Type TypeOf(Ident name) {
		return types.get(name);
	}
	
	public void DeclareType(Ident name, Type type) {
		types.put(name, type);
	}
}
