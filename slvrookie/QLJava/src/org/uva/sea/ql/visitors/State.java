package org.uva.sea.ql.visitors;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expr.value.Value;

public class State {
	
	private final Map<String, Value> env;
	private final Map<String, Observable> observables;
	
	public State() {
		this.env = new HashMap<String, Value>();
		this.observables = new HashMap<String, Observable>();
	}
	
	public Map<String, Value> getEnv() {
		return env;
	}
	
	public boolean isDeclared(String name) {
		return env.containsKey(name);
	}
	
	public void setValue(String name, Value val) {
		env.put(name, val);
	}
	
	public void addObserver(String x, Observer obs) {
		observables.get(x).addObserver(obs);
	}
	
	public void putObservable(String x, Observable obs) {
		observables.put(x, obs);
	}

	public void notify(String name) {
		// TODO Auto-generated method stub
		
	}

}
