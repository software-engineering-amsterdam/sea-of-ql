package org.uva.sea.ql.gui;

import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.form.ObservableStatement;
import org.uva.sea.ql.visitor.Value;

public class State {
	private final Map<Ident, Value> env;
	private final Map<Ident, ObservableStatement> observables;

	public State() {
		this.env = new HashMap<Ident, Value>();
		this.observables = new HashMap<Ident, ObservableStatement>();
	}

	public void addObserver(Ident x, Observer obs) {
		observables.get(x).addObserver(obs);
	}

	public void putObservable(Ident x, ObservableStatement obs) {
		observables.put(x, obs);
	}

	public void notify(Ident ident) {
		ObservableStatement obs = observables.get(ident);
		if (obs != null) {
			obs.notifyObs();
		}
	}

	public void notifyall() {
		observables.notifyAll();
	}

	public void addEnv(Ident x, Value value) {
		env.put(x, value);
		notify(x);
	}

	public Map<Ident, Value> getEnv() {
		return env;
	}
}
