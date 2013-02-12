package org.uva.sea.ql.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.primitive.Undefined;

public class Environment {

	private Environment parentEnvironment;
	private Map<Ident, Expr> map;
	private Map<Ident, Observable> observables;
	
	public Environment(){
		init(null);
	}
	
	
	public Environment(Environment parentEnvironment){
		init(parentEnvironment);
	}
	
	
	private void init(Environment parentEnvironment){
		this.map = new HashMap<Ident, Expr>();
		this.observables = new HashMap<Ident, Observable>();
		this.parentEnvironment = parentEnvironment;
	}
	
	
	private boolean parentContains(Ident key){
		return parentEnvironment != null && parentEnvironment.contains(key);
	}
	
	
	private boolean thisContains(Ident key){
		return map.containsKey(key);
	}
	
	
	public boolean contains(Ident key){
		return thisContains(key) || parentContains(key);
	}
	
	
	public Expr getValue(Ident key){
		
		if(thisContains(key)){
			return map.get(key);
		}
		if(parentEnvironment != null){
			return parentEnvironment.getValue(key);
		}
		return new Undefined();
	}
	
	
	public boolean hasType(Ident key, Class<?> type){
		return type.isInstance(getValue(key));
	}
	
	
	public Environment branchEnvironment(){
		return new Environment(this);
	}
	
	
	public void putValue(Ident key, Expr value){
		
		if(parentContains(key)){
			//this key is already present in the parent environment,
			//so update the value there
			parentEnvironment.putValue(key, value);
		}else{
			//otherwise it's a new key, add it to this environment
			map.put(key, value);
		}
	}

	
	public void putObservable(Ident key, Observable observable){
		observables.put(key, observable);
	}
	
	
	public void addObserver(Ident key, Observer observer){
		observables.get(key).addObserver(observer);
	}
	
	
	public void notify(Ident key){
		observables.get(key).notifyObservers();
	}
}
