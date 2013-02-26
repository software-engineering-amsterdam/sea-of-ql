package org.uva.sea.ql.gui.misc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.parser.evaluator.result.Value;

public class ValueState {
	private final Map<Ident, Value> symbolTable;
	private final Map<Ident, Observable> observables;

	public ValueState() {
		symbolTable = new HashMap<>();
		observables = new HashMap<>();
	}

	public void addObserver(Ident ident, Observer observer) {
		observables.get(ident).addObserver(observer);
	}

	public void addObserverToAll(Observer observer) {
		for (Entry<Ident, Observable> observable : observables.entrySet()) {
			observable.getValue().addObserver(observer);
		}
	}

	public void putObservable(Ident ident, Observable observable) {
		observables.put(ident, observable);
	}

	public Map<Ident, Value> getSymbolTable() {
		return Collections.unmodifiableMap(symbolTable);
	}

	public void putValue(Ident ident, Value value) {
		symbolTable.put(ident, value);
	}

}
