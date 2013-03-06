package org.uva.sea.ql.evaluate.render;

import java.util.Observable;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.value.Value;

public class Variable extends Observable {
	private Value value;

	public Variable( Value value ) {
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
