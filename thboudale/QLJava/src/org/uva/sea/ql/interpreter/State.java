package org.uva.sea.ql.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import org.uva.sea.ql.evaluator.values.AValue;
import org.uva.sea.ql.ast.expressions.Ident;

public class State {
	public final Map<Ident, AValue> valEnv;
	private final Map<Ident, Observable> observables;
	
	public State() {
		this.valEnv = new HashMap<Ident, AValue>();
		this.observables = new HashMap<Ident, Observable>();
	}
	
	public void addObserver(Ident ident, Observer obs) {
		observables.get(ident).addObserver(obs);
	}
	
	public void putObservable(Ident ident, Observable obs) {
		observables.put(ident, obs);
	}
	
	public void putValue(Ident ident, AValue value) {
		valEnv.put(ident, value);	
	}
	
	public void notify(Ident ident) {
		observables.get(ident).notifyObservers();
	}
	
	public Map<Ident, AValue> getEnv() {
		return valEnv;
	}
	
	public Map<Ident, Observable> getObservables() {
		return observables;
	}
}