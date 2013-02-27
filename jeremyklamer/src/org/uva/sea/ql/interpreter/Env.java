package org.uva.sea.ql.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.type.Type;

public class Env {

	private final Map<Ident, Type> typeEnv;
	private final Map<Ident, Value> valueEnv;
	private final Map<Ident, Observable> observableEnv;

	public Env() {
		this.typeEnv = new HashMap<Ident, Type>();
		this.valueEnv = new HashMap<Ident, Value>();
		this.observableEnv = new HashMap<Ident, Observable>();
	}
	
	public Env(Map<Ident, Type> typeEnv, Map<Ident, Value> valueEnv, Map<Ident, Observable> observableEnv){
		this.typeEnv = typeEnv;
		this.valueEnv = valueEnv;
		this.observableEnv = observableEnv;
	}

	public Map<Ident, Type> getTypeEnv() {
		return typeEnv;
	}
	
	public boolean containsType(Ident name){
		return typeEnv.containsKey(name);
	}
	
	public void putType(Ident name, Type type){
		typeEnv.put(name, type);
	}
	
	public Type getType(Ident name){
		return typeEnv.get(name);
	}

	public Map<Ident, Value> getValueEnv() {
		return valueEnv;
	}
	
	public boolean containsValue(Ident name){
		if(valueEnv.containsKey(name)){
			return true;
		}
		return false; 
	}
	
	public void putValue(Ident name, Value value){
		valueEnv.put(name, value);
	}
	
	public Value getValue(Ident name){
		return valueEnv.get(name);
	}
	
	public void registerObservable(Ident name, Observable observable) {
		observableEnv.put(name, observable);
	}
	
	private void registerObserver(Ident name, Observer observer) {
		observableEnv.get(name).addObserver(observer);
	}
	
	public void registerObserver(Observer observer) {
		for(Entry<Ident,Observable> observable: observableEnv.entrySet()) {
			registerObserver(observable.getKey(), observer);
		}
	}
	
	public void notify(Ident name) {
		observableEnv.get(name).notifyObservers();
	}
	
}
