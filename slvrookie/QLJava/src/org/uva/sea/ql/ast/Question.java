package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.StringLiteral;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.TypeChecker;

public class Question extends FormElement {

	private final Ident qID;
	private final StringLiteral qString;
	private final Type qType;

	public Question(Ident qID, StringLiteral qString, Type qType) {
		this.qID = qID;
		this.qString = qString;
		this.qType = qType;
	}

	public Ident getQuestionID() {
		return qID;
	}

	public StringLiteral getQuestionString() {
		return qString;
	}

	public Type getQuestionType() {
		return qType;
	}

	@Override
	public void accept(TypeChecker visitor) {
		visitor.visit(this);
	}

}
