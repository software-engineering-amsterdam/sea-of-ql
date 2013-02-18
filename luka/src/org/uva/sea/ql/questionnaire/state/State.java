package org.uva.sea.ql.questionnaire.state;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Value;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class State {

	@XStreamImplicit(keyFieldName = "question", itemFieldName = "answer")
	private final Map<Ident, Value> env;
	private final Map<Ident, Observable> observables;

	public State() {
		this.env = new HashMap<Ident, Value>();
		this.observables = new HashMap<Ident, Observable>();
	}

	public void addObserver(Ident ident, Observer obs) {
		observables.get(ident).addObserver(obs);
	}

	public void putObservable(Ident ident, Observable obs) {
		observables.put(ident, obs);
	}

	public void putValue(Ident ident, Value value) {
		env.put(ident, value);
	}

	public void notify(Ident ident) {
		this.observables.get(ident).notifyObservers();
	}

	public Map<Ident, Value> getEnv() {
		return this.env;
	}

//	private void printEnv() {
//		System.err.println("----->");
//		for (Ident i : env.keySet()) {
//			System.err.println(i.toString() + " - " + env.get(i).toString());
//		}
//		System.err.println("<-----");
//	}
}
