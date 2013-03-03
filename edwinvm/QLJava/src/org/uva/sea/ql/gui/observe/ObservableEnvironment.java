package org.uva.sea.ql.gui.observe;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import org.uva.sea.ql.ast.expressions.Identifier;

public class ObservableEnvironment {
	private final Map<Identifier, Observable> _observableEnvironment;

	public ObservableEnvironment() {
		_observableEnvironment = new HashMap<Identifier, Observable>();
	}
	
	public void add(Identifier identifier, Observable observable) {
		if (!contains(identifier)) {
			_observableEnvironment.put(identifier, observable);
		}
	}
	
	public Boolean contains(Identifier identifier) {
		return _observableEnvironment.containsKey(identifier);
	}
	
	public Observable get(Identifier identifier) {
		return _observableEnvironment.get(identifier);
	}
	
	public Map<Identifier, Observable> getEnvironment() {
		return _observableEnvironment;
	}
}