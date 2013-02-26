package org.uva.sea.ql.ast.gui;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.Value;
import org.uva.sea.ql.ast.values.Ident;

public class State {

	private final Map<String, Value> env;
	private final Map<Ident, Observable> observables;

	public State() {
		this.env = new HashMap<String, Value>();
		this.observables = new HashMap<Ident, Observable>();
	}

	public Map<String, Value> getEnv() {
		return env;
	}

	public Map<Ident, Observable> getObservables() {
		return observables;
	}

	public void addObserver(Ident x, Observer obs) {
		observables.get(x).addObserver(obs);
	}

	public void putObservable(Ident x, Observable obs) {
		observables.put(x, obs);
	}

	public void putValue(String x, Value value) {
		env.put(x, value);
	}

	public void notify(Ident ident) {
		observables.get(ident).notifyObservers();
	}

}
