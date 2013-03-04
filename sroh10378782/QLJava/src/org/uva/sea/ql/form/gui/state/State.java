package org.uva.sea.ql.form.gui.state;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.nodes.expressions.*;
import org.uva.sea.ql.values.*;

public class State {
	private final Map<Ident, Value> valueEnvironment;
	private final Map<Ident, Observable> observablesEnvironment;
	
	public State() {
		this.valueEnvironment = new HashMap<Ident, Value>();
		this.observablesEnvironment= new HashMap<Ident, Observable>();
	}
	
	public void addObserver(Ident ident, Observer observer) {
		Observable obs = this.observablesEnvironment.get(ident);
		if(obs != null){
			obs.addObserver(observer);
		}
	}
	
	public void putObservable(Ident ident, Observable observable) {
		this.observablesEnvironment.put(ident, observable);
	}
	
	public void putValue(Ident ident, Value value) {
		this.valueEnvironment.put(ident, value);
	}
	
	public Map<Ident, Value> getValueEnv(){
		return this.valueEnvironment;
	}
	
	public void notify(Ident ident){
		if(this.observablesEnvironment.containsKey(ident)){
			this.observablesEnvironment.get(ident).notifyObservers();
		}
	}
}