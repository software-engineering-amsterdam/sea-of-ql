package org.uva.sea.ql.evaluator.value.form;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.evaluator.value.Value;

public class Form extends Value {
	private final Ident ident;
	private final Questions questions;

	public Form( Ident ident, Questions questions ) {
		this.ident = ident;
		this.questions = questions;
	}

	public Questions getQuestions() {
		return this.questions;
	}

	@Override
	public Form getValue() {
		return this;
	}
}
