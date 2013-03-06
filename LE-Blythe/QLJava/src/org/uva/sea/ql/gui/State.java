package org.uva.sea.ql.gui;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.eval.value.Value;
import org.uva.sea.ql.util.Environment;

public class State {

	private Environment<Ident, Value> values;
	private Environment<Ident, Observable> observables;
	
	public State(Environment<Ident, Value> values, Environment<Ident, Observable> observables){
		this.values= values;
		this.observables = observables;
	}
	
	public State(){
		this.values = new Environment<Ident, Value>();
		this.observables = new Environment<Ident, Observable>();
	}
	
	
	public void putValue(Ident key, Value val){
		values.put(key, val);
	}
	
	
	public Value getValue(Ident key){
		return values.get(key);
	}
	
	
	public void putObservable(Ident key, Observable val){
		observables.put(key, val);
	}
	
	
	public void addObserver(Ident key, Observer val){
		observables.get(key).addObserver(val);
	}
	

	public Environment<Ident, Value> getValues(){
		return values;
	}
	
	
	public State branchState(){
		return new State(values.branchEnvironment(), observables.branchEnvironment());
	}
	
}
