package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.values.Str;

public class ComputedQuestion {
	private final Str _label;
	private final Ident _identifier;
	private final Expr _computedResult;

	public ComputedQuestion(Str questionLabel, Ident questionIdentifier, Expr computedResult) {
		_label = questionLabel;
		_identifier = questionIdentifier;
		_computedResult = computedResult;
	}
	
	public Str getLabel() {
		return _label;
	}
	
	public Ident getIdentifier() {
		return _identifier;
	}
	
	public Expr getComputedResult() {
		return _computedResult;
	}
}