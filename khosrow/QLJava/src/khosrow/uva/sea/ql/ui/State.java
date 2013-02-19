package khosrow.uva.sea.ql.ui;

import java.util.Hashtable;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.values.Value;

public class State {
	private final Env env;
	private final Map<Ident, Observable> observables;
	
	public State(Env env){
		this.env = env;
		this.observables = new Hashtable<Ident, Observable>();
	}

	public Map<Ident, Observable> getObservables() {
		return observables;
	}
	
	public void putObservable(Ident name, Observable obs) {
		observables.put(name, obs);
	}
	
	public void addObserver(Ident name, Observer obs) {
		observables.get(name).addObserver(obs);
	}
	
	public void notifyObervers(Ident name) {
		observables.get(name).notifyObservers();
	}
	
	public void putValue(Ident name, Value value) {
		env.assignValue(name, value);
	}

	public Env getEnv() {
		return env;
	}
}
