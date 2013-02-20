package org.uva.sea.ql.evaluator.environment;

import java.util.Observable;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.value.Value;

public class Binding extends Observable {
	private Value value;

	public Binding( Value value ) {
		this.value = value;
		this.setChanged();
	}

	public void setValue( Value value ) {
		boolean isChanged = !this.value.equals( value );
		this.value = value;

		if ( isChanged ) {
			this.setChanged();
		}
	}

	public Type getType() {
		return this.value.getType();
	}

	public Value getValue() {
		return this.value;
	}
}
