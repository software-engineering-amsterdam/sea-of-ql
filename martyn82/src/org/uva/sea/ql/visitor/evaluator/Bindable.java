package org.uva.sea.ql.visitor.evaluator;

import java.util.Observable;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.evaluator.value.UndefinedValue;
import org.uva.sea.ql.visitor.evaluator.value.Value;

public class Bindable extends Observable {
	private Type type;
	private Value value;

	public Bindable( Type type ) {
		this.type = type;
		this.value = UndefinedValue.UNDEFINED;
	}

	public void setValue( Value value ) {
		this.value = value;
		this.setChanged();
	}

	public void setType( Type type ) {
		this.type = type;
	}

	public Type getType() {
		return this.type;
	}

	public Value getValue() {
		return this.value;
	}
}
