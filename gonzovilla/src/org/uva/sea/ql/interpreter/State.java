package org.uva.sea.ql.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.values.Value;

public class State {
	
	private final Map<Ident, Value> env;
	private final Map<Ident, Observable> observables;

	public State() {
		this.env = new HashMap<Ident, Value>();
		this.observables = new HashMap<Ident, Observable>();
	}
	
	public void addObserver(Ident x, Observer obs) {
		observables.get(x).addObserver(obs);
	}
	
	public void putObservable(Ident x, Observable obs) {
		observables.put(x, obs);
	}

	public Object getEnv() {
		return this.env;
	}
	
}