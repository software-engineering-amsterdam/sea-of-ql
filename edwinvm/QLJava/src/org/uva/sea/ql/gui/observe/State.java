package org.uva.sea.ql.gui.observe;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.check.TypeEnvironment;
import org.uva.sea.ql.check.ValueEnvironment;

public class State {

	private final TypeEnvironment _typeEnvironment;
	private final ValueEnvironment _valueEnvironment;
	private final ObservableEnvironment _observableEnvironment;

	public State(TypeEnvironment typeEnvironment) {
		_typeEnvironment = typeEnvironment;
		_valueEnvironment = new ValueEnvironment();
		_observableEnvironment = new ObservableEnvironment();
	}

	public void addObserver(Identifier identifier, Observer observer) {
		getObservable(identifier).addObserver(observer);
	}
	
	private Observable getObservable(Identifier identifier) {
		return _observableEnvironment.get(identifier);
	}
	
	public TypeEnvironment getTypeEnvironment() { return _typeEnvironment; }

	public ValueEnvironment getValueEnvironment() { return _valueEnvironment; }

	public Map<Identifier, Observable> getObservableEnvironment() { return _observableEnvironment.getEnvironment(); }
	
	public void putValue(Identifier variable, Value value) { _valueEnvironment.add(variable, value); }
	
	public void putObservable(Identifier identifier, Observable observable) { _observableEnvironment.add(identifier, observable); }

	public void notify(Identifier identifier) {
		getObservable(identifier).notifyObservers();
	}

}