package org.uva.sea.ql.gui;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.parser.evaluator.result.Value;

public class State {
	private final Map<Ident, Value> symbolTable;
	private final Map<Ident, Observable> observables;
	
	public State() {
		symbolTable = new HashMap<>();
		observables = new HashMap<>();
	}
	
	public void addObserver(Ident ident, Observer observer) {
		observables.get(ident).addObserver(observer);
	}
	
	public void putObservable(Ident ident, Observable observable) {
	     observables.put(ident,  observable);
	}
	
	public Map<Ident, Value> getSymbolTable() {
		return new HashMap<>(symbolTable);
	}
	
	public void putValue(Ident ident, Value value) {
		symbolTable.put(ident, value);
	}
	
	public Value getValue(Ident ident) {
		return symbolTable.get(ident);
	}
	
	public void notify(Ident ident) {
		observables.get(ident).notifyObservers();
	}
}
