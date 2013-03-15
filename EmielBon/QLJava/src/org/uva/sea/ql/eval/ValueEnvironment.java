package org.uva.sea.ql.eval;

import java.util.Map;
import java.util.HashMap;
import org.uva.sea.ql.ast.expression.Identifier;

public class ValueEnvironment {

	private final Map<Identifier, Value> environment = new HashMap<Identifier, Value>();
	
	public boolean isDeclared(Identifier id) {
		return environment.containsKey(id);
	}
	
	public void setValue(Identifier id, Value value) {
		environment.put(id, value);
	}
	
	public Value getValue(Identifier id) {
		return (isDeclared(id)) ? environment.get(id) : Undefined.UNDEF;
	}
	
	public String toString() {
		return environment.entrySet().toString();
	}

}
