package org.uva.sea.ql.renderer;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.evaluator.values.Value;

public class State {
	
	private final Map<Ident, Value> environment;
	private final Map<Ident, Observable> observables;
	
	public State() {
		this.environment = new HashMap<Ident, Value>();
		this.observables = new HashMap<Ident, Observable>();
	}
	
	public void addObserver(Ident id, Observer obs) {
		observables.get(id).addObserver(obs);
	}
	
	public void putObservable(Ident id, Observable obs) {
		observables.put(id, obs);
	}

	public Map<Ident, Value> getEnvironment() {
		return environment;
	}
	
	public Map<Ident, Observable> getObservables() {
		return observables;
	}

	public void putValue(Ident identifier, Value val) {
		environment.put(identifier,  val);
		
	}

	public void notify(Ident identifier) {
		observables.get(identifier).notifyObservers();
	}
	
	public void printEnvironment() {
			System.out.println(environment.entrySet().toString());
	}


}
