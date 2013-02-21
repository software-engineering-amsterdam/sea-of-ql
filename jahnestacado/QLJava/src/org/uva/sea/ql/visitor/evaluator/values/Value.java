package org.uva.sea.ql.visitor.evaluator.values;

public abstract class Value {
	
	public abstract Object getValue();

	public boolean isIntValue(){
		return false;
	}
	
	public boolean isStrValue(){
		return false;
	}
	
	public boolean isDecValue(){
		return false;
	}
	
	public boolean isBoolValue(){
		return false;
	}
	
		
	
}
