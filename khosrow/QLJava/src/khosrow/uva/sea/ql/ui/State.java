package khosrow.uva.sea.ql.ui;

import java.util.Hashtable;
import java.util.Map;
import java.util.Observer;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.values.Value;

public class State {
	private final Env env;
	private final Map<Ident, QlObservable> observables;
	
	public State(Env env){
		this.env = env;
		this.observables = new Hashtable<Ident, QlObservable>();
	}

	public Map<Ident, QlObservable> getObservables() {
		return observables;
	}
	
	public void putObservable(Ident name, QlObservable obs) {
		observables.put(name, obs);
	}
	
	public void addObserver(Ident name, Observer obs) {
		observables.get(name).addObserver(obs);
	}
	
	public void assignValue(Ident name, Value value) {
		env.assignValue(name, value);		
		observables.get(name).notifyChange();
	}

	public Env getEnv() {
		return env;
	}
}
