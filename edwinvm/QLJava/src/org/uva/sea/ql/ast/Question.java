package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.values.Str;

public class Question extends FormStatement {
	private final Str _label;
	private final Ident _identifier;
	private final Type _identifierType;

	public Question(Str questionLabel, Ident questionIdentifier, Type identifierType) {
		_label = questionLabel;
		_identifier = questionIdentifier;
		_identifierType = identifierType;
	}
	
	public Str getLabel() {
		return _label;
	}
	
	public Ident getIdentifier() {
		return _identifier;
	}
	
	public Type getIdentifierType() {
		return _identifierType;
	}
}