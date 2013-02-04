package org.uva.sea.ql.evaluator.value.form;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.evaluator.value.Value;

public class Question extends Value {
	private final String label;
	private final Ident ident;
	private final Value value;

	public Question( String label, Ident ident, Value value ) {
		this.label = label;
		this.ident = ident;
		this.value = value;
	}

	public String getLabel() {
		return this.label;
	}

	public Ident getIdent() {
		return this.ident;
	}

	@Override
	public Value getValue() {
		return this.value;
	}

}
