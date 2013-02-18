package org.uva.sea.ql.ui.qlform.interpreter;

import java.util.Map;
import java.util.Observable;

import org.uva.sea.ql.ast.expr.values.Value;

public class VariableUpdater extends Observable{

	private  Map<String, Value> runTimeValues;

	public VariableUpdater(String varName, Map<String, Value> runTimeValues,Value value) {
		runTimeValues.put(varName, value);
		this.runTimeValues = runTimeValues;
		

	}
	
	
	public VariableUpdater() {


	}
	
	public void updateValues(String varName, Map<String, Value> runTimeValues,Value value) {
		runTimeValues.put(varName, value);
		this.runTimeValues = runTimeValues;
		informObservers();
	}
	
	
	public void informObservers(){
		setChanged();
		notifyObservers(this);
	}
	
	

	public Map<String, Value> getUpdatedValues() {
		return runTimeValues;
	}
	
	
	

}
