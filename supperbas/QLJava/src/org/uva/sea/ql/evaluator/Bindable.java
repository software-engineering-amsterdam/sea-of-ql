package org.uva.sea.ql.evaluator;

import java.util.Observable;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expression.Value;


public class Bindable extends Observable {

	private Type type;
	private Value value;
	private boolean defined = false;

	public Bindable(Type type) {
		this.type = type;
		this.value = type.accept(new TypeEvaluator());
		this.setChanged();
	}

	public void setValue(Value value) {
		this.value = value;
		this.defined = true;
		this.setChanged();
	}

	public Type getType() {
		return this.type;
	}

	public Value getValue() {
		return this.value;
	}
	
	public String getValueToString(){
		return this.value.getValue().toString();
	}

	public boolean isDefined() {
		return defined;
	}

	public void setType(Type type) {
		this.type = type;
		this.setChanged();
	}
}
