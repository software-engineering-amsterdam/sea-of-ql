package org.uva.sea.ql.interpreter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.qlsource.QLWriter;

public class State implements ActionListener {
	
	private final Map<String, Value> env;
	private final Map<String, Observable> observables;

	public State() {
		this.env = new HashMap<String, Value>();
		this.observables = new HashMap<String, Observable>();
	}
	
	public Map<String, Observable> getObservables() {
		return observables;
	}
	
	public void addObserver(String name, Observer obs) {
		observables.get(name).addObserver(obs);
	}
	
	public void putObservable(String name, Observable obs) {
		observables.put(name, obs);
	}

	public Map<String, Value> getEnv() {
		return env;
	}

	public void putValue(String name, Value value) {
		env.put(name, value);
	}

	public void notifyObservers(String name) {
		observables.get(name).notifyObservers();			
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		QLWriter qlWriter = new QLWriter();
		qlWriter.save(env);
	}
	
}