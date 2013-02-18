package org.uva.sea.ql.rendering;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.evaluation.values.Value;

public class State {

	private final Map<Ident, Value> identifierEnvironment;
	private final Map<Ident, Observable> observables;
	
	public State() {
		identifierEnvironment = new HashMap<Ident, Value>();
		observables = new HashMap<Ident, Observable>();
	}

	public Map<Ident, Value> getIdentifierEnvironment() {
		return identifierEnvironment;
	}
	
	public void putValue(Ident identifier, Value value) {
		identifierEnvironment.put(identifier, value);
	}

}
