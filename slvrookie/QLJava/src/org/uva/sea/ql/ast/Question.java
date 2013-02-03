package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.StringLiteral;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.ITypeChecker;

public class Question extends FormElement {

	private final Ident name;
	private final StringLiteral label;
	private final Type type;

	public Question(Ident name, StringLiteral label, Type type) {
		this.name = name;
		this.label = label;
		this.type = type;
	}

	public Ident getQuestionName() {
		return name;
	}

	public StringLiteral getQuestionLabel() {
		return label;
	}

	public Type getQuestionType() {
		return type;
	}

	@Override
	public void accept(ITypeChecker TypeChecker) {
		TypeChecker.visit(this);
	}

}
