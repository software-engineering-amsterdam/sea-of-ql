package org.uva.sea.ql.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import org.uva.sea.ql.eval.Value;
import org.uva.sea.ql.eval.ValueEnvironment;
import org.uva.sea.ql.ast.expression.Identifier;

public class State {

	private final ValueEnvironment env;
	private final Map<Identifier, Observable> observables;
	
	public State() {
		this.env = new ValueEnvironment();
		this.observables = new HashMap<Identifier, Observable>();
	}
	
	public void addObserver(Identifier x, Observer obs) {
		observables.get(x).addObserver(obs);
	}
	
	public void putObservable(Identifier x, Observable obs) {
		observables.put(x, obs);
	}
	
	public ValueEnvironment getEnvironment() {
		return env;
	}
	
	public void putValue(Identifier id, Value value) {
		env.declare(id, value);
	}
	
}
