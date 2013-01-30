package khosrow.uva.sea.ql.eval.env;

import java.util.HashMap;
import java.util.Map;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.type.Type;

public class Env {
	private final Map<Ident, Type> types;
	
	public Env() {
		this.types = new HashMap<Ident, Type>();
	}
	
	public Type LookUp(Ident name) {
		if (types.containsKey(name)) 
			return types.get(name);		
		throw new RuntimeException("undefined variable: " + name);
	}
	
	public void DeclareType(Ident name, Type type) {
		types.put(name, type);
	}
}
