package org.uva.sea.ql.ast.statements.questions;

import org.uva.sea.ql.ast.values.Str;

public class QuestionLabel {
	private final Str _label;

	public QuestionLabel(Str label) {
		_label = label;
	}
	
	public Str getLabel() {
		return _label;
	}
}