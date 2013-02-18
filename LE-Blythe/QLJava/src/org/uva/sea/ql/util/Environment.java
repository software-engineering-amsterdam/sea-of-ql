package org.uva.sea.ql.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.primitive.Undefined;

public class Environment {

	private Environment parentEnvironment;
	private Map<Ident, Expr> valueMap;
	private Map<Ident, Observable> observables;
	
	private List<Environment> branchedEnvironments;
	
	public Environment(){
		init(null);
	}
	
	
	public Environment(Environment parentEnvironment){
		init(parentEnvironment);
	}
	
	
	private void init(Environment parentEnvironment){
		this.valueMap = new HashMap<Ident, Expr>();
		this.observables = new HashMap<Ident, Observable>();
		this.parentEnvironment = parentEnvironment;
		this.branchedEnvironments = new ArrayList<Environment>();
	}
	
	
	private boolean thisValueMapContains(Ident key){
		return valueMap.containsKey(key);
	}
	
	
	private boolean thisObservablesContains(Ident key){
		return observables.containsKey(key);
	}
	
	
	private boolean parentValueMapContains(Ident key){
		return parentEnvironment != null && parentEnvironment.containsValue(key);
	}
	
	
	private boolean parentObservablesContains(Ident key){
		return parentEnvironment != null && parentEnvironment.containsObservable(key);
	}

	
	public boolean containsValue(Ident key){
		return thisValueMapContains(key) || parentValueMapContains(key);
	}
	
	
	public boolean containsObservable(Ident key){
		return thisObservablesContains(key) || parentObservablesContains(key);
	}
	
	
	public Expr getValue(Ident key){
		
		if(thisValueMapContains(key)){
			return valueMap.get(key);
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
		
		Environment childEnv = new Environment(this);
		branchedEnvironments.add(childEnv);
		return childEnv;
	}
	
	
	public void putValue(Ident key, Expr value){
		
		if(parentValueMapContains(key)){
			//this key is already present in the parent environment,
			//so update the value there
			parentEnvironment.putValue(key, value);
		}else{
			//otherwise it's a new key, add it to this environment
			valueMap.put(key, value);
		}
	}

	
	public void putObservable(Ident key, Observable observable){
		observables.put(key, observable);
	}
	
	
	public void addObserver(Ident key, Observer observer){
		
		if(parentObservablesContains(key)){
			parentEnvironment.addObserver(key, observer);
		}else{
			observables.get(key).addObserver(observer);
		}
	}
	
}
