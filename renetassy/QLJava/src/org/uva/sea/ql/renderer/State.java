package org.uva.sea.ql.renderer;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.values.Value;

public class State {
	
	private final Map<String, Value> env;
	private final Map<String, Observable> observables;
	
	public State() {
		this.env = new HashMap<String, Value>();
		this.observables = new HashMap<String, Observable>();
	}
	
	public Map<String, Value> getEnv(){
		return env;
	}
	
	public void putValue(String x, Value v) {
		env.put(x, v);
	}

	public void addObserver(String x, Observer obs) {
		observables.get(x).addObserver(obs);
	}
	
	public void putObservable(String x, Observable obs) {
		observables.put(x, obs); 
	}

}
