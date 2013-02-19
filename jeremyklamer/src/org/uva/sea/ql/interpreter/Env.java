package org.uva.sea.ql.interpreter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.type.Type;

public class Env {

	private final Map<Ident, Type> typeEnv;
	private final Map<Ident, Value> valueEnv;
	private final Map<Observable, List<Observer>> observableEnv;

	public Env() {
		this.typeEnv = new HashMap<Ident, Type>();
		this.valueEnv = new HashMap<Ident, Value>();
		this.observableEnv = new HashMap<Observable, List<Observer>>();
	}
	
	public Env(Map<Ident, Type> typeEnv, Map<Ident, Value> valueEnv,HashMap<Observable, List<Observer>> observableEnv){
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
		//observables.get(name).notifyObservers();
	}
	
	public Value getValue(Ident name){
		return valueEnv.get(name);
	}
	
	public void registerObserver() {
		
	}
	
	public void registerObservable() {
		
	}
	
	
	
}
