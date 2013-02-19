package org.uva.sea.ql.questionnaire;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Value;

public class State {

	private final Map<Ident, Value> env;
	private final Map<Ident, Observable> observables;

	public State() {
		this.env = new HashMap<Ident, Value>();
		this.observables = new HashMap<Ident, Observable>();
	}

	public void addObserver(Ident ident, Observer obs) {
		this.observables.get(ident).addObserver(obs);
	}

	public void putObservable(Ident ident, Observable obs) {
		this.observables.put(ident, obs);
	}

	public void putValue(Ident ident, Value value) {
		this.env.put(ident, value);
	}

	public void notify(Ident ident) {
		this.observables.get(ident).notifyObservers();
	}

	public Map<Ident, Value> getEnv() {
		return this.env;
	}
}
